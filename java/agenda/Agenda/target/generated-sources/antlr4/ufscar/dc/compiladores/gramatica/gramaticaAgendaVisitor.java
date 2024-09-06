// Generated from ufscar/dc/compiladores/gramatica/gramaticaAgenda.g4 by ANTLR 4.8
package ufscar.dc.compiladores.gramatica;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link gramaticaAgendaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface gramaticaAgendaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link gramaticaAgendaParser#calendario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalendario(gramaticaAgendaParser.CalendarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaAgendaParser#corpoAno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpoAno(gramaticaAgendaParser.CorpoAnoContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaAgendaParser#corpoMes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpoMes(gramaticaAgendaParser.CorpoMesContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaAgendaParser#corpoDia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpoDia(gramaticaAgendaParser.CorpoDiaContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaAgendaParser#corpoHorario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCorpoHorario(gramaticaAgendaParser.CorpoHorarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaAgendaParser#horario}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHorario(gramaticaAgendaParser.HorarioContext ctx);
	/**
	 * Visit a parse tree produced by {@link gramaticaAgendaParser#descricao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescricao(gramaticaAgendaParser.DescricaoContext ctx);
}