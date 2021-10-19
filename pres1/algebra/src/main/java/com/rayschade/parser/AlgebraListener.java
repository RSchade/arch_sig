package com.rayschade.parser;// Generated from Algebra.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link AlgebraParser}.
 */
public interface AlgebraListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link AlgebraParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(AlgebraParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgebraParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(AlgebraParser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link AlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(AlgebraParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link AlgebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(AlgebraParser.ExprContext ctx);
}