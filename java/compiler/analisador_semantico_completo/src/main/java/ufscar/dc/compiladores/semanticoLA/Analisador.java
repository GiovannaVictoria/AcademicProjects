package ufscar.dc.compiladores.semanticoLA;

import java.util.List;

public class Analisador extends expressoesLABaseVisitor<String> {

    Escopos escoposAninhados;

    @Override
    public String visitPrograma(expressoesLAParser.ProgramaContext ctx) {
        escoposAninhados = new Escopos();
        return super.visitPrograma(ctx);
    }
    
    @Override
    public String visitDeclaracoes(expressoesLAParser.DeclaracoesContext ctx) {
        return super.visitDeclaracoes(ctx);
    }
    
    @Override
    public String visitDecl_local_global(expressoesLAParser.Decl_local_globalContext ctx) {
        return super.visitDecl_local_global(ctx);
    }
    
    @Override
    public String visitCorpo(expressoesLAParser.CorpoContext ctx) {
        for (expressoesLAParser.CmdContext c : ctx.cmd()) {
            // na linguagem LA, a main nao tem retorno
            if (c.cmdRetorne() != null) {
                UtilsLA.adicionarErroSemantico(c.start, "comando retorne nao permitido nesse escopo\n");
            }
        }
        return super.visitCorpo(ctx);
    }
    
    @Override // nao ha retorno
    public String visitDeclaracao_global (expressoesLAParser.Declaracao_globalContext ctx) {
        
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        
        // verificando se o nome dado para a funcao/procedimento ja foi declarado em outro contexto
        if (escopoAtual.existe(ctx.IDENT().getText())) {
            UtilsLA.adicionarErroSemantico(ctx.start, "identificador " + ctx.IDENT().getText() + " ja declarado anteriormente\n");
        } else {
            
            if (ctx.tipo_estendido() != null) {                                                                  // verifica se eh funcao
                escopoAtual.inserir(ctx.IDENT().getText(), ctx.IDENT().getText(), "funcao");                     // adiciona uma label identificando que eh funcao
                    if (ctx.tipo_estendido().tipo_basico_ident().tipo_basico() != null) {
                        escolherTipo(escopoAtual, ctx.tipo_estendido().tipo_basico_ident().tipo_basico().getText(), ctx.IDENT().getText(), "retorno", false, false);                      
                    } else {
                        // funcao com retorno do tipo ident; nao tem nenhum caso de teste, fazer se der tempo
                    }                 
            } else {                                                                                             // aqui eh procedimento
                escopoAtual.inserir(ctx.IDENT().getText(), ctx.IDENT().getText(), "procedimento");               // adiciona uma label indicando que eh procedimento
                escopoAtual.inserir(ctx.IDENT().getText(), "retorno", "void");                                   // como eh procedimento, nao ha retorno
                for (expressoesLAParser.CmdContext c : ctx.cmd()) {
                    if (c.cmdRetorne() != null) {                                                                // verifica se ha um return nao permitido
                        UtilsLA.adicionarErroSemantico(c.start, "comando retorne nao permitido nesse escopo\n");
                    }
                }
            }
        
            if (ctx.parametros() != null) {               
                List<expressoesLAParser.ParametroContext> ps = ctx.parametros().parametro();                     // pega todos os parametros, se houver
                for (expressoesLAParser.ParametroContext p : ps) {
                    List<expressoesLAParser.IdentificadorContext> ids = p.identificador();                       // pega todos os identificadores de cada parametro
                    for (expressoesLAParser.IdentificadorContext i : ids) {
                        if (p.tipo_estendido().tipo_basico_ident().tipo_basico() != null) {
                            escolherTipo(escopoAtual, p.tipo_estendido().tipo_basico_ident().tipo_basico().getText(), ctx.IDENT().getText(), i.IDENT(0).getText(), false, false);
                        } else { // aqui, o parametro adicionado eh de um tipo nao basico
                            
                            // verificando se o tipo nao basico foi declarado
                            if (!escopoAtual.existe(p.tipo_estendido().tipo_basico_ident().IDENT().getText())) {
                                UtilsLA.adicionarErroSemantico(p.start, "tipo " + p.tipo_estendido().tipo_basico_ident().IDENT().getText() + " nao declarado\n");
                            } else {
                                // verificando se o tipo nao basico eh registro
                                if (escopoAtual.verificar(p.tipo_estendido().tipo_basico_ident().IDENT().getText()).get(0).nome.equals("registro")) {
                                    escopoAtual.inserir(ctx.IDENT().getText(), i.IDENT(0).getText(), escopoAtual.verificar(p.tipo_estendido().tipo_basico_ident().IDENT().getText()).get(0).tipo);
                                } else {
                                    // o tipo nao basico eh IDENT nao registro - nao ha casos de teste
                                }
                            }
                        }   
                    }
                }           
            }
            
        }
        return null;
        
    }

