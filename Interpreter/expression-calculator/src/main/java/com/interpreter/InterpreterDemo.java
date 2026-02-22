package com.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * Demonstração do padrão Interpreter
 */
public class InterpreterDemo {
    
    public static void main(String[] args) {
        System.out.println("=== CALCULADORA COM PADRÃO INTERPRETER ===\n");
        
        // Variáveis da expressão
        Map<String, Double> variables = new HashMap<>();
        variables.put("x", 10.0);
        variables.put("y", 20.0);
        variables.put("z", 5.0);
        
        // Expressão 1: x + y = 10 + 20 = 30
        Expression expr1 = new Add(
            new Variable("x"),
            new Variable("y")
        );
        System.out.printf("Expressão: %s%n", expr1);
        System.out.printf("Resultado: %.2f%n%n", expr1.interpret(variables));
        
        // Expressão 2: (x + y) * z = (10 + 20) * 5 = 150
        Expression expr2 = new Multiply(
            new Add(new Variable("x"), new Variable("y")),
            new Variable("z")
        );
        System.out.printf("Expressão: %s%n", expr2);
        System.out.printf("Resultado: %.2f%n%n", expr2.interpret(variables));
        
        // Expressão 3: (x * y) - (y / z) = (10 * 20) - (20 / 5) = 196
        Expression expr3 = new Subtract(
            new Multiply(new Variable("x"), new Variable("y")),
            new Divide(new Variable("y"), new Variable("z"))
        );
        System.out.printf("Expressão: %s%n", expr3);
        System.out.printf("Resultado: %.2f%n%n", expr3.interpret(variables));
        
        // Expressão 4: 100 + (x - z) = 100 + (10 - 5) = 105
        Expression expr4 = new Add(
            new Number(100),
            new Subtract(new Variable("x"), new Variable("z"))
        );
        System.out.printf("Expressão: %s%n", expr4);
        System.out.printf("Resultado: %.2f%n", expr4.interpret(variables));
    }
}
