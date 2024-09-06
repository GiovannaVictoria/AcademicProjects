package ufscar.dc.compiladores.geradorLA;

import java.util.List;

public class GeradorC extends expressoesLABaseVisitor<String> {
    
    StringBuilder tabulacoes;
    StringBuilder saida;
    Escopos escoposAninhados;
    
    public GeradorC(Escopos escoposAninhados) {
        this.saida = new StringBuilder();          // guarda o codigo gerado
        this.tabulacoes = new StringBuilder();     // padroniza a tabulacao do codigo
        this.escoposAninhados = escoposAninhados;  // tabelas de simbolos geradas durante a analise semantica (reaproveitadas)
    }
    
    @Override
    public String visitPrograma(expressoesLAParser.ProgramaContext ctx) {
        saida.append("#include <stdio.h>\n");
        saida.append("#include <stdlib.h>\n");
        saida.append("\n");

        if (ctx.declaracoes() != null) {
            if (ctx.declaracoes().decl_local_global().size() > 0) {
                for (expressoesLAParser.Decl_local_globalContext c : ctx.declaracoes().decl_local_global()) {
                    visitDecl_local_global(c);
                }
                saida.append("\n");
            }
        }
        
        saida.append("int main() {\n");
        visitCorpo(ctx.corpo());
        saida.append(tabulacoes);
        saida.append("return 0;\n");
        if (tabulacoes.length() > 0) {
            tabulacoes.deleteCharAt(tabulacoes.length() - 1);
        }
        saida.append("}\n");
        
        return "nulo";
    }
    
    @Override
    public String visitCorpo(expressoesLAParser.CorpoContext ctx) {
        tabulacoes.append("\t");
        for (expressoesLAParser.Declaracao_localContext d : ctx.declaracao_local()) {
            visitDeclaracao_local(d);
        }
        for (expressoesLAParser.CmdContext c : ctx.cmd()) {
            myVisitCmd(c, null);
        }
        return "nulo";
    }
    
    @Override
    public String visitDecl_local_global(expressoesLAParser.Decl_local_globalContext ctx) {
        if (ctx.declaracao_local() != null) {
            visitDeclaracao_local(ctx.declaracao_local());
        } else {
            visitDeclaracao_global(ctx.declaracao_global());
        }
        return "nulo";
    }
    
    @Override
    public String visitDeclaracao_global(expressoesLAParser.Declaracao_globalContext ctx) {
        if (ctx.tipo_estendido() != null) {                    // eh funcao
            myVisitTipo_estendido(ctx.tipo_estendido(), null);   // retorno da funcao
        } else {                                               // eh procedimento
            saida.append("void ");                             // procedimento nao tem retorno
        }
        saida.append(ctx.IDENT().getText());                   // nome da funcao/procedimento
        saida.append("(");
        if (ctx.parametros() != null) {                        // parametros, se houver
            for (int i = 0; i < ctx.parametros().parametro().size() - 1; i++) {
                visitParametro(ctx.parametros().parametro(i));
                saida.append(", ");
            }
            visitParametro(ctx.parametros().parametro(ctx.parametros().parametro().size() - 1));
        }
        saida.append(") {\n");
        tabulacoes.append("\t");
        for (expressoesLAParser.Declaracao_localContext d : ctx.declaracao_local()) {
            visitDeclaracao_local(d);
        }
        for (expressoesLAParser.CmdContext c : ctx.cmd()) {
            myVisitCmd(c, ctx);
        }
        if (tabulacoes.length() > 0) {
            tabulacoes.deleteCharAt(tabulacoes.length() - 1);
        }
        saida.append(tabulacoes);
        saida.append("}\n");
        return "nulo";
    }
    
    @Override
    public String visitParametro(expressoesLAParser.ParametroContext ctx) {
        String tipo = myVisitTipo_estendido(ctx.tipo_estendido(), null);
        if (tipo.equals("char")) {                      // se o tipo for literal, eh preciso passar o parametro por referencia por ser um vetor
            saida.deleteCharAt(saida.length() - 1);
            saida.append("* ");
        }
        saida.append(ctx.identificador(0).getText());
        if (ctx.identificador().size() > 1) {           // pega os identificadores de mesmo tipo
            for (int i = 1; i < ctx.identificador().size(); i++) {
                saida.append(", ");
                saida.append(tipo);
                if (tipo.equals("char")) {
                    saida.deleteCharAt(saida.length() - 1);
                    saida.append("*");
                }
                saida.append(" ");
                saida.append(ctx.identificador(i).getText());
            }
        }
        return "nulo";
    }
    