    @Override // nao ha retorno
    public String visitDeclaracao_local(expressoesLAParser.Declaracao_localContext ctx) {
        
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        
        // declaracao de variavel local
        if (ctx.variavel() != null) {
            visitVariavel(ctx.variavel());
        } else { // declaracao de constante ou tipo     
            // verificando se a constante ou o tipo ja nao foram declarados
            if (escopoAtual.existe(ctx.IDENT().getText())) {
                UtilsLA.adicionarErroSemantico(ctx.start, "identificador " + ctx.IDENT().getText() + " ja declarado anteriormente\n");
            } else {
                // declaracao de tipo personalizado - registro ou IDENT
                if (ctx.tipo() != null) {
                    visitTipoPersonalizado(ctx.tipo(), ctx.IDENT().getText());
                } else {
                    // declaracao de constante - apenas tipo basico
                    escolherTipo(escopoAtual, ctx.tipo_basico().getText(), ctx.IDENT().getText(), ctx.IDENT().getText(), false, false);
                }
            }
        }
        return null; // declaracao não tem valor
        
    }
    
    @Override // nao ha retorno
    public String visitVariavel (expressoesLAParser.VariavelContext ctx) {
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        List<expressoesLAParser.IdentificadorContext> identificadores1 = ctx.identificador();             // pega todos os identificadores sendo declarados de uma vez
        for (expressoesLAParser.IdentificadorContext ids1 : identificadores1) {
            // verificando se o identificador ja nao foi declarado antes
            if (escopoAtual.existe(ids1.IDENT(0).getText())) {
                UtilsLA.adicionarErroSemantico(ids1.start, "identificador " + ids1.IDENT(0).getText() + " ja declarado anteriormente\n");
            } else {
                // declaracao efetiva de variavel
                visitTipoNormal(ctx.tipo(), ids1);
            }
        }
        return null;
    }
    
