// Generated from ufscar/dc/compiladores/geradorLA/expressoesLA.g4 by ANTLR 4.8
package ufscar.dc.compiladores.geradorLA;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link expressoesLAParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface expressoesLAVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(expressoesLAParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#declaracoes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracoes(expressoesLAParser.DeclaracoesContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#decl_local_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_local_global(expressoesLAParser.Decl_local_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#declaracao_local}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_local(expressoesLAParser.Declaracao_localContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#variavel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariavel(expressoesLAParser.VariavelContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#identificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentificador(expressoesLAParser.IdentificadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#dimensao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensao(expressoesLAParser.DimensaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(expressoesLAParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#tipo_basico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico(expressoesLAParser.Tipo_basicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#tipo_basico_ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_basico_ident(expressoesLAParser.Tipo_basico_identContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#tipo_estendido}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_estendido(expressoesLAParser.Tipo_estendidoContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#valor_constante}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor_constante(expressoesLAParser.Valor_constanteContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#registro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegistro(expressoesLAParser.RegistroContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#declaracao_global}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao_global(expressoesLAParser.Declaracao_globalContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(expressoesLAParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(expressoesLAParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#corpo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpo(expressoesLAParser.CorpoContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(expressoesLAParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#cmdLeia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdLeia(expressoesLAParser.CmdLeiaContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#cmdEscreva}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEscreva(expressoesLAParser.CmdEscrevaContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#cmdSe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdSe(expressoesLAParser.CmdSeContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#cmdCaso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdCaso(expressoesLAParser.CmdCasoContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#cmdPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdPara(expressoesLAParser.CmdParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEnquanto(expressoesLAParser.CmdEnquantoContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#cmdFaca}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdFaca(expressoesLAParser.CmdFacaContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAtribuicao(expressoesLAParser.CmdAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#cmdChamada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdChamada(expressoesLAParser.CmdChamadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#cmdRetorne}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdRetorne(expressoesLAParser.CmdRetorneContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelecao(expressoesLAParser.SelecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#item_selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem_selecao(expressoesLAParser.Item_selecaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#constantes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantes(expressoesLAParser.ConstantesContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#numero_intervalo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero_intervalo(expressoesLAParser.Numero_intervaloContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#op_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_unario(expressoesLAParser.Op_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#exp_aritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_aritmetica(expressoesLAParser.Exp_aritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(expressoesLAParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(expressoesLAParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#op1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp1(expressoesLAParser.Op1Context ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp2(expressoesLAParser.Op2Context ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#op3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp3(expressoesLAParser.Op3Context ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#parcela}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela(expressoesLAParser.ParcelaContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#parcela_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_unario(expressoesLAParser.Parcela_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#parcela_nao_unario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_nao_unario(expressoesLAParser.Parcela_nao_unarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#exp_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_relacional(expressoesLAParser.Exp_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#op_relacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_relacional(expressoesLAParser.Op_relacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(expressoesLAParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#termo_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo_logico(expressoesLAParser.Termo_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#fator_logico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator_logico(expressoesLAParser.Fator_logicoContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#parcela_logica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParcela_logica(expressoesLAParser.Parcela_logicaContext ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#op_logico_1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_1(expressoesLAParser.Op_logico_1Context ctx);
	/**
	 * Visit a parse tree produced by {@link expressoesLAParser#op_logico_2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp_logico_2(expressoesLAParser.Op_logico_2Context ctx);
}