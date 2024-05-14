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
        return super.visitCorpo(ctx);
    }
    
    @Override
    public String visitDeclaracao_global (expressoesLAParser.Declaracao_globalContext ctx) {
        return super.visitDeclaracao_global(ctx);
    }

    @Override // nao ha retorno
    public String visitDeclaracao_local(expressoesLAParser.Declaracao_localContext ctx) {
        
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (ctx.variavel() != null) { // declaracao de variavel local
            List<expressoesLAParser.IdentificadorContext> ids = ctx.variavel().identificador();
            for (expressoesLAParser.IdentificadorContext i : ids) {
                if (escopoAtual.existe(i.IDENT(0).getText())) {
                    UtilsLA.adicionarErroSemantico(i.start, "identificador " + i.IDENT(0).getText() + " ja declarado anteriormente\n");
                } else {
                    if (ctx.variavel().tipo().tipo_estendido() != null) {
                        if (ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().tipo_basico() != null) { // declaracao de variavel de local com tipo basico
                            switch (ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText()) {
                                case "inteiro":
                                    escopoAtual.inserir(i.getText(), TipoLA.inteiro);
                                    break;
                                case "real":
                                    escopoAtual.inserir(i.getText(), TipoLA.real);
                                    break;
                                case "logico":
                                    escopoAtual.inserir(i.getText(), TipoLA.logico);
                                    break;
                                case "literal":
                                    escopoAtual.inserir(i.getText(), TipoLA.literal);
                                    break;
                                default:
                                    break;
                            }
                        } else {  // declaracao de variavel local com tipo IDENT
                                if (escopoAtual.existe((ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT().getText()))) {
                                    switch (escopoAtual.verificar(ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT().getText())) {
                                        case t_inteiro:
                                            escopoAtual.inserir(i.getText(), TipoLA.inteiro);
                                            break;
                                        case t_real:
                                            escopoAtual.inserir(i.getText(), TipoLA.real);
                                            break;
                                        case t_logico:
                                            escopoAtual.inserir(i.getText(), TipoLA.logico);
                                            break;
                                        case t_literal:
                                            escopoAtual.inserir(i.getText(), TipoLA.literal);
                                            break;
                                        default:
                                            escopoAtual.inserir(i.getText(), TipoLA.invalido);
                                            UtilsLA.adicionarErroSemantico(ctx.tipo().tipo_estendido().tipo_basico_ident().start, "tipo " + escopoAtual.verificar(ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT().getText()) + " nao declarado\n");
                                            break;
                                    }
                                } else {
                                    escopoAtual.inserir(i.getText(), TipoLA.invalido);
                                    UtilsLA.adicionarErroSemantico(ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().start, "tipo " + ctx.variavel().tipo().tipo_estendido().tipo_basico_ident().IDENT().getText() + " nao declarado\n");
                                }
                        }
                    }
                }
            }
        } else {
            if (escopoAtual.existe(ctx.IDENT().getText())) {
                UtilsLA.adicionarErroSemantico(ctx.start, "identificador " + ctx.IDENT().getText() + " ja declarado anteriormente\n");
            } else {
                if (ctx.tipo() != null) { // declaracao de tipo personalizado
                    if (ctx.tipo().tipo_estendido() != null) {
                        if (ctx.tipo().tipo_estendido().tipo_basico_ident().tipo_basico() != null) { // declaracao de tipo personalizado direto de um tipo basico
                            switch (ctx.tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText()) {
                                case "inteiro":
                                    escopoAtual.inserir(ctx.IDENT().getText(), TipoLA.t_inteiro);
                                    break;
                                case "real":
                                    escopoAtual.inserir(ctx.IDENT().getText(), TipoLA.t_real);
                                    break;
                                case "logico":
                                    escopoAtual.inserir(ctx.IDENT().getText(), TipoLA.t_logico);
                                    break;
                                case "literal":
                                    escopoAtual.inserir(ctx.IDENT().getText(), TipoLA.t_literal);
                                    break;
                                default:
                                    UtilsLA.adicionarErroSemantico(ctx.start, "tipo " + ctx.tipo().tipo_estendido().tipo_basico_ident().tipo_basico().getText() + " nao declarado\n");
                                    break;
                            }
                        } else {  // declaracao de tipo personalizado a partir de tipo IDENT
                            
                            if (escopoAtual.existe((ctx.tipo().tipo_estendido().tipo_basico_ident().IDENT().getText()))) {
                                switch (escopoAtual.verificar(ctx.tipo().tipo_estendido().tipo_basico_ident().IDENT().getText())) {
                                    case t_inteiro:
                                        escopoAtual.inserir(ctx.IDENT().getText(), TipoLA.t_inteiro);
                                        break;
                                    case t_real:
                                        escopoAtual.inserir(ctx.IDENT().getText(), TipoLA.t_real);
                                        break;
                                    case t_logico:
                                        escopoAtual.inserir(ctx.IDENT().getText(), TipoLA.t_logico);
                                        break;
                                    case t_literal:
                                        escopoAtual.inserir(ctx.IDENT().getText(), TipoLA.t_literal);
                                        break;
                                    default:
                                        UtilsLA.adicionarErroSemantico(ctx.tipo().tipo_estendido().tipo_basico_ident().start, "tipo " + escopoAtual.verificar(ctx.tipo().tipo_estendido().tipo_basico_ident().IDENT().getText()) + " nao declarado\n");
                                        break;
                                }
                            } else {
                                UtilsLA.adicionarErroSemantico(ctx.tipo().tipo_estendido().tipo_basico_ident().start, "tipo " + ctx.tipo().tipo_estendido().tipo_basico_ident().IDENT().getText() + " nao declarado\n");
                            }
                        }
                    }
                } else {  // declaracao de constante - apenas tipo basico
                    switch (ctx.tipo_basico().getText()) {
                        case "inteiro":
                            escopoAtual.inserir(ctx.IDENT().getText(), TipoLA.inteiro);
                            break;
                        case "real":
                            escopoAtual.inserir(ctx.IDENT().getText(), TipoLA.real);
                            break;
                        case "logico":
                            escopoAtual.inserir(ctx.IDENT().getText(), TipoLA.logico);
                            break;
                        case "literal":
                            escopoAtual.inserir(ctx.IDENT().getText(), TipoLA.literal);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return null;
        
    }
    
    @Override
    public String visitExpressao (expressoesLAParser.ExpressaoContext ctx) {
        String retorno=  null;
        for (int i = ctx.termo_logico().size() - 1; i >= 0; i--) {
            retorno = visitTermo_logico(ctx.termo_logico(i));
            if (retorno.equals("erro")) {
                return "erro";
            }
        }
        if (ctx.termo_logico().size() > 1) {
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
                        if (escopoAtual.verificar(ps.parcela_unario().identificador().IDENT(0).getText()) == TipoLA.inteiro) {
                            return TipoLA.inteiro.toString();
                        } else {
                            return "erro";
                        }
                    } else if (ps.parcela_unario().IDENT() != null) {
                        if (escopoAtual.verificar(ps.parcela_unario().IDENT().getText()) == TipoLA.inteiro) {
                            return TipoLA.inteiro.toString();
                        } else {
                            return "erro";
                        }
                    } else if (ps.parcela_unario().NUM_INT() != null) {
                        return TipoLA.inteiro.toString();
                    } else if (ps.parcela_unario().NUM_REAL() != null) {
                        return "erro";
                    } else {
                        return visitExpressao(ps.parcela_unario().expressao(0));
                    }
                } else {
                    visitParcela_nao_unario(ps.parcela_nao_unario());
                    if (ps.parcela_nao_unario().identificador() != null) {
                        if (escopoAtual.verificar(ps.parcela_nao_unario().identificador().IDENT(0).getText()) == TipoLA.inteiro) {
                            return TipoLA.inteiro.toString();
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
                        return escopoAtual.verificar(ctx.parcela(0).parcela_unario().identificador().IDENT(0).getText()).toString();
                    } else if (ctx.parcela(0).parcela_unario().IDENT() != null) {
                        return escopoAtual.verificar(ctx.parcela(0).parcela_unario().IDENT().getText()).toString();
                    } else if (ctx.parcela(0).parcela_unario().NUM_INT() != null) {
                        return TipoLA.inteiro.toString();
                    } else if (ctx.parcela(0).parcela_unario().NUM_REAL() != null) {
                        return TipoLA.real.toString();
                    } else {
                        return visitExpressao(ctx.parcela(0).parcela_unario().expressao(0));
                    }
                } else {
                    return "erro";
                }
            } else {
                if (visitParcela_nao_unario(ctx.parcela(0).parcela_nao_unario()).equals("ok")) {
                    if (ctx.parcela(0).parcela_nao_unario().identificador() != null) {
                        return escopoAtual.verificar(ctx.parcela(0).parcela_nao_unario().identificador().IDENT(0).getText()).toString();
                    } else {
                        return TipoLA.literal.toString();
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
                if (!UtilsLA.errosSemanticos.contains("Linha " + ctx.identificador().start.getLine() + ": identificador " + ctx.identificador().IDENT(0).getText() + " nao declarado\n")) {
                    UtilsLA.adicionarErroSemantico(ctx.identificador().start, "identificador " + ctx.identificador().IDENT(0).getText() + " nao declarado\n");
                }
                return "erro";
            }
        } else if (ctx.IDENT() != null) {
            if (!escopoAtual.existe((ctx.IDENT().getText()))) {
                if (!UtilsLA.errosSemanticos.contains("Linha " + ctx.start.getLine() + ": identificador " + ctx.IDENT().getText() + " nao declarado\n")) {
                    UtilsLA.adicionarErroSemantico(ctx.start, "identificador " + ctx.IDENT().getText() + " nao declarado\n");
                }
                return "erro";
            }
        }
        return "ok";
    }
    
    @Override // retorna erro se a variavel nao foi declarada ou ok caso contrario
    public String visitParcela_nao_unario (expressoesLAParser.Parcela_nao_unarioContext ctx) {
        TabelaSimbolos escopoAtual = escoposAninhados.obterEscopoAtual();
        if (ctx.identificador() != null) {
            if (!escopoAtual.existe((ctx.identificador().IDENT(0).getText()))) {
                if (!UtilsLA.errosSemanticos.contains("Linha " + ctx.identificador().start.getLine() + ": identificador " + ctx.identificador().IDENT(0).getText() + " nao declarado\n")) {
                    UtilsLA.adicionarErroSemantico(ctx.identificador().start, "identificador " + ctx.identificador().IDENT(0).getText() + " nao declarado\n");
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
        for (expressoesLAParser.IdentificadorContext i : ids) {
            if (!escopoAtual.existe(i.IDENT(0).getText())) {
                UtilsLA.adicionarErroSemantico(i.start, "identificador " + i.IDENT(0).getText() + " nao declarado\n");
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
            UtilsLA.adicionarErroSemantico(ctx.identificador().start, "identificador " + ctx.identificador().IDENT(0).getText() + " nao declarado\n");
        }
        retorno = visitExpressao(ctx.expressao());
        if (retorno.equals("erro")) { // se houve algum erro no meio da expressao a ser atribuida, a atribuicao eh invalida
            UtilsLA.adicionarErroSemantico(ctx.identificador().start, "atribuicao nao compativel para " + ctx.identificador().IDENT(0).getText() + "\n");
        } else if (!retorno.equals(escopoAtual.verificar(ctx.identificador().IDENT(0).getText()).toString())) {
            // se a variavel sendo atribuida e a que atribui possuirem tipos diferentes, a atribuicao eh invalida, com excecao de real <- inteiro
            if (!retorno.equals("inteiro") || escopoAtual.verificar(ctx.identificador().IDENT(0).getText()) != TipoLA.real) {
                UtilsLA.adicionarErroSemantico(ctx.identificador().start, "atribuicao nao compativel para " + ctx.identificador().IDENT(0).getText() + "\n");
            }
        }
        return null;
    }
    
    @Override
    public String visitCmdChamada (expressoesLAParser.CmdChamadaContext ctx) {
        return super.visitCmdChamada(ctx);
    }
    
    @Override
    public String visitCmdRetorne (expressoesLAParser.CmdRetorneContext ctx) {
        return super.visitCmdRetorne(ctx);
    }

}