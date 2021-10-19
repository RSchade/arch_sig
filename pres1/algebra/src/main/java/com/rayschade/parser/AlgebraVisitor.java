// Generated from Algebra.g4 by ANTLR 4.9.2
package com.rayschade.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link AlgebraParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface AlgebraVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link AlgebraParser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(AlgebraParser.SContext ctx);
	/**
	 * Visit a parse tree produced by {@link AlgebraParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(AlgebraParser.ExprContext ctx);
}