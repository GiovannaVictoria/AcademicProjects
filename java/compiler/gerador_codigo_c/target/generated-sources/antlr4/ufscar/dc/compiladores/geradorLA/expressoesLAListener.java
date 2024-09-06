// Generated from ufscar/dc/compiladores/geradorLA/expressoesLA.g4 by ANTLR 4.8
package ufscar.dc.compiladores.geradorLA;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link expressoesLAParser}.
 */
public interface expressoesLAListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(expressoesLAParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(expressoesLAParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracoes(expressoesLAParser.DeclaracoesContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#declaracoes}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracoes(expressoesLAParser.DeclaracoesContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void enterDecl_local_global(expressoesLAParser.Decl_local_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#decl_local_global}.
	 * @param ctx the parse tree
	 */
	void exitDecl_local_global(expressoesLAParser.Decl_local_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_local(expressoesLAParser.Declaracao_localContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#declaracao_local}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_local(expressoesLAParser.Declaracao_localContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#variavel}.
	 * @param ctx the parse tree
	 */
	void enterVariavel(expressoesLAParser.VariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#variavel}.
	 * @param ctx the parse tree
	 */
	void exitVariavel(expressoesLAParser.VariavelContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#identificador}.
	 * @param ctx the parse tree
	 */
	void enterIdentificador(expressoesLAParser.IdentificadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#identificador}.
	 * @param ctx the parse tree
	 */
	void exitIdentificador(expressoesLAParser.IdentificadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void enterDimensao(expressoesLAParser.DimensaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#dimensao}.
	 * @param ctx the parse tree
	 */
	void exitDimensao(expressoesLAParser.DimensaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(expressoesLAParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(expressoesLAParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico(expressoesLAParser.Tipo_basicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#tipo_basico}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico(expressoesLAParser.Tipo_basicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void enterTipo_basico_ident(expressoesLAParser.Tipo_basico_identContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 */
	void exitTipo_basico_ident(expressoesLAParser.Tipo_basico_identContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void enterTipo_estendido(expressoesLAParser.Tipo_estendidoContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 */
	void exitTipo_estendido(expressoesLAParser.Tipo_estendidoContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void enterValor_constante(expressoesLAParser.Valor_constanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#valor_constante}.
	 * @param ctx the parse tree
	 */
	void exitValor_constante(expressoesLAParser.Valor_constanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#registro}.
	 * @param ctx the parse tree
	 */
	void enterRegistro(expressoesLAParser.RegistroContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#registro}.
	 * @param ctx the parse tree
	 */
	void exitRegistro(expressoesLAParser.RegistroContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao_global(expressoesLAParser.Declaracao_globalContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#declaracao_global}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao_global(expressoesLAParser.Declaracao_globalContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(expressoesLAParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(expressoesLAParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(expressoesLAParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(expressoesLAParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(expressoesLAParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(expressoesLAParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(expressoesLAParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(expressoesLAParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeia(expressoesLAParser.CmdLeiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#cmdLeia}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeia(expressoesLAParser.CmdLeiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscreva(expressoesLAParser.CmdEscrevaContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#cmdEscreva}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscreva(expressoesLAParser.CmdEscrevaContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void enterCmdSe(expressoesLAParser.CmdSeContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void exitCmdSe(expressoesLAParser.CmdSeContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void enterCmdCaso(expressoesLAParser.CmdCasoContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#cmdCaso}.
	 * @param ctx the parse tree
	 */
	void exitCmdCaso(expressoesLAParser.CmdCasoContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void enterCmdPara(expressoesLAParser.CmdParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void exitCmdPara(expressoesLAParser.CmdParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdEnquanto(expressoesLAParser.CmdEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdEnquanto(expressoesLAParser.CmdEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void enterCmdFaca(expressoesLAParser.CmdFacaContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#cmdFaca}.
	 * @param ctx the parse tree
	 */
	void exitCmdFaca(expressoesLAParser.CmdFacaContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtribuicao(expressoesLAParser.CmdAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtribuicao(expressoesLAParser.CmdAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void enterCmdChamada(expressoesLAParser.CmdChamadaContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#cmdChamada}.
	 * @param ctx the parse tree
	 */
	void exitCmdChamada(expressoesLAParser.CmdChamadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void enterCmdRetorne(expressoesLAParser.CmdRetorneContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#cmdRetorne}.
	 * @param ctx the parse tree
	 */
	void exitCmdRetorne(expressoesLAParser.CmdRetorneContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#selecao}.
	 * @param ctx the parse tree
	 */
	void enterSelecao(expressoesLAParser.SelecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#selecao}.
	 * @param ctx the parse tree
	 */
	void exitSelecao(expressoesLAParser.SelecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void enterItem_selecao(expressoesLAParser.Item_selecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#item_selecao}.
	 * @param ctx the parse tree
	 */
	void exitItem_selecao(expressoesLAParser.Item_selecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#constantes}.
	 * @param ctx the parse tree
	 */
	void enterConstantes(expressoesLAParser.ConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#constantes}.
	 * @param ctx the parse tree
	 */
	void exitConstantes(expressoesLAParser.ConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void enterNumero_intervalo(expressoesLAParser.Numero_intervaloContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 */
	void exitNumero_intervalo(expressoesLAParser.Numero_intervaloContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void enterOp_unario(expressoesLAParser.Op_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#op_unario}.
	 * @param ctx the parse tree
	 */
	void exitOp_unario(expressoesLAParser.Op_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExp_aritmetica(expressoesLAParser.Exp_aritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExp_aritmetica(expressoesLAParser.Exp_aritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(expressoesLAParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(expressoesLAParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(expressoesLAParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(expressoesLAParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#op1}.
	 * @param ctx the parse tree
	 */
	void enterOp1(expressoesLAParser.Op1Context ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#op1}.
	 * @param ctx the parse tree
	 */
	void exitOp1(expressoesLAParser.Op1Context ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#op2}.
	 * @param ctx the parse tree
	 */
	void enterOp2(expressoesLAParser.Op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#op2}.
	 * @param ctx the parse tree
	 */
	void exitOp2(expressoesLAParser.Op2Context ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#op3}.
	 * @param ctx the parse tree
	 */
	void enterOp3(expressoesLAParser.Op3Context ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#op3}.
	 * @param ctx the parse tree
	 */
	void exitOp3(expressoesLAParser.Op3Context ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#parcela}.
	 * @param ctx the parse tree
	 */
	void enterParcela(expressoesLAParser.ParcelaContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#parcela}.
	 * @param ctx the parse tree
	 */
	void exitParcela(expressoesLAParser.ParcelaContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_unario(expressoesLAParser.Parcela_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#parcela_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_unario(expressoesLAParser.Parcela_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void enterParcela_nao_unario(expressoesLAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 */
	void exitParcela_nao_unario(expressoesLAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void enterExp_relacional(expressoesLAParser.Exp_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#exp_relacional}.
	 * @param ctx the parse tree
	 */
	void exitExp_relacional(expressoesLAParser.Exp_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void enterOp_relacional(expressoesLAParser.Op_relacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#op_relacional}.
	 * @param ctx the parse tree
	 */
	void exitOp_relacional(expressoesLAParser.Op_relacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(expressoesLAParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(expressoesLAParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(expressoesLAParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(expressoesLAParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(expressoesLAParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(expressoesLAParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void enterParcela_logica(expressoesLAParser.Parcela_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#parcela_logica}.
	 * @param ctx the parse tree
	 */
	void exitParcela_logica(expressoesLAParser.Parcela_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_1(expressoesLAParser.Op_logico_1Context ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#op_logico_1}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_1(expressoesLAParser.Op_logico_1Context ctx);
	/**
	 * Enter a parse tree produced by {@link expressoesLAParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void enterOp_logico_2(expressoesLAParser.Op_logico_2Context ctx);
	/**
	 * Exit a parse tree produced by {@link expressoesLAParser#op_logico_2}.
	 * @param ctx the parse tree
	 */
	void exitOp_logico_2(expressoesLAParser.Op_logico_2Context ctx);
}