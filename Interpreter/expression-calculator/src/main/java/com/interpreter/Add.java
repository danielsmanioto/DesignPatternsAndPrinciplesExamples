package com.interpreter;

import java.util.Map;

/**
 * Expressão Não-Terminal: adição
 */
public final class Add implements Expression {
    
    private final Expression left;
    private final Expression right;
    
    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public double interpret(Map<String, Double> variables) {
        return left.interpret(variables) + right.interpret(variables);
    }
    
    @Override
    public String toString() {
        return "(" + left + " + " + right + ")";
    }
}