    // declara variaveis de tipo basico, tipo IDENT, e registros; nao ha retorno
    public String visitTipoNormal (expressoesLAParser.TipoContext t_ctx, expressoesLAParser.IdentificadorContext i_ctx) {
        
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (t_ctx.tipo_estendido() != null) {
            if (t_ctx.tipo_estendido().tipo_basico_ident().tipo_basico() != null) {
                escolherTipo(escopoAtual, t_ctx.tipo_estendido().tipo_basico_ident().tipo_basico().getText(), i_ctx.IDENT(0).getText(), i_ctx.IDENT(0).getText(), false, false);
            } else {  // variavel sera declarada do tipo IDENT
                
                // verificando se o tipo IDENT foi declarado
                if (escopoAtual.existe((t_ctx.tipo_estendido().tipo_basico_ident().IDENT().getText()))) {
                    if (escopoAtual.verificar(t_ctx.tipo_estendido().tipo_basico_ident().IDENT().getText()).get(0).nome.equals("registro")) {              // verificando se eh registro
                        List<EntradaTabelaSimbolos> variaveis = escopoAtual.verificar(t_ctx.tipo_estendido().tipo_basico_ident().IDENT().getText());       // pegando cada variavel declarada no registro
                        for (int i = 0; i < variaveis.size(); i++) {
                            EntradaTabelaSimbolos identificadores2 = variaveis.get(i);
                            if (i == 0) {
                                escopoAtual.inserir(i_ctx.IDENT(0).getText(), "registro", t_ctx.tipo_estendido().tipo_basico_ident().IDENT().getText());   // adicionando uma flag que indica que a variavel eh registro
                            } else {
                                switch (identificadores2.tipo) {                                                                    // verifica se a variavel eh tipo basico
                                    case "inteiro":
                                        escopoAtual.inserir(i_ctx.IDENT(0).getText(), identificadores2.nome, "inteiro");
                                        break;
                                    case "real":
                                        escopoAtual.inserir(i_ctx.IDENT(0).getText(), identificadores2.nome, "real");
                                        break;
                                    case "logico":
                                        escopoAtual.inserir(i_ctx.IDENT(0).getText(), identificadores2.nome, "logico");
                                        break;
                                    case "literal":
                                        escopoAtual.inserir(i_ctx.IDENT(0).getText(), identificadores2.nome, "literal");
                                        break;
                                    case "registro":
                                        break;
                                    default:
                                        switch(identificadores2.tipo) {                                                             // verificando se a variavel eh um tipo personalizado
                                            case "t_inteiro":
                                                escopoAtual.inserir(i_ctx.IDENT(0).getText(), identificadores2.nome, "inteiro");
                                                break;
                                            case "t_real":
                                                escopoAtual.inserir(i_ctx.IDENT(0).getText(), identificadores2.nome, "real");
                                                break;
                                            case "t_logico":
                                                escopoAtual.inserir(i_ctx.IDENT(0).getText(), identificadores2.nome, "logico");
                                                break;
                                            case "t_literal":
                                                escopoAtual.inserir(i_ctx.IDENT(0).getText(), identificadores2.nome, "literal");
                                                break;
                                            case "registro":
                                                break;
                                            default:
                                                if (!escopoAtual.existe(identificadores2.tipo)) {
                                                    UtilsLA.adicionarErroSemantico(t_ctx.start, "tipo " + identificadores2.tipo + " nao declarado\n");
                                                }
                                                break;
                                        }
                                }
                            }
                        }
                        
                    } else { // o tipo eh IDENT mas nao eh registro
                        if (!escolherTipo(escopoAtual, escopoAtual.verificar(t_ctx.tipo_estendido().tipo_basico_ident().IDENT().getText()).get(0).tipo, i_ctx.IDENT(0).getText(), i_ctx.IDENT(0).getText(), true, false)) {
                            escopoAtual.inserir(i_ctx.IDENT(0).getText(), i_ctx.IDENT(0).getText(), "invalido");
                            UtilsLA.adicionarErroSemantico(t_ctx.tipo_estendido().tipo_basico_ident().start, "tipo " + escopoAtual.verificar(t_ctx.tipo_estendido().tipo_basico_ident().IDENT().getText()).get(0).tipo + " nao declarado\n");
                        }
                    }
                } else {
                    escopoAtual.inserir(i_ctx.IDENT(0).getText(), i_ctx.IDENT(0).getText(), "invalido");
                    UtilsLA.adicionarErroSemantico(t_ctx.tipo_estendido().tipo_basico_ident().start, "tipo " + t_ctx.tipo_estendido().tipo_basico_ident().IDENT().getText() + " nao declarado\n");
                }
            }
        } else {  // declarando a variavel diretamente como um registro
            // verificando se a variavel ja nao foi declarada
            if (escopoAtual.existe(i_ctx.IDENT(0).getText())) {
                UtilsLA.adicionarErroSemantico(i_ctx.start, "identificador " + i_ctx.IDENT(0).getText() + " ja declarado anteriormente\n");
            } else {
                boolean passou = false;
                // adicionando todos os identificadores e seus respectivos tipo a variavel
                List<expressoesLAParser.VariavelContext> variaveis = t_ctx.registro().variavel();
                for (int i = 0; i < variaveis.size(); i++) {
                    List<expressoesLAParser.IdentificadorContext> identificadores2 = variaveis.get(i).identificador();
                    for (int j = 0; j < identificadores2.size(); j++) {
                        if (escopoAtual.existe(identificadores2.get(j).IDENT(0).getText())) {
                            UtilsLA.adicionarErroSemantico(identificadores2.get(j).start, "identificador " + identificadores2.get(j).IDENT(0).getText() + " ja declarado anteriormente\n");
                        } else {
                            if (variaveis.get(i).tipo().tipo_estendido() != null) {
                                // adicionando uma flag que indica que a variavel eh registro
                                if (!passou) {
                                    escopoAtual.inserir(i_ctx.IDENT(0).getText(), "registro", i_ctx.IDENT(0).getText());
                                    passou = true;
                                }
                                if (variaveis.get(i).tipo().tipo_estendido().tipo_basico_ident().tipo_basico() != null) { // a variavel dentro do registro eh do tipo basico
                                    escolherTipo(escopoAtual, variaveis.get(i).tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText(), i_ctx.IDENT(0).getText(), identificadores2.get(j).IDENT(0).getText(), false, false);
                                } else { // a variavel dentro do registro eh do tipo IDENT
                                    if (escopoAtual.existe((variaveis.get(i).tipo().tipo_estendido().tipo_basico_ident().IDENT().getText()))) {
                                        if (!escolherTipo(escopoAtual, escopoAtual.verificar(variaveis.get(i).tipo().tipo_estendido().tipo_basico_ident().IDENT().getText()).get(0).tipo, i_ctx.IDENT(0).getText(), identificadores2.get(j).IDENT(0).getText(), true, false)) {
                                            escopoAtual.inserir(i_ctx.IDENT(0).getText(), identificadores2.get(j).IDENT(0).getText(), "invalido");
                                            UtilsLA.adicionarErroSemantico(t_ctx.tipo_estendido().tipo_basico_ident().start, "tipo " + escopoAtual.verificar(t_ctx.tipo_estendido().tipo_basico_ident().IDENT().getText()).get(0).tipo + " nao declarado\n");    
                                        }
                                    } else {
                                        escopoAtual.inserir(i_ctx.getText(), i_ctx.getText(), "invalido");
                                        UtilsLA.adicionarErroSemantico(variaveis.get(i).tipo().tipo_estendido().tipo_basico_ident().start, "tipo " + variaveis.get(i).tipo().tipo_estendido().tipo_basico_ident().IDENT().getText() + " nao declarado\n");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    
    // declara tipos personalizados e bases de registros; nao ha retorno
    public String visitTipoPersonalizado (expressoesLAParser.TipoContext t_ctx, String ident) {
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (t_ctx.tipo_estendido() != null) {
            if (t_ctx.tipo_estendido().tipo_basico_ident().tipo_basico() != null) {            // declarando um tipo IDENT direto de um tipo basico
                escolherTipo(escopoAtual, t_ctx.tipo_estendido().tipo_basico_ident().tipo_basico().getText(), ident, ident, false, true);
            } else {                                                                           // declarando um tipo IDENT a partir de outro tipo IDENT
                if (escopoAtual.existe((t_ctx.tipo_estendido().tipo_basico_ident().IDENT().getText()))) {
                    if (!escolherTipo(escopoAtual, escopoAtual.verificar(t_ctx.tipo_estendido().tipo_basico_ident().IDENT().getText()).get(0).tipo, ident, ident, true, true)) {
                        escopoAtual.inserir(ident, ident, "invalido");
                        UtilsLA.adicionarErroSemantico(t_ctx.tipo_estendido().tipo_basico_ident().start, "tipo " + escopoAtual.verificar(t_ctx.tipo_estendido().tipo_basico_ident().IDENT().getText()).get(0).tipo + " nao declarado\n");    
                    }
                } else {
                    escopoAtual.inserir(ident, ident, "invalido");
                    UtilsLA.adicionarErroSemantico(t_ctx.tipo_estendido().tipo_basico_ident().start, "tipo " + t_ctx.tipo_estendido().tipo_basico_ident().IDENT().getText() + " nao declarado\n");
                }
            }
        } else {  // declarando a base de um registro
            if (escopoAtual.existe(ident)) {
                UtilsLA.adicionarErroSemantico(t_ctx.start, "identificador " + ident + " ja declarado anteriormente\n");
            } else {
                List<expressoesLAParser.VariavelContext> variaveis = t_ctx.registro().variavel();                        // declarando cada variavel dentro do registro
                for (int i = 0; i < variaveis.size(); i++) {
                    List<expressoesLAParser.IdentificadorContext> identificadores2 = variaveis.get(i).identificador();   // declarando cada identificador de cada variavel dentro do registro
                    for (int j = 0; j < identificadores2.size(); j++) {
                        if (escopoAtual.existe(identificadores2.get(j).IDENT(0).getText())) {
                            UtilsLA.adicionarErroSemantico(identificadores2.get(j).start, "identificador " + identificadores2.get(j).IDENT(0).getText() + " ja declarado anteriormente\n");
                        } else {
                            if (variaveis.get(i).tipo().tipo_estendido() != null) {
                                if (i == 0) {
                                    escopoAtual.inserir(ident, "registro", ident);                                       // adicionando uma flag que indica que eh um registro
                                }
                                if (variaveis.get(i).tipo().tipo_estendido().tipo_basico_ident().tipo_basico() != null) { // a variavel dentro do registro sera declarada de um tipo basico
                                    escolherTipo(escopoAtual, variaveis.get(i).tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText(), ident, identificadores2.get(j).IDENT(0).getText(), false, true);
                                } else { // a variavel dentro do registro sera declarada de um tipo IDENT
                                    if (escopoAtual.existe((variaveis.get(i).tipo().tipo_estendido().tipo_basico_ident().IDENT().getText()))) {
                                        if (!escolherTipo(escopoAtual, escopoAtual.verificar(variaveis.get(i).tipo().tipo_estendido().tipo_basico_ident().IDENT().getText()).get(0).tipo, ident, identificadores2.get(j).IDENT(0).getText(), true, true)) {
                                            escopoAtual.inserir(ident, identificadores2.get(j).IDENT(0).getText(), "invalido");
                                            UtilsLA.adicionarErroSemantico(t_ctx.tipo_estendido().tipo_basico_ident().start, "tipo " + escopoAtual.verificar(t_ctx.tipo_estendido().tipo_basico_ident().IDENT().getText()).get(0).tipo + " nao declarado\n");    
                                        }
                                    } else {
                                        escopoAtual.inserir(ident, ident, "invalido");
                                        UtilsLA.adicionarErroSemantico(variaveis.get(i).tipo().tipo_estendido().tipo_basico_ident().start, "tipo " + variaveis.get(i).tipo().tipo_estendido().tipo_basico_ident().IDENT().getText() + " nao declarado\n");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    
    @Override // retorna o tipo da expressao (inteiro, real, logico, literal ou IDENT) ou erro caso haja erro semantico
    public String visitExpressao (expressoesLAParser.ExpressaoContext ctx) {
        String retorno=  null;
        for (int i = ctx.termo_logico().size() - 1; i >= 0; i--) {
            retorno = visitTermo_logico(ctx.termo_logico(i));
            if (retorno.equals("erro")) {          // verifica se alguma parte da expressao tem erro
                return "erro";
            }
        }
        if (ctx.termo_logico().size() > 1) {       // verifica se ha mais uma parte na expressao
             return "logico";
        } else {
            return retorno;
        }
    }
    
    @Override // retorna o tipo do termo logico (inteiro, real, logico, literal ou IDENT) ou erro caso haja erro semantico
    public String visitTermo_logico (expressoesLAParser.Termo_logicoContext ctx) {
        String retorno = null;
        for (int i = ctx.fator_logico().size() - 1; i >= 0; i--) {
            retorno = visitFator_logico(ctx.fator_logico(i));
            if (retorno.equals("erro")) {          // verifica se alguma parte do termo logico tem erro
                return "erro";
            }
        }
        if (ctx.fator_logico().size() > 1) {       // verifica se ha mais uma parte no termo logico
             return "logico";
        } else {
            return retorno;
        }
    }
    
    @Override // retorna o tipo do fator logico (inteiro, real, logico, literal ou IDENT) ou erro caso haja erro semantico
    public String visitFator_logico (expressoesLAParser.Fator_logicoContext ctx) {
        String retorno = visitParcela_logica(ctx.parcela_logica());
        if (retorno.equals("erro")) {              // verifica se alguma parte do fator logico tem erro
            return "erro";
        }
        return retorno;
    }
    
    @Override // retorna o tipo da parcela logica (inteiro, real, logico, literal ou IDENT) ou erro caso haja erro semantico
    public String visitParcela_logica (expressoesLAParser.Parcela_logicaContext ctx) {
        if (ctx.exp_relacional() != null) {
            String retorno = visitExp_relacional(ctx.exp_relacional());
            if (retorno.equals("erro")) {          // verifica se alguma parte da parcela logica tem erro
                return "erro";
            }
            return retorno;
        }
        return "logico";
    }
    
    @Override // retorna o tipo da expressao relacional (inteiro, real, logico, literal ou IDENT) ou erro caso haja erro semantico
    public String visitExp_relacional (expressoesLAParser.Exp_relacionalContext ctx) {
        String retorno = null;
        for (int i = ctx.exp_aritmetica().size() - 1; i >= 0; i--) {
            retorno = visitExp_aritmetica(ctx.exp_aritmetica(i));
            if (retorno.equals("erro")) {          // verifica se alguma parte da expressao relacional tem erro
                return "erro";
            }
        }
        if (ctx.exp_aritmetica().size() > 1) {    // verifica se ha mais uma parte na expressao relacional
             return "logico";
        } else {
            return retorno;
        }
    }
    
    @Override // retorna o tipo da expressao aritmetica (inteiro, real, logico, literal ou IDENT) ou erro caso haja erro semantico
    public String visitExp_aritmetica (expressoesLAParser.Exp_aritmeticaContext ctx) {
        String retorno = null;
        boolean temCadeia = false;
        List<expressoesLAParser.TermoContext> termos = ctx.termo();
        List<expressoesLAParser.Op1Context> operadores1 = ctx.op1();
        for (expressoesLAParser.TermoContext ts : termos) {
            retorno = visitTermo(ts);
            if (retorno.equals("erro")) {        // verifica se alguma parte da expressao aritmetica tem erro
                return "erro";
            } else if (retorno.equals("literal")) {
                temCadeia = true;
            }
        }
        if (temCadeia) {                        // se tiver alguma cadeia no meio, nao pode haver mais de uma parte e nem o operador -
            for (expressoesLAParser.TermoContext ts : termos) {
                retorno = visitTermo(ts);
                if (!retorno.equals("literal")) {
                    return "erro";
                }
            }
            for (expressoesLAParser.Op1Context op1s : operadores1) {
                if (op1s.getText().equals("-")) {
                    return "erro";
                }
            }
            return "literal";
        } else {
            if (visitTermo(ctx.termo(0)).equals("inteiro")) {        // se tiver uma parte inteira, todas as partes tem que ser inteiras (no caso de + e -)
                for (expressoesLAParser.TermoContext ts : termos) {
                    retorno = visitTermo(ts);
                    if (!retorno.equals("inteiro")) {
                        return "erro";
                    }
                }
                return "inteiro";
            } else if (visitTermo(ctx.termo(0)).equals("real")) {   // se tiver uma parte real, todas as partes tem que ser reais (no caso de + e -)
                for (expressoesLAParser.TermoContext ts : termos) {
                    retorno = visitTermo(ts);
                    if (!retorno.equals("real")) {
                        return "erro";
                    }
                }
                return "real";
            } else if (visitTermo(ctx.termo(0)).equals("logico")) {
                return "logico";
            } else {
                return retorno;
            }
        }
    }
    
    @Override // retorna o tipo do termo (inteiro, real, logico, literal ou IDENT) ou erro caso haja erro semantico
    public String visitTermo (expressoesLAParser.TermoContext ctx) {
        String retorno = null;
        boolean temCadeia = false, temLogico = false, temReal = false;
        List<expressoesLAParser.FatorContext> fatores = ctx.fator();
        for (int i = ctx.fator().size() - 1; i >= 0; i--) {
            retorno = visitFator(ctx.fator(i));
            switch (retorno) {
                case "erro":
                    return "erro";
                case "literal":
                    temCadeia = true;
                    break;
                case "logico":
                    temLogico = true;
                    break;
                case "real":
                    temReal = true;
                    break;
                default:
                    break;
            }
        }
        if (fatores.size() > 1) {           // se tiver pelo menos uma cadeia ou pelo menos um literal e tiver mais de um fator, está errado pois estamos no nivel de * e /
            if (temCadeia || temLogico) {
                return "erro";
            }
        }
        if (temReal) {                      // se tiver pelo menos um real, o termo todo eh real pois estamos no nivel de * e /
            return "real";
        }
        return retorno;
    }
    
    @Override // retorna o tipo do fator (inteiro, real, logico, literal ou IDENT) ou erro caso haja erro semantico
    public String visitFator (expressoesLAParser.FatorContext ctx) {
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (ctx.parcela().size() > 1) {    // se tiver mais de uma parcela, todos os termos tem que ser obrigatoriamente inteiros, pois estamos no nivel de %
            List<expressoesLAParser.ParcelaContext> parcelas = ctx.parcela();
            for (expressoesLAParser.ParcelaContext ps : parcelas) {
                if (ps.parcela_unario() != null) {
                    visitParcela_unario(ps.parcela_unario());
                    if (ps.parcela_unario().identificador() != null) {
                        if (escopoAtual.verificar(ps.parcela_unario().identificador().IDENT(0).getText()).get(0).tipo.equals("inteiro")) {
                            return "inteiro";
                        } else {
                            return "erro";
                        }
                    } else if (ps.parcela_unario().IDENT() != null) {
                        if (escopoAtual.verificar(ps.parcela_unario().IDENT().getText()).get(0).tipo.equals("inteiro")) {
                            return "inteiro";
                        } else {
                            return "erro";
                        }
                    } else if (ps.parcela_unario().NUM_INT() != null) {
                        return "inteiro";
                    } else if (ps.parcela_unario().NUM_REAL() != null) {
                        return "erro";
                    } else {
                        return visitExpressao(ps.parcela_unario().expressao(0));
                    }
                } else {
                    visitParcela_nao_unario(ps.parcela_nao_unario());
                    if (ps.parcela_nao_unario().identificador() != null) {
                        if (escopoAtual.verificar(ps.parcela_nao_unario().identificador().IDENT(0).getText()).get(0).tipo.equals("inteiro")) {
                            return "inteiro";
                        } else {
                            return "erro";
                        }
                    } else {
                        return "erro";
                    }
                }
            }
        } else { // se tiver apenas uma parcela, nao tem a obrigacao de ser inteiro pois nao ha %; nesse caso, pode ser qualquer coisa valida
            if (ctx.parcela(0).parcela_unario() != null) {
                if (visitParcela_unario(ctx.parcela(0).parcela_unario()).equals("ok")) {
                    if (ctx.parcela(0).parcela_unario().identificador() != null) {
                        return escopoAtual.verificar(ctx.parcela(0).parcela_unario().identificador().IDENT(0).getText()).get(0).tipo;
                    } else if (ctx.parcela(0).parcela_unario().IDENT() != null) {
                        return escopoAtual.verificar(ctx.parcela(0).parcela_unario().IDENT().getText()).get(0).tipo;
                    } else if (ctx.parcela(0).parcela_unario().NUM_INT() != null) {
                        return "inteiro";
                    } else if (ctx.parcela(0).parcela_unario().NUM_REAL() != null) {
                        return "real";
                    } else {
                        return visitExpressao(ctx.parcela(0).parcela_unario().expressao(0));
                    }
                } else {
                    return "erro";
                }
            } else {
                if (visitParcela_nao_unario(ctx.parcela(0).parcela_nao_unario()).equals("ok")) {
                    if (ctx.parcela(0).parcela_nao_unario().identificador() != null) {
                        return escopoAtual.verificar(ctx.parcela(0).parcela_nao_unario().identificador().IDENT(0).getText()).get(0).tipo;
                    } else {
                        return "literal";
                    }
                } else {
                    return "erro";
                }
            }
        }
        
        return "ok";
        
    }
    
    @Override
    public String visitParcela (expressoesLAParser.ParcelaContext ctx) {
        return super.visitParcela(ctx);
    }
    
    @Override // retorna erro se a variavel nao foi declarada ou ok caso contrario
    public String visitParcela_unario (expressoesLAParser.Parcela_unarioContext ctx) {
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (ctx.identificador() != null) {
            if (!escopoAtual.existe((ctx.identificador().IDENT(0).getText()))) {
                if (!UtilsLA.errosSemanticos.contains("Linha " + ctx.identificador().start.getLine() + ": identificador " + ctx.identificador().getText() + " nao declarado\n")) {
                    UtilsLA.adicionarErroSemantico(ctx.identificador().start, "identificador " + ctx.identificador().getText() + " nao declarado\n");
                }
                return "erro";
            }
        } else if (ctx.IDENT() != null) {
              visitChamadaGenerico(ctx.IDENT().getText(), ctx.expressao());
        }
        return "ok";
    }
    
    @Override // retorna erro se a variavel nao foi declarada ou ok caso contrario
    public String visitParcela_nao_unario (expressoesLAParser.Parcela_nao_unarioContext ctx) {
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (ctx.identificador() != null) {
            if (!escopoAtual.existe((ctx.identificador().IDENT(0).getText()))) {
                if (!UtilsLA.errosSemanticos.contains("Linha " + ctx.identificador().start.getLine() + ": identificador " + ctx.identificador().getText() + " nao declarado\n")) {
                    UtilsLA.adicionarErroSemantico(ctx.identificador().start, "identificador " + ctx.identificador().getText() + " nao declarado\n");
                }
                return "erro";
            }
        }
        return "ok";
    }
    
    @Override
    public String visitCmd (expressoesLAParser.CmdContext ctx) {
        return super.visitCmd(ctx);
    }
    
    @Override // nao ha retorno mas verifica se as variaveis pedidas para serem lidas foram declaradas
    public String visitCmdLeia (expressoesLAParser.CmdLeiaContext ctx) {
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        List<expressoesLAParser.IdentificadorContext> ids = ctx.identificador();
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i).IDENT(0).getText() != null) {
                if (!escopoAtual.existe(ids.get(i).IDENT(0).getText())) {
                    UtilsLA.adicionarErroSemantico(ids.get(i).start, "identificador " + ids.get(i).getText() + " nao declarado\n");
                } else {
                    if (ids.get(i).IDENT().size() > 1) {
                        if (!escopoAtual.contem(escopoAtual.verificar(escopoAtual.verificar(ids.get(i).IDENT(0).getText()).get(0).tipo), ids.get(i).IDENT(ids.get(i).IDENT().size() - 1).getText())) {
                            UtilsLA.adicionarErroSemantico(ids.get(i).start, "identificador " + ids.get(i).getText() + " nao declarado\n");
                        }
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    public String visitCmdEscreva (expressoesLAParser.CmdEscrevaContext ctx) {
        return super.visitCmdEscreva(ctx);
    }
    
    @Override
    public String visitCmdSe (expressoesLAParser.CmdSeContext ctx) {
        return super.visitCmdSe(ctx);
    }
    
    @Override
    public String visitCmdCaso (expressoesLAParser.CmdCasoContext ctx) {
        return super.visitCmdCaso(ctx);
    }
    
    @Override // nao ha retorno mas verifica se as variaveis usadas na sintaxe do comando foram declaradas
    public String visitCmdPara (expressoesLAParser.CmdParaContext ctx) {
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (!escopoAtual.existe(ctx.IDENT().getText())) {
            UtilsLA.adicionarErroSemantico(ctx.start, "identificador " + ctx.IDENT().getText() + " nao declarado\n");
        }
        return null;
    }
    
    @Override
    public String visitCmdEnquanto (expressoesLAParser.CmdEnquantoContext ctx) {
        return super.visitCmdEnquanto(ctx);
    }
    
    @Override
    public String visitCmdFaca (expressoesLAParser.CmdFacaContext ctx) {
        return super.visitCmdFaca(ctx);
    }
    
    @Override // nao ha retorno; verifica a integridade da atribuicao
    public String visitCmdAtribuicao (expressoesLAParser.CmdAtribuicaoContext ctx) {
        String retorno;
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (!escopoAtual.existe(ctx.identificador().IDENT(0).getText())) {
            UtilsLA.adicionarErroSemantico(ctx.identificador().start, "identificador " + ctx.identificador().getText() + " nao declarado\n");
        } else {
            retorno = visitExpressao(ctx.expressao());
            if (retorno.equals("erro")) {     // se houve algum erro no meio da expressao a ser atribuida, a atribuicao eh invalida
                UtilsLA.adicionarErroSemantico(ctx.identificador().start, "atribuicao nao compativel para " + ctx.identificador().getText() + "\n");
            } else if (!retorno.equals(escopoAtual.verificar(ctx.identificador().IDENT(0).getText()).get(0).tipo)) {
                int nroIdentificadores = ctx.identificador().IDENT().size();
                if (nroIdentificadores > 1) { // se eh o campo de um registro e seu tipo for diferente do tipo da variavel sendo atribuida, a atribuicao eh invalida, com excecao de real <- inteiro
                    if (escopoAtual.verificar(ctx.identificador().IDENT(0).getText()).size() > 1) {
                        int nroVariaveis = escopoAtual.verificar(escopoAtual.verificar(ctx.identificador().IDENT(0).getText()).get(0).tipo).size() - 1;
                        if (!retorno.equals("inteiro") || !escopoAtual.verificar(ctx.identificador().IDENT(0).getText()).get(nroVariaveis - 1).tipo.equals("real")) {
                            UtilsLA.adicionarErroSemantico(ctx.identificador().start, "atribuicao nao compativel para " + ctx.identificador().getText() + "\n");
                        }
                    }
                } else {                      // se eh uma variavel normal e seu tipo for diferente do tipo da variavel sendo atribuida, a atribuicao eh invalida, com excecao de real <- inteiro
                    if (!retorno.equals("inteiro") || !escopoAtual.verificar(ctx.identificador().IDENT(0).getText()).get(0).tipo.equals("real")) {
                        String atribuicao = ctx.getText();
                        if (atribuicao.charAt(0) == '^') { // verifica se eh ponteiro
                            UtilsLA.adicionarErroSemantico(ctx.identificador().start, "atribuicao nao compativel para ^" + ctx.identificador().getText() + "\n");
                        } else {
                            UtilsLA.adicionarErroSemantico(ctx.identificador().start, "atribuicao nao compativel para " + ctx.identificador().getText() + "\n");
                        }
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    public String visitCmdChamada (expressoesLAParser.CmdChamadaContext ctx) {
        visitChamadaGenerico(ctx.IDENT().getText(), ctx.expressao());
        return null;
    }
    
    // nao ha retorno; verifica se as chamadas de funcoes e procedimentos estao validas quanto ao numero de parametros e aos tipos dos parametros
    public String visitChamadaGenerico (String ident, List<expressoesLAParser.ExpressaoContext> expressoes) {
        
        String retorno = "void";
        expressoesLAParser.Parcela_unarioContext pu;
        expressoesLAParser.Parcela_nao_unarioContext pnu;
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (!escopoAtual.existe(ident)) {
            UtilsLA.adicionarErroSemantico(expressoes.get(0).start, "identificador " + ident + " nao declarado\n");
        } else {
            if (!escopoAtual.verificar(ident).get(0).tipo.equals("funcao") && !escopoAtual.verificar(ident).get(0).tipo.equals("procedimento")) { // verifica se o ident nao eh funcao nem procedimento
                if (!UtilsLA.errosSemanticos.contains("Linha " + expressoes.get(0).start.getLine() + ": incompatibilidade de parametros na chamada de " + ident + "\n")) {
                    UtilsLA.adicionarErroSemantico(expressoes.get(0).start, "incompatibilidade de parametros na chamada de " + ident + "\n");
                }
            } else if (expressoes.size() != escopoAtual.verificar(ident).size() - 2) { // verifica se o numero de parametros esta incompativel
                if (!UtilsLA.errosSemanticos.contains("Linha " + expressoes.get(0).start.getLine() + ": incompatibilidade de parametros na chamada de " + ident + "\n")) {
                    UtilsLA.adicionarErroSemantico(expressoes.get(0).start, "incompatibilidade de parametros na chamada de " + ident + "\n");
                }
            } else {
                for (int i = 0; i < expressoes.size(); i++) {
                    pu = expressoes.get(i).termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0).termo(0).fator(0).parcela(0).parcela_unario();
                    pnu = expressoes.get(i).termo_logico(0).fator_logico(0).parcela_logica().exp_relacional().exp_aritmetica(0).termo(0).fator(0).parcela(0).parcela_nao_unario();
                    if (pu != null) {
                        if (pu.identificador() != null) {
                            if (pu.identificador().IDENT().size() > 1) {
                                // o parametro eh o campo de um registro, nao ha caso de teste; se for implementar, precisa corrigir
                                //retorno = escopoAtual.verificar(pu.identificador().IDENT(0).getText()).get(escopoAtual.verificar(pu.identificador().IDENT(0).getText()).size() - 1).tipo;
                            } else {
                                if (!escopoAtual.existe(pu.identificador().IDENT(0).getText())) {
                                    UtilsLA.adicionarErroSemantico(pu.start, "identificador " + pu.identificador().getText() + " nao declarado\n");
                                }
                                retorno = escopoAtual.verificar(pu.identificador().IDENT(0).getText()).get(0).tipo;
                            }
                        } else if (pu.IDENT() != null) {
                            if (!escopoAtual.existe(pu.IDENT().getText())) {
                                UtilsLA.adicionarErroSemantico(pu.start, "identificador " + pu.IDENT().getText() + " nao declarado\n");
                            } else {
                                visitChamadaGenerico(pu.IDENT().getText(), pu.expressao());
                                retorno = escopoAtual.verificar(pu.IDENT().getText()).get(1).tipo;
                            }
                        } else if (pu.NUM_INT() != null) {
                            retorno = "inteiro";
                        } else if (pu.NUM_REAL() != null) {
                            retorno = "real";
                        } else {
                            retorno = visitExpressao(pu.expressao(0));
                        }
                        // apos pegar o retorno do parametro, verifica se eh igual ao declarado no escopo da funcao, permitindo apenas a diferenca de real <- inteiro
                        if (!retorno.equals(escopoAtual.verificar(ident).get(i + 2).tipo)) {
                            if (!escopoAtual.verificar(ident).get(i + 2).tipo.equals("inteiro") || !retorno.equals("real")) {
                                if (!UtilsLA.errosSemanticos.contains("Linha " + pu.start.getLine() + ": incompatibilidade de parametros na chamada de " + ident + "\n")) {
                                    UtilsLA.adicionarErroSemantico(pu.start, "incompatibilidade de parametros na chamada de " + ident + "\n");
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
        
    }
    
    @Override
    public String visitCmdRetorne (expressoesLAParser.CmdRetorneContext ctx) {
        return super.visitCmdRetorne(ctx);
    }
    
    // modularizacao do switch do tipo a ser declarado em qualquer tipo de declaracao; retorna true se deu certo e false caso contrario
    public boolean escolherTipo(TabelaSimbolos escopo, String tipoTexto, String ident1, String ident2, boolean ehTipo1, boolean ehTipo2) {
        if (ehTipo1) {
            if (ehTipo2) {
                switch (tipoTexto) {
                    case "t_inteiro":
                        escopo.inserir(ident1, ident2, "t_inteiro");
                        break;
                    case "t_real":
                        escopo.inserir(ident1, ident2, "t_real");
                        break;
                    case "t_logico":
                        escopo.inserir(ident1, ident2, "t_logico");
                        break;
                    case "t_literal":
                        escopo.inserir(ident1, ident2, "t_literal");
                        break;
                    default:
                        return false;
                }
            } else {
                switch (tipoTexto) {
                    case "t_inteiro":
                        escopo.inserir(ident1, ident2, "inteiro");
                        break;
                    case "t_real":
                        escopo.inserir(ident1, ident2, "real");
                        break;
                    case "t_logico":
                        escopo.inserir(ident1, ident2, "logico");
                        break;
                    case "t_literal":
                        escopo.inserir(ident1, ident2, "literal");
                        break;
                    default:
                        return false;
                }
            }
        } else {
            if (ehTipo2) {
                switch (tipoTexto) {
                    case "inteiro":
                        escopo.inserir(ident1, ident2, "t_inteiro");
                        break;
                    case "real":
                        escopo.inserir(ident1, ident2, "t_real");
                        break;
                    case "logico":
                        escopo.inserir(ident1, ident2, "t_logico");
                        break;
                    case "literal":
                        escopo.inserir(ident1, ident2, "t_literal");
                        break;
                    default:
                        return false;
                }
            } else {
                switch (tipoTexto) {
                    case "inteiro":
                        escopo.inserir(ident1, ident2, "inteiro");
                        break;
                    case "real":
                        escopo.inserir(ident1, ident2, "real");
                        break;
                    case "logico":
                        escopo.inserir(ident1, ident2, "logico");
                        break;
                    case "literal":
                        escopo.inserir(ident1, ident2, "literal");
                        break;
                    default:
                        return false;
                }
            }
        }
        return true;
    }

}
