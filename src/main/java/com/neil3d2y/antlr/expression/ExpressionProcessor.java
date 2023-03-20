package com.neil3d2y.antlr.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionProcessor {
    List<Expression> list;
    Map<String, Integer> values; /* symbol table for storing values of variables */

    public ExpressionProcessor(List<Expression> list) {
        this.list = list;
        this.values = new HashMap<>();
    }

    public List<String> getEvaluationResults() {
        List<String> evaluations = new ArrayList<>();

        for (Expression expression : this.list) {
            if (expression instanceof VariableDeclaration) {
                values.put(((VariableDeclaration) expression).id, ((VariableDeclaration) expression).value);
            } else {
                String input = expression.toString();
                int result = getEvalResult(expression);
                evaluations.add(input + " is " + result);
            }
        }

        return evaluations;
    }

    private int getEvalResult(Expression expression) {
        if (expression instanceof Number) {
            return ((Number) expression).number;
        }

        if (expression instanceof Variable) {
            Variable var = (Variable) expression;
            return values.get(var.id);
        }

        if (expression instanceof Addition) {
            Addition add = (Addition) expression;
            int left = getEvalResult(add.left);
            int right = getEvalResult(add.right);
            return left + right;
        }

        if (expression instanceof Multiplication) {
            Multiplication multiplication = (Multiplication) expression;
            int left = getEvalResult(multiplication.left);
            int right = getEvalResult(multiplication.right);
            return left * right;
        }

        return 0;
    }
}