    @Override
    public String visitDeclaracao_local(expressoesLAParser.Declaracao_localContext ctx) {
        if (ctx.variavel() != null) {
            visitVariavel(ctx.variavel());
        } else if (ctx.tipo_basico() != null) {
            saida.append("#define ");
            saida.append(ctx.IDENT().getText());
            saida.append(" ");
            saida.append(ctx.valor_constante().getText());
            saida.append("\n");
        } else {                                 // declaracao de tipo personalizado
            if (ctx.tipo().registro() != null) { // definicao de struct
                saida.append(tabulacoes);
                saida.append("typedef struct {\n");
                tabulacoes.append("\t");
                for (expressoesLAParser.VariavelContext v : ctx.tipo().registro().variavel()) {
                    visitVariavel(v);
                }
                if (tabulacoes.length() > 0) {
                    tabulacoes.deleteCharAt(tabulacoes.length() - 1);
                }
                saida.append(tabulacoes);
                saida.append("} ");
                saida.append(ctx.IDENT().getText());
                saida.append(";\n");
            } else {                            // definicao de tipo personalizado com tipo basico ou ident
                // nao tem casos de teste, fazer se der tempo
            }
        }
        return "nulo";
    }
    
    @Override
    public String visitVariavel(expressoesLAParser.VariavelContext ctx) {
        String cadeia;
        if (ctx.tipo().registro() != null) {                    // declaracao direta de um struct
            saida.append(tabulacoes);
            saida.append("struct {\n");
            tabulacoes.append("\t");
            for (expressoesLAParser.VariavelContext v : ctx.tipo().registro().variavel()) {
                visitVariavel(v);
            }
            if (tabulacoes.length() > 0) {
                tabulacoes.deleteCharAt(tabulacoes.length() - 1);
            }
            saida.append(tabulacoes);
            saida.append("} ");
            saida.append(ctx.identificador(0).getText());
            saida.append(";\n");
        } else {                                                // declaracao com tipo basico ou ident
            cadeia = myVisitTipo_estendido(ctx.tipo().tipo_estendido(), null);
            List<expressoesLAParser.IdentificadorContext> ids = ctx.identificador();
            for (int i = 0; i < ids.size() - 1; i++) {
                saida.append(ids.get(i).getText());
                if (cadeia.equals("char")) {                    // se for literal, obrigatoriamente eh um vetor
                    saida.append("[80]");
                }
                saida.append(", ");
            }
            saida.append(ids.get(ids.size() - 1).getText());
            if (cadeia.equals("char")) {
               saida.append("[80]");
            }
            saida.append(";\n");
        }
        return "nulo";
    }
    
    // modificacao do visitor de tipo_estendido
    // recebe uma string a mais caso o tipo a ser detectado seja um IDENT puro
    // retorna o tipo detectado da variavel
    public String myVisitTipo_estendido(expressoesLAParser.Tipo_estendidoContext ctx, String variavel) {
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        String texto = "nulo", tipo = "nulo";
        if (variavel != null) {
            tipo = escopoAtual.identificaTipo(escopoAtual.verificar(variavel), variavel);
        } else {
            if (ctx.tipo_basico_ident().tipo_basico() != null) {
                tipo = ctx.tipo_basico_ident().tipo_basico().getText();
            } else {
                tipo = ctx.tipo_basico_ident().IDENT().getText();
            }
        }
        switch (tipo) {
            case "literal":
                texto = "char";
                break;
            case "inteiro":
                texto = "int";
                break;
            case "real":
                texto = "float";
                break;
            case "logico":
                texto = "boolean";
                break;
            default:
                texto = tipo;
                break;
        }
        if (variavel == null) {
            saida.append(tabulacoes);
        }
        saida.append(texto);
        if (ctx != null) {
            if (ctx.getText().charAt(0) == '^') {
                saida.append("*");
            }
        }
        saida.append(" ");
        return texto;
    }
    
