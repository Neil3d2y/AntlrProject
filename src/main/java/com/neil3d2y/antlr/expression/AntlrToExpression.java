package com.neil3d2y.antlr.expression;

import com.neil3d2y.antlr.generated.ExprBaseVisitor;
import com.neil3d2y.antlr.generated.ExprParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Visitor for Expression
 */
public class AntlrToExpression extends ExprBaseVisitor<Expression> {

    /**
     * Note that the order of the visit* methods are called in a top-down fashion.
     * we can be sure that the order in which we add declared variables in the `vars` is
     * identical to the order that they have been declared.
     */
    private Set<String> vars; // stores all declared variables in the program so far.

    private List<String> semanticErrors; // 1. duplicate duplications 2. reference to undeclared variables
    // different from syntax error


    public AntlrToExpression(List<String> semanticErrors) {
        this.semanticErrors = semanticErrors;
        vars = new HashSet<>();
    }

    @Override
    public Expression visitDeclaration(ExprParser.DeclarationContext ctx) {
        Token symbol = ctx.ID().getSymbol(); // equivalent to: ctx.getChild(0).getSymbol();
        int line =symbol.getLine();
        int column = symbol.getCharPositionInLine();
        String id = ctx.getChild(0).getText();
        if (!vars.add(id)) {
            semanticErrors.add("Duplicate variable " + id + ". At (" + line + ", " + column + ").");
        }
        String type = ctx.INT_TYPE().getText();
        int value = Integer.parseInt(ctx.NUM().getText());
        return new VariableDeclaration(id, type, value);
    }

    @Override
    public Expression visitMultiplication(ExprParser.MultiplicationContext ctx) {
        ParseTree expr0 = ctx.getChild(0);
        ParseTree expr1 = ctx.getChild(2);
        String operation = ctx.getChild(1).getText();
        assert operation.equals("*");

        Expression left = visit(expr0);
        Expression right = visit(expr1);

        return new Multiplication(left, right);
    }

    @Override
    public Expression visitAddition(ExprParser.AdditionContext ctx) {
        ParseTree expr0 = ctx.getChild(0);
        ParseTree expr1 = ctx.getChild(2);
        String operation = ctx.getChild(1).getText();
        assert operation.equals("+");

        Expression left = visit(expr0);
        Expression right = visit(expr1);

        return new Addition(left, right);
    }

    @Override
    public Expression visitVariable(ExprParser.VariableContext ctx) {
        // How do I know if the variable has been declared?
        String id = ctx.ID().getText();
        if (!vars.contains(id)) {
            semanticErrors.add("Variable " + id + " is not defined.");
        }
        return new Variable(id);
    }

    @Override
    public Expression visitNumber(ExprParser.NumberContext ctx) {
        String numText = ctx.getChild(0).getText();
        int num = Integer.parseInt(numText);
        return new Number(num);
    }
}
