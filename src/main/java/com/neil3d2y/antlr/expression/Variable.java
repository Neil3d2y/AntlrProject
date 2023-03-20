package com.neil3d2y.antlr.expression;

public class Variable extends Expression{
    String id;

    public Variable(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
}
