package org.person.interview;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.person.interview.calculator.CalculateState;
import org.person.interview.calculator.Expression;
import org.person.interview.calculator.ICalculator;
import org.person.interview.calculator.ServiceLocator;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class RpnCalculatorTest
{
    private static ICalculator calculator;
    @BeforeClass
    public static void init(){
        calculator = (ICalculator) ServiceLocator.getApplicationContext().getBean("rpnCalculator");
    }

    @Test
    public void testExpressionWithOutOperator()
    {
        Expression expression = Expression.createFromString("clear 5 2");
        CalculateState state = calculator.calculate(expression);
        assertTrue(state.getErrorInfo() == null);
        String[] expected = {"5", "2"};

        assertArrayEquals(expected, state.getOperandStack().toArray(new String[0]));
    }

    @Test
    public void testExpressionWithSqrt()
    {
        Expression expression = Expression.createFromString("clear 2 sqrt");
        CalculateState state = calculator.calculate(expression);
        assertTrue(state.getErrorInfo() == null);

        assertEquals("1.4142135623", state.getOperandStack().pop().substring(0,12));
    }

    @Test
    public void testExpressionWithDivide()
    {
        Expression expression = Expression.createFromString("clear 4 2 /");
        CalculateState state = calculator.calculate(expression);
        assertTrue(state.getErrorInfo() == null);

        assertEquals("2", state.getOperandStack().pop());
    }

    @Test
    public void testExpressionWithDivideZero()
    {
        Expression expression = Expression.createFromString("clear 4 0 /");
        CalculateState state = calculator.calculate(expression);
        assertTrue(state.getErrorInfo() != null);

        String[] expected = {"4", "0"};

        assertArrayEquals(expected, state.getOperandStack().toArray(new String[0]));
    }

    @Test
    public void testExpressionWithMultiply()
    {
        Expression expression = Expression.createFromString("clear 4 2 *");
        CalculateState state = calculator.calculate(expression);
        assertTrue(state.getErrorInfo() == null);

        assertEquals("8", state.getOperandStack().pop());
    }

    @Test
    public void testExpressionWithSubtract()
    {
        Expression expression = Expression.createFromString("clear 4 2 -");
        CalculateState state = calculator.calculate(expression);
        assertTrue(state.getErrorInfo() == null);

        assertEquals("2", state.getOperandStack().pop());
    }

    @Test
    public void testExpressionWithUndo()
    {
        CalculateState state = calculator.calculate(Expression.createFromString("clear 5  4 3 2"));
        state = calculator.calculate(Expression.createFromString("undo undo *"));
        assertTrue(state.getErrorInfo() == null);

        assertEquals("20", state.getOperandStack().pop());
    }

    @Test
    public void testExpressionInvalidOperator()
    {
        CalculateState state = calculator.calculate(Expression.createFromString("clear 5  4 3 2 invalid"));

        assertTrue(state.getErrorInfo() != null);
        assertEquals(state.getErrorInfo().getItem().getValue(), "invalid");
    }

    @Test
    public void testExpressionWithInsufficientParamenters()
    {
        CalculateState state = calculator.calculate(Expression.createFromString("clear 1 2 3 * 5 + * * 6 5"));

        assertTrue(state.getErrorInfo() != null);
        assertEquals(state.getErrorInfo().getItem().getValue(), "*");
        assertEquals(state.getErrorInfo().getItem().getPosition(), 21);

        String[] expected = {"11"};

        assertArrayEquals(expected, state.getOperandStack().toArray(new String[0]));
    }


}
