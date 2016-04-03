// Generated from Script.g4 by ANTLR 4.5.3

	package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ScriptParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(ScriptParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(ScriptParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(ScriptParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#assignVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignVar(ScriptParser.AssignVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#notExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(ScriptParser.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(ScriptParser.OperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#hexaDisp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHexaDisp(ScriptParser.HexaDispContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#integerDisp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerDisp(ScriptParser.IntegerDispContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#gotoExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGotoExpression(ScriptParser.GotoExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ScriptParser#labelExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelExpression(ScriptParser.LabelExpressionContext ctx);
}