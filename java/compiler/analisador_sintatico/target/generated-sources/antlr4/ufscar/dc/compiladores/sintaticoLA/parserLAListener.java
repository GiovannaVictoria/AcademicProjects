// Generated from ufscar/dc/compiladores/sintaticoLA/parserLA.g4 by ANTLR 4.8
package ufscar.dc.compiladores.sintaticoLA;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link parserLAParser}.
 */
public interface parserLAListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link parserLAParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(parserLAParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(parserLAParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(parserLAParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(parserLAParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void enterDecl_local_global(parserLAParser.Decl_local_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void exitDecl_local_global(parserLAParser.Decl_local_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_local(parserLAParser.Declaracao_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_local(parserLAParser.Declaracao_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#variavel}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(parserLAParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#variavel}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(parserLAParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(parserLAParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(parserLAParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void enterDimensao(parserLAParser.DimensaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void exitDimensao(parserLAParser.DimensaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(parserLAParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(parserLAParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico(parserLAParser.Tipo_basicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico(parserLAParser.Tipo_basicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico_ident(parserLAParser.Tipo_basico_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico_ident(parserLAParser.Tipo_basico_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void enterTipo_estendido(parserLAParser.Tipo_estendidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void exitTipo_estendido(parserLAParser.Tipo_estendidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void enterValor_constante(parserLAParser.Valor_constanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void exitValor_constante(parserLAParser.Valor_constanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(parserLAParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(parserLAParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_global(parserLAParser.Declaracao_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_global(parserLAParser.Declaracao_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(parserLAParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(parserLAParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(parserLAParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(parserLAParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(parserLAParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(parserLAParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(parserLAParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(parserLAParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeia(parserLAParser.CmdLeiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeia(parserLAParser.CmdLeiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscreva(parserLAParser.CmdEscrevaContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscreva(parserLAParser.CmdEscrevaContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void enterCmdSe(parserLAParser.CmdSeContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void exitCmdSe(parserLAParser.CmdSeContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void enterCmdCaso(parserLAParser.CmdCasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void exitCmdCaso(parserLAParser.CmdCasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void enterCmdPara(parserLAParser.CmdParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void exitCmdPara(parserLAParser.CmdParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdEnquanto(parserLAParser.CmdEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdEnquanto(parserLAParser.CmdEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void enterCmdFaca(parserLAParser.CmdFacaContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void exitCmdFaca(parserLAParser.CmdFacaContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtribuicao(parserLAParser.CmdAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtribuicao(parserLAParser.CmdAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void enterCmdChamada(parserLAParser.CmdChamadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void exitCmdChamada(parserLAParser.CmdChamadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void enterCmdRetorne(parserLAParser.CmdRetorneContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void exitCmdRetorne(parserLAParser.CmdRetorneContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#selecao}.
	 * @param ctx the parse tree
	 */
	void enterSelecao(parserLAParser.SelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#selecao}.
	 * @param ctx the parse tree
	 */
	void exitSelecao(parserLAParser.SelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void enterItem_selecao(parserLAParser.Item_selecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void exitItem_selecao(parserLAParser.Item_selecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#constantes}.
	 * @param ctx the parse tree
	 */
	void enterConstantes(parserLAParser.ConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#constantes}.
	 * @param ctx the parse tree
	 */
	void exitConstantes(parserLAParser.ConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void enterNumero_intervalo(parserLAParser.Numero_intervaloContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void exitNumero_intervalo(parserLAParser.Numero_intervaloContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void enterOp_unario(parserLAParser.Op_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void exitOp_unario(parserLAParser.Op_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExp_aritmetica(parserLAParser.Exp_aritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExp_aritmetica(parserLAParser.Exp_aritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(parserLAParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(parserLAParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(parserLAParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(parserLAParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#op1}.
	 * @param ctx the parse tree
	 */
	void enterOp1(parserLAParser.Op1Context ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#op1}.
	 * @param ctx the parse tree
	 */
	void exitOp1(parserLAParser.Op1Context ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#op2}.
	 * @param ctx the parse tree
	 */
	void enterOp2(parserLAParser.Op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#op2}.
	 * @param ctx the parse tree
	 */
	void exitOp2(parserLAParser.Op2Context ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#op3}.
	 * @param ctx the parse tree
	 */
	void enterOp3(parserLAParser.Op3Context ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#op3}.
	 * @param ctx the parse tree
	 */
	void exitOp3(parserLAParser.Op3Context ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#parcela}.
	 * @param ctx the parse tree
	 */
	void enterParcela(parserLAParser.ParcelaContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#parcela}.
	 * @param ctx the parse tree
	 */
	void exitParcela(parserLAParser.ParcelaContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_unario(parserLAParser.Parcela_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_unario(parserLAParser.Parcela_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_nao_unario(parserLAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_nao_unario(parserLAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void enterExp_relacional(parserLAParser.Exp_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void exitExp_relacional(parserLAParser.Exp_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOp_relacional(parserLAParser.Op_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOp_relacional(parserLAParser.Op_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(parserLAParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(parserLAParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(parserLAParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(parserLAParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(parserLAParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(parserLAParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void enterParcela_logica(parserLAParser.Parcela_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void exitParcela_logica(parserLAParser.Parcela_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_1(parserLAParser.Op_logico_1Context ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_1(parserLAParser.Op_logico_1Context ctx);
	/**
	 * Enter a parse tree produced by {@link parserLAParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_2(parserLAParser.Op_logico_2Context ctx);
	/**
	 * Exit a parse tree produced by {@link parserLAParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_2(parserLAParser.Op_logico_2Context ctx);
}