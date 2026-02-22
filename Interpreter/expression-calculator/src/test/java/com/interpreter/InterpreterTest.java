package com.interpreter;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class InterpreterTest {
    
    private final Map<String, Double> variables = new HashMap<>();
    
    @Test
    public void testNumberExpression() {
        Expression expr = new Number(42);
        assertEquals(42.0, expr.interpret(variables), 0.001);
    }
    
    @Test
    public void testVariableExpression() {
        variables.put("x", 10.0);
        Expression expr = new Variable("x");
        assertEquals(10.0, expr.interpret(variables), 0.001);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testUndefinedVariable() {
        Expression expr = new Variable("undefined");
        expr.interpret(variables);
    }
    
    @Test
    public void testAddition() {
        variables.put("x", 10.0);
        variables.put("y", 20.0);
        Expression expr = new Add(new Variable("x"), new Variable("y"));
        assertEquals(30.0, expr.interpret(variables), 0.001);
    }
    
    @Test
    public void testSubtraction() {
        variables.put("x", 30.0);
        variables.put("y", 10.0);
        Expression expr = new Subtract(new Variable("x"), new Variable("y"));
        assertEquals(20.0, expr.interpret(variables), 0.001);
    }
    
    @Test
    public void testMultiplication() {
        variables.put("x", 5.0);
        variables.put("y", 4.0);
        Expression expr = new Multiply(new Variable("x"), new Variable("y"));
        assertEquals(20.0, expr.interpret(variables), 0.001);
    }
    
    @Test
    public void testDivision() {
        variables.put("x", 20.0);
        variables.put("y", 4.0);
        Expression expr = new Divide(new Variable("x"), new Variable("y"));
        assertEquals(5.0, expr.interpret(variables), 0.001);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        variables.put("x", 10.0);
        variables.put("y", 0.0);
        Expression expr = new Divide(new Variable("x"), new Variable("y"));
        expr.interpret(variables);
    }
    
    @Test
    public void testComplexExpression() {
        variables.put("x", 10.0);
        variables.put("y", 20.0);
        variables.put("z", 5.0);
        
        // (x + y) * z = (10 + 20) * 5 = 150
        Expression expr = new Multiply(
            new Add(new Variable("x"), new Variable("y")),
            new Variable("z")
        );
        assertEquals(150.0, expr.interpret(variables), 0.001);
    }
}
