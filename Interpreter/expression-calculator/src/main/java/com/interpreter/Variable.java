package com.interpreter;

import java.util.Map;

/**
 * Expressão Terminal: representa uma variável
 */
public final class Variable implements Expression {
    
    private final String name;
    
    public Variable(String name) {
        this.name = name;
    }
    
    @Override
    public double interpret(Map<String, Double> variables) {
        Double value = variables.get(name);
        if (value == null) {
            throw new IllegalArgumentException("Variável não encontrada: " + name);
        }
        return value;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
