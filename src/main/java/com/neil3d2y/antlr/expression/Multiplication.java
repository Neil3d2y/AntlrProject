package com.neil3d2y.antlr.expression;

public class Multiplication extends Expression{

    Expression left;
    Expression right;

    public Multiplication(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return left.toString() + " * " + right.toString();
    }

}