    // modificacao do visitor de cmd
    // recebe o context de declaracao_global para repassar para os comandos especificos
    // nao retorna nada, mas por padrao ao visitor retorna uma string nula
    public String myVisitCmd(expressoesLAParser.CmdContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb) {
        if (ctx.cmdLeia() != null) {
            myVisitCmdLeia(ctx.cmdLeia(), ctxglb);
        } else if (ctx.cmdEscreva() != null) {
            myVisitCmdEscreva(ctx.cmdEscreva(), ctxglb);
        } else if (ctx.cmdSe() != null) {
            myVisitCmdSe(ctx.cmdSe(), ctxglb);
        } else if (ctx.cmdCaso() != null) {
            myVisitCmdCaso(ctx.cmdCaso(), ctxglb);
        } else if (ctx.cmdPara() != null) {
            myVisitCmdPara(ctx.cmdPara(), ctxglb);
        } else if (ctx.cmdEnquanto() != null) {
            myVisitCmdEnquanto(ctx.cmdEnquanto(), ctxglb);
        } else if (ctx.cmdFaca() != null) {
            myVisitCmdFaca(ctx.cmdFaca(), ctxglb);
        } else if (ctx.cmdAtribuicao() != null) {
            myVisitCmdAtribuicao(ctx.cmdAtribuicao(), ctxglb);
        } else if (ctx.cmdChamada() != null) {
            myVisitCmdChamada(ctx.cmdChamada(), ctxglb);
        } else if (ctx.cmdRetorne() != null) {
            myVisitCmdRetorne(ctx.cmdRetorne(), ctxglb);
        }
        return "nulo";
    }
    
    // modificacao do visitor de cmdLeia
    // recebe o context de declaracao_global para repassar para as chamadas subsequentes
    // nao retorna nada, mas por padrao ao visitor retorna uma string nula
    public String myVisitCmdLeia(expressoesLAParser.CmdLeiaContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb) {
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        switch(escopoAtual.identificaTipo(escopoAtual.verificar(ctx.identificador(0).IDENT(0).getText()), ctx.identificador(0).IDENT(ctx.identificador(0).IDENT().size()-1).getText())) {
            case "literal":
                saida.append(tabulacoes);
                saida.append("gets(");
                break;
            case "inteiro":
                saida.append(tabulacoes);
                saida.append("scanf(\"%d\", &");
                break;
            case "real":
                saida.append(tabulacoes);
                saida.append("scanf(\"%f\", &");
                break;
            case "logico":
                // nao ha tipo logico em C
                break;
        }
        saida.append(ctx.identificador(0).getText());
        saida.append(");\n");
        return "nulo";
    }
    
    // modificacao do visitor de cmdEscreva
    // recebe o context de declaracao_global para repassar para as chamadas subsequentes
    // nao retorna nada, mas por padrao ao visitor retorna uma string nula
    public String myVisitCmdEscreva(expressoesLAParser.CmdEscrevaContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb) {
        String retorno;
        for (expressoesLAParser.ExpressaoContext e : ctx.expressao()) {
            saida.append(tabulacoes);
            saida.append("printf(\"");
            retorno = visitExpressao(e, ctxglb, "escreva");
            if (retorno.equals("literal")) {
                saida.append("\"");
            }
            saida.append(");\n");
        }
        return "nulo";
    }
    
    // modificacao do visitor de cmdSe
    // recebe o context de declaracao_global para repassar para as chamadas subsequentes
    // nao retorna nada, mas por padrao ao visitor retorna uma string nula
    public String myVisitCmdSe(expressoesLAParser.CmdSeContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb) {
        saida.append(tabulacoes);
        saida.append("if (");
        visitExpressao(ctx.expressao(), ctxglb, "se");
        saida.append(") {\n");
        tabulacoes.append("\t");
        for (expressoesLAParser.CmdContext c : ctx.cmdEntao) {
            myVisitCmd(c, ctxglb);
        }
        if (tabulacoes.length() > 0) {
            tabulacoes.deleteCharAt(tabulacoes.length() - 1);
        }
        saida.append(tabulacoes);
        saida.append("}");
        if (ctx.cmdSenao.size() > 0) {
            saida.append(" else {\n");
            saida.append("\t");
            for (expressoesLAParser.CmdContext c : ctx.cmdSenao) {
                myVisitCmd(c, ctxglb);
            }
//            if (tabulacoes.length() > 0) {
//               tabulacoes.deleteCharAt(tabulacoes.length() - 1);
//            }
            saida.append(tabulacoes);
            saida.append("}");
        }
        saida.append("\n");
        return "nulo";
    }
    
