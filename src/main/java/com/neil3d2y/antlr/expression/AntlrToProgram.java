package com.neil3d2y.antlr.expression;

import com.neil3d2y.antlr.generated.ExprBaseVisitor;
import com.neil3d2y.antlr.generated.ExprParser;

import java.util.ArrayList;
import java.util.List;

public class AntlrToProgram extends ExprBaseVisitor<Program> {

    public List<String> semanticErrors;

    public AntlrToProgram() {
        semanticErrors = new ArrayList<>();
    }

    @Override
    public Program visitProgram(ExprParser.ProgramContext ctx) {
        List<Expression> expressionList = new ArrayList<>();
        int size = ctx.getChildCount();

        AntlrToExpression antlrToExpression = new AntlrToExpression(semanticErrors);

        for (int i = 0; i < size - 1; i++) {
            Expression expr = antlrToExpression.visit(ctx.getChild(i));
            expressionList.add(expr);
        }

        return new Program(expressionList);
    }
}
