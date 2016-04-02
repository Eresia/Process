// Generated from Script.g4 by ANTLR 4.5.3

	package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ScriptParser}.
 */
public interface ScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ScriptParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(ScriptParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(ScriptParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ScriptParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ScriptParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(ScriptParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(ScriptParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptParser#assignVar}.
	 * @param ctx the parse tree
	 */
	void enterAssignVar(ScriptParser.AssignVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#assignVar}.
	 * @param ctx the parse tree
	 */
	void exitAssignVar(ScriptParser.AssignVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(ScriptParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#notExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(ScriptParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScriptParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(ScriptParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScriptParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(ScriptParser.OperationContext ctx);
}