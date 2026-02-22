package com.interpreter;

import java.util.Map;

/**
 * Expressão Terminal: representa um número
 */
public final class Number implements Expression {
    
    private final double value;
    
    public Number(double value) {
        this.value = value;
    }
    
    @Override
    public double interpret(Map<String, Double> variables) {
        return value;
    }
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