    // modificacao do visitor de cmdCaso
    // recebe o context de declaracao_global para repassar para as chamadas subsequentes
    // nao retorna nada, mas por padrao ao visitor retorna uma string nula
    public String myVisitCmdCaso(expressoesLAParser.CmdCasoContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb) {
        int num1 = 0, num2 = 0;
        saida.append(tabulacoes);
        saida.append("switch(");
        visitExp_aritmetica(ctx.exp_aritmetica(), ctxglb, "caso");
        saida.append(") {\n");
        tabulacoes.append("\t");
        for (expressoesLAParser.Item_selecaoContext item : ctx.selecao().item_selecao()) {
            for (expressoesLAParser.Numero_intervaloContext num : item.constantes().numero_intervalo()) {
                if (num.NUM_INT().size() == 1) {
                    saida.append(tabulacoes);
                    saida.append("case ");
                    if (num.op_unario().size() > 0) {
                        saida.append("-");
                    }
                    saida.append(num.NUM_INT(0));
                    saida.append(":\n");
                } else {
                    num1 = Integer.parseInt(num.NUM_INT(0).getText());
                    num2 = Integer.parseInt(num.NUM_INT(1).getText());
                    if (num.opUn1 != null) {
                        num1 *= -1;
                    }
                    if (num.opUn2 != null) {
                        num2 *= -1;
                    }
                    if (num1 < num2) {
                        for (int i = num1; i <= num2; i++) {
                            saida.append(tabulacoes);
                            saida.append("case ");
                            saida.append(i);
                            saida.append(":\n");
                        }
                    } else {
                        for (int i = num2; i <= num1; i++) {
                            saida.append(tabulacoes);
                            saida.append("case ");
                            saida.append(i);
                            saida.append(":\n");
                        }
                    }
                }
            }
            tabulacoes.append("\t");
            for (expressoesLAParser.CmdContext c : item.cmd()) {
                myVisitCmd(c, ctxglb);
            }
            saida.append(tabulacoes);
            saida.append("break;\n");
            if (tabulacoes.length() > 0) {
               tabulacoes.deleteCharAt(tabulacoes.length() - 1);
            }
        }
        if (ctx.cmd().size() > 0) {
            saida.append(tabulacoes);
            saida.append("default:\n");
            tabulacoes.append("\t");
            for (expressoesLAParser.CmdContext c : ctx.cmd()) {
                myVisitCmd(c, ctxglb);
            }
            saida.append(tabulacoes);
            saida.append("break;\n");
            if (tabulacoes.length() > 0) {
                tabulacoes.deleteCharAt(tabulacoes.length() - 1);
            }
        }
        if (tabulacoes.length() > 0) {
            tabulacoes.deleteCharAt(tabulacoes.length() - 1);
        }
        saida.append(tabulacoes);
        saida.append("}\n");
        return "nulo";
    }
    
    // modificacao do visitor de cmdPara
    // recebe o context de declaracao_global para repassar para as chamadas subsequentes
    // nao retorna nada, mas por padrao ao visitor retorna uma string nula
    public String myVisitCmdPara(expressoesLAParser.CmdParaContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb) {
        saida.append(tabulacoes);
        saida.append("for(");
        myVisitTipo_estendido(null, ctx.IDENT().getText());
        saida.append(ctx.IDENT().getText());
        saida.append(" = ");
        visitExp_aritmetica(ctx.exp_aritmetica(0), null, "para");
        saida.append("; ");
        saida.append(ctx.IDENT().getText());
        saida.append(" <= ");
        visitExp_aritmetica(ctx.exp_aritmetica(1), null, "para");
        saida.append("; ");
        saida.append(ctx.IDENT().getText());
        saida.append("++) {\n");
        tabulacoes.append("\t");
        for (expressoesLAParser.CmdContext c : ctx.cmd()) {
            myVisitCmd(c, null);
        }
        if (tabulacoes.length() > 0) {
            tabulacoes.deleteCharAt(tabulacoes.length() - 1);
        }
        saida.append(tabulacoes);
        saida.append("}\n");
        return "nulo";
    }
    
