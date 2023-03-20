// Generated from DeprecatedExpr.g4 by ANTLR 4.12.0

package com.neil3d2y.antlr.generated;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DeprecatedExprParser}.
 */
public interface DeprecatedExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DeprecatedExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(DeprecatedExprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeprecatedExprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(DeprecatedExprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeprecatedExprParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(DeprecatedExprParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeprecatedExprParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(DeprecatedExprParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DeprecatedExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(DeprecatedExprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link DeprecatedExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(DeprecatedExprParser.ExprContext ctx);
}