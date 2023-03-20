package com.neil3d2y.antlr.expression;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains list of Expression
 */
public class Program {
    public List<Expression> expressions = new ArrayList<>();

    public Program(List<Expression> expressions) {
        this.expressions = expressions;
    }
}
