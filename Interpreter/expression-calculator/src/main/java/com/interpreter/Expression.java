package com.interpreter;

import java.util.Map;

/**
 * Interface abstrata para expressões
 * Define o contrato para interpretar expressões
 */
public sealed interface Expression permits Number, Variable, Add, Subtract, Multiply, Divide {
    
    /**
     * Interpreta a expressão com as variáveis fornecidas
     */
    double interpret(Map<String, Double> variables);
}