    // modificacao do visitor de cmdEnquanto
    // recebe o context de declaracao_global para repassar para as chamadas subsequentes
    // nao retorna nada, mas por padrao ao visitor retorna uma string nula
    public String myVisitCmdEnquanto(expressoesLAParser.CmdEnquantoContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb) {
        saida.append(tabulacoes);
        saida.append("while(");
        visitExpressao(ctx.expressao(), null, "enquanto");
        saida.append(") {\n");
        tabulacoes.append("\t");
        for (expressoesLAParser.CmdContext c : ctx.cmd()) {
            myVisitCmd(c, null);
        }
        if (tabulacoes.length() > 0) {
            tabulacoes.deleteCharAt(tabulacoes.length() - 1);
        }
        saida.append(tabulacoes);
        saida.append("}\n");
        return "nulo";
    }
    
    // modificacao do visitor de cmdFaca
    // recebe o context de declaracao_global para repassar para as chamadas subsequentes
    // nao retorna nada, mas por padrao ao visitor retorna uma string nula
    public String myVisitCmdFaca(expressoesLAParser.CmdFacaContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb) {
        saida.append(tabulacoes);
        saida.append("do {\n");
        tabulacoes.append("\t");
        for (expressoesLAParser.CmdContext c : ctx.cmd()) {
            myVisitCmd(c, null);
        }
        if (tabulacoes.length() > 0) {
            tabulacoes.deleteCharAt(tabulacoes.length() - 1);
        }
        saida.append(tabulacoes);
        saida.append("} while(");
        visitExpressao(ctx.expressao(), null, "faca");
        saida.append(");\n");
        return "nulo";
    }
    
    // modificacao do visitor de cmdAtribuicao
    // recebe o context de declaracao_global para repassar para as chamadas subsequentes
    // nao retorna nada, mas por padrao ao visitor retorna uma string nula
    public String myVisitCmdAtribuicao(expressoesLAParser.CmdAtribuicaoContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb) {
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        String tipo = escopoAtual.identificaTipo(escopoAtual.verificar(ctx.identificador().IDENT(0).getText()), ctx.identificador().IDENT(ctx.identificador().IDENT().size() - 1).getText());
        if (tipo.equals("literal")) {
            saida.append(tabulacoes);
            saida.append("strcpy(");
            saida.append(ctx.identificador().getText());
            saida.append(", ");
            visitExpressao(ctx.expressao(), null, "atribuicao");
            saida.append(");\n");
        } else {
            saida.append(tabulacoes);
            if (ctx.getText().charAt(0) == '^') {
                saida.append("*");
            }
            saida.append(ctx.identificador().getText());
            saida.append(" = ");
            if (tipo != null) {
                if (tipo.equals("p_inteiro") || tipo.equals("p_real") || tipo.equals("p_literal") || tipo.equals("p_logico")) {
                    if (ctx.getText().charAt(0) != '^') {
                        saida.append("&");
                    }
                }
            }
            visitExpressao(ctx.expressao(), null, "atribuicao");
            saida.append(";\n");
        }
        return "nulo";
    }
    
    // modificacao do visitor de cmdChamada
    // recebe o context de declaracao_global para repassar para as chamadas subsequentes
    // nao retorna nada, mas por padrao ao visitor retorna uma string nula
    public String myVisitCmdChamada(expressoesLAParser.CmdChamadaContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb) {
        saida.append(tabulacoes);
        saida.append(ctx.IDENT().getText());
        saida.append("(");
        for (int i = 0; i < ctx.expressao().size() - 1; i++) {
            visitExpressao(ctx.expressao(i), null, "chamada");
            saida.append(", ");
        }
        visitExpressao(ctx.expressao(ctx.expressao().size() - 1), null, "chamada");
        saida.append(");\n");
        return "nulo";
    }
    
