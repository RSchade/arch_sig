// Generated from algebra.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link algebraParser}.
 */
public interface algebraListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link algebraParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(algebraParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link algebraParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(algebraParser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link algebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(algebraParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link algebraParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(algebraParser.ExprContext ctx);
}