// Generated from ufscar/dc/compiladores/gramatica/gramaticaAgenda.g4 by ANTLR 4.8
package ufscar.dc.compiladores.gramatica;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramaticaAgendaParser}.
 */
public interface gramaticaAgendaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramaticaAgendaParser#calendario}.
	 * @param ctx the parse tree
	 */
	void enterCalendario(gramaticaAgendaParser.CalendarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaAgendaParser#calendario}.
	 * @param ctx the parse tree
	 */
	void exitCalendario(gramaticaAgendaParser.CalendarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaAgendaParser#corpoAno}.
	 * @param ctx the parse tree
	 */
	void enterCorpoAno(gramaticaAgendaParser.CorpoAnoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaAgendaParser#corpoAno}.
	 * @param ctx the parse tree
	 */
	void exitCorpoAno(gramaticaAgendaParser.CorpoAnoContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaAgendaParser#corpoMes}.
	 * @param ctx the parse tree
	 */
	void enterCorpoMes(gramaticaAgendaParser.CorpoMesContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaAgendaParser#corpoMes}.
	 * @param ctx the parse tree
	 */
	void exitCorpoMes(gramaticaAgendaParser.CorpoMesContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaAgendaParser#corpoDia}.
	 * @param ctx the parse tree
	 */
	void enterCorpoDia(gramaticaAgendaParser.CorpoDiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaAgendaParser#corpoDia}.
	 * @param ctx the parse tree
	 */
	void exitCorpoDia(gramaticaAgendaParser.CorpoDiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaAgendaParser#corpoHorario}.
	 * @param ctx the parse tree
	 */
	void enterCorpoHorario(gramaticaAgendaParser.CorpoHorarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaAgendaParser#corpoHorario}.
	 * @param ctx the parse tree
	 */
	void exitCorpoHorario(gramaticaAgendaParser.CorpoHorarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaAgendaParser#horario}.
	 * @param ctx the parse tree
	 */
	void enterHorario(gramaticaAgendaParser.HorarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaAgendaParser#horario}.
	 * @param ctx the parse tree
	 */
	void exitHorario(gramaticaAgendaParser.HorarioContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramaticaAgendaParser#descricao}.
	 * @param ctx the parse tree
	 */
	void enterDescricao(gramaticaAgendaParser.DescricaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramaticaAgendaParser#descricao}.
	 * @param ctx the parse tree
	 */
	void exitDescricao(gramaticaAgendaParser.DescricaoContext ctx);
}