    // modificacao do visitor de cmdRetorne
    // recebe o context de declaracao_global para repassar para as chamadas subsequentes
    // nao retorna nada, mas por padrao ao visitor retorna uma string nula
    public String myVisitCmdRetorne(expressoesLAParser.CmdRetorneContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb) {
        saida.append(tabulacoes);
        saida.append("return ");
        visitExpressao(ctx.expressao(), null, "retorne");
        saida.append(";\n");
        return "nulo";
    }
    
    // modificacao do visitor de expressao
    // recebe o context de declaracao_global e uma string indicando de qual
    // comando a ordem foi recebida para repassar para as chamadas subsequentes
    // retorna o tipo da expressao vindo de termo logico (variavel, funcao, numero, ou nulo)
    public String visitExpressao(expressoesLAParser.ExpressaoContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb, String comando) {
        for (int i = 0; i < ctx.termo_logico().size() - 1; i++) {
            visitTermo_logico(ctx.termo_logico(i), ctxglb, comando);
            saida.append(" || ");
        }
        return visitTermo_logico(ctx.termo_logico(ctx.termo_logico().size() - 1), ctxglb, comando);
    }
    
    // modificacao do visitor de termo_logico
    // recebe o context de declaracao_global e uma string indicando de qual
    // comando a ordem foi recebida para repassar para as chamadas subsequentes
    // retorna o tipo do termo logico vindo de fator logico (variavel, funcao, numero, ou nulo)
    public String visitTermo_logico(expressoesLAParser.Termo_logicoContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb, String comando) {
        for (int i = 0; i < ctx.fator_logico().size() - 1; i++) {
            visitFator_logico(ctx.fator_logico(i), ctxglb, comando);
            saida.append(" && ");
        }
        return visitFator_logico(ctx.fator_logico(ctx.fator_logico().size() - 1), ctxglb, comando);
    }
    
    // modificacao do visitor de fator_logico
    // recebe o context de declaracao_global e uma string indicando de qual
    // comando a ordem foi recebida para repassar para as chamadas subsequentes
    // retorna o tipo do fator logico vindo de parcela logica (variavel, funcao, numero, ou nulo)
    public String visitFator_logico(expressoesLAParser.Fator_logicoContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb, String comando) {
        if (ctx.getText().length() > 2) {
            if (ctx.getText().substring(0, 3).equals("nao")) {
                saida.append("!");
            }
        }
        return visitParcela_logica(ctx.parcela_logica(), ctxglb, comando);
    }
    
    // modificacao do visitor de parcela_logica
    // recebe o context de declaracao_global e uma string indicando de qual
    // comando a ordem foi recebida para repassar para as chamadas subsequentes
    // retorna o tipo da parcela logica vindo de expressao relacional (variavel, funcao, numero, ou nulo)
    public String visitParcela_logica(expressoesLAParser.Parcela_logicaContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb, String comando) {
        if (ctx.exp_relacional() != null) {
            return visitExp_relacional(ctx.exp_relacional(), ctxglb, comando);
        } else {
            if (ctx.getText().equals("verdadeiro")) {
                // nao ha boolean em C
            } else {
                // nao ha boolean em C
            }
        }
        return "nulo";
    }
    
    // modificacao do visitor de exp_relacional
    // recebe o context de declaracao_global e uma string indicando de qual
    // comando a ordem foi recebida para repassar para as chamadas subsequentes
    // retorna o tipo da expressao relacional vindo de expressao arimetica (variavel, funcao, numero, ou nulo)
    public String visitExp_relacional(expressoesLAParser.Exp_relacionalContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb, String comando) {
        String retorno;
        retorno = visitExp_aritmetica(ctx.exp_aritmetica(0), ctxglb, comando);
        if (ctx.exp_aritmetica().size() > 1) {
            switch(ctx.op_relacional().getText()) {
                case "=":
                    saida.append(" == ");
                    break;
                case "<>":
                    saida.append(" != ");
                    break;
                default:
                    saida.append(" ");
                    saida.append(ctx.op_relacional().getText());
                    saida.append(" ");
            }
            retorno = visitExp_aritmetica(ctx.exp_aritmetica(1), ctxglb, comando);
        }
        return retorno;
    }
    
    // modificacao do visitor de exp_aritmetica
    // recebe o context de declaracao_global e uma string indicando de qual
    // comando a ordem foi recebida para repassar para as chamadas subsequentes
    // retorna o tipo da expressao aritmetica vindo de termo (variavel, funcao, numero, ou nulo)
    public String visitExp_aritmetica(expressoesLAParser.Exp_aritmeticaContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb, String comando) {
        for (int i = 0; i < ctx.termo().size() - 1; i++) {
            visitTermo(ctx.termo(i), ctxglb, comando);
            saida.append(" ");
            saida.append(ctx.op1(i).getText());
            saida.append(" ");
        }
        return visitTermo(ctx.termo(ctx.termo().size() - 1), ctxglb, comando);
    }
    
    // modificacao do visitor de termo
    // recebe o context de declaracao_global e uma string indicando de qual
    // comando a ordem foi recebida para repassar para as chamadas subsequentes
    // retorna o tipo do termo vindo de fator (variavel, funcao, numero, ou nulo)
    public String visitTermo(expressoesLAParser.TermoContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb, String comando) {
        for (int i = 0; i < ctx.fator().size() - 1; i++) {
            visitFator(ctx.fator(i), ctxglb, comando);
            saida.append(" ");
            saida.append(ctx.op2(i).getText());
            saida.append(" ");
        }
        return visitFator(ctx.fator(ctx.fator().size() - 1), ctxglb, comando);
    }
    
    // modificacao do visitor de fator
    // recebe o context de declaracao_global e uma string indicando de qual
    // comando a ordem foi recebida para repassar para as chamadas subsequentes
    // retorna o tipo do fator vindo de parcela (variavel, funcao, numero, ou nulo)
    public String visitFator(expressoesLAParser.FatorContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb, String comando) {
        for (int i = 0; i < ctx.parcela().size() - 1; i++) {
            visitParcela(ctx.parcela(i), ctxglb, comando);
            saida.append(" % ");
        }
        return visitParcela(ctx.parcela(ctx.parcela().size() - 1), ctxglb, comando);
    }
    
    // modificacao do visitor de parcela
    // recebe o context de declaracao_global e uma string indicando de qual
    // comando a ordem foi recebida para repassar para as chamadas subsequentes
    // retorna o tipo da parcela vinda de parcela nao unario ou parcela unario (variavel, funcao, numero, ou nulo)
    public String visitParcela(expressoesLAParser.ParcelaContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb, String comando) {
        if (ctx.parcela_unario() != null) {
            return visitParcela_unario(ctx.parcela_unario(), ctxglb, comando);
        } else {
            return visitParcela_nao_unario(ctx.parcela_nao_unario(), ctxglb, comando);
        }
    }
    
    // modificacao do visitor de parcela_unario
    // recebe o context de declaracao_global para identificar o tipo de uma funcao global, se for o caso
    // e recebe uma string indicando de qual comando a ordem foi recebida para adequar a saida na tela caso necessario
    // retorna o tipo da parcela unario (variavel, funcao, numero, ou nulo)
    public String visitParcela_unario(expressoesLAParser.Parcela_unarioContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb, String comando) {
        String retorno = "nulo", tipo = "invalido";
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (ctx.IDENT() != null) {
            if (escopoAtual.verificar(ctx.IDENT().getText()).get(0).tipo.equals("funcao")) {
                if (saida.indexOf("%", saida.lastIndexOf("printf")) == -1) {
                    if (comando.equals("escreva")) {
                        switch (escopoAtual.verificar(ctx.IDENT().getText()).get(1).tipo) {
                            case "literal":
                                saida.append("%s\", ");
                                break;
                            case "inteiro":
                                saida.append("%d\", ");
                                break;
                            case "real":
                                saida.append("%f\", ");
                                break;
                            case "logico":
                                // nao ha tipo logico em C
                                break;
                        }
                    }
                }
            }
            saida.append(ctx.IDENT().getText());
            saida.append("(");
            for (expressoesLAParser.ExpressaoContext e : ctx.expId) {
                visitExpressao(e, ctxglb, comando);
            }
            saida.append(")");
            retorno = "funcao";
        } else if (ctx.identificador() != null) {
            if (escopoAtual.verificar(ctx.identificador().IDENT(0).getText()) != null) {
                tipo = escopoAtual.identificaTipo(escopoAtual.verificar(ctx.identificador().IDENT(0).getText()), ctx.identificador().IDENT(ctx.identificador().IDENT().size() - 1).getText());
            } else if (ctxglb != null) {
                if (escopoAtual.verificar(ctxglb.IDENT().getText()) != null) {
                    if (escopoAtual.contem(escopoAtual.verificar(ctxglb.IDENT().getText()), ctx.identificador().IDENT(0).getText())) {
                        tipo = escopoAtual.identificaTipo(escopoAtual.verificar(ctxglb.IDENT().getText()), ctx.identificador().IDENT(ctx.identificador().IDENT().size() - 1).getText());
                    }
                }
            }
            if (saida.indexOf("%", saida.lastIndexOf("printf")) == -1) {
                if (comando.equals("escreva")) {
                    switch (tipo) {
                        case "literal":
                            saida.append("%s\", ");
                            break;
                        case "inteiro":
                            saida.append("%d\", ");
                            break;
                        case "real":
                            saida.append("%f\", ");
                            break;
                        case "logico":
                            // nao ha tipo logico em C
                            break;
                    }
                }
            }
            if (tipo.equals("ponteiro")) {
                saida.append("&");
            }
            saida.append(ctx.identificador().getText());
            retorno = "variavel";
        } else if (ctx.expAv != null) {
            saida.append("(");
            retorno = visitExpressao(ctx.expAv, ctxglb, comando);
            saida.append(")");
        } else {
            saida.append(ctx.getText());
            retorno = "numero";
        }
        return retorno;
    }
    
    // modificacao do visitor de parcela_nao_unario
    // recebe o context de declaracao_global para identificar o tipo de uma funcao global, se for o caso
    // e recebe uma string indicando de qual comando a ordem foi recebida para adequar a saida na tela caso necessario
    // retorna o tipo da parcela nao unario (variavel, funcao, numero, ou nulo)
    public String visitParcela_nao_unario(expressoesLAParser.Parcela_nao_unarioContext ctx, expressoesLAParser.Declaracao_globalContext ctxglb, String comando) {
        String tipo = "invalido";
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (ctx.CADEIA() != null) {
            if (comando.equals("chamada") || comando.equals("atribuicao")) {
                saida.append("\"");
                saida.append(ctx.CADEIA().getText().substring(1, ctx.CADEIA().getText().length() - 1));
                saida.append("\"");
            } else {
                saida.append(ctx.CADEIA().getText().substring(1, ctx.CADEIA().getText().length() - 1));
            }
            return "literal";
        } else {
            if (escopoAtual.verificar(ctx.identificador().IDENT(0).getText()) != null) {
                tipo = escopoAtual.identificaTipo(escopoAtual.verificar(ctx.identificador().IDENT(0).getText()), ctx.identificador().IDENT(ctx.identificador().IDENT().size() - 1).getText());
            } else if (escopoAtual.verificar(ctxglb.IDENT().getText()) != null) {
                if (escopoAtual.contem(escopoAtual.verificar(ctxglb.IDENT().getText()), ctx.identificador().IDENT(0).getText())) {
                    tipo = escopoAtual.identificaTipo(escopoAtual.verificar(ctxglb.IDENT().getText()), ctx.identificador().IDENT(ctx.identificador().IDENT().size() - 1).getText());
                }
            }
            if (saida.indexOf("%", saida.lastIndexOf("printf")) == -1) {
                if (comando.equals("escreva")) {
                    switch (tipo) {
                        case "literal":
                            saida.append("%s\", ");
                            break;
                        case "inteiro":
                            saida.append("%d\", ");
                            break;
                        case "real":
                            saida.append("%f\", ");
                            break;
                        case "logico":
                            // nao ha tipo logico em C
                            break;
                    }
                }
            }
            if (tipo.equals("ponteiro")) {
                saida.append("&");
            }
            saida.append(ctx.identificador().getText());
            return "variavel";
        }
    }
    
}
