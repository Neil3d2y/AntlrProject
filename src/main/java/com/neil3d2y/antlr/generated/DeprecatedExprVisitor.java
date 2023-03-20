// Generated from DeprecatedExpr.g4 by ANTLR 4.12.0

package com.neil3d2y.antlr.generated;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DeprecatedExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DeprecatedExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DeprecatedExprParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(DeprecatedExprParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeprecatedExprParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(DeprecatedExprParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DeprecatedExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(DeprecatedExprParser.ExprContext ctx);
}