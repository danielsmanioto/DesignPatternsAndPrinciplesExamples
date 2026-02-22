package com.interpreter;

import java.util.Map;

/**
 * Expressão Não-Terminal: divisão
 */
public final class Divide implements Expression {
    
    private final Expression left;
    private final Expression right;
    
    public Divide(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public double interpret(Map<String, Double> variables) {
        double rightValue = right.interpret(variables);
        if (rightValue == 0) {
            throw new ArithmeticException("Divisão por zero!");
        }
        return left.interpret(variables) / rightValue;
    }
    
    @Override
    public String toString() {
        return "(" + left + " / " + right + ")";
    }
}
