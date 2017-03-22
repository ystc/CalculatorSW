package at.sw2017.calculator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by ystc on 16.03.2017.
 */

public class CalculatorUnitTest {
    int result;
    @Test
    public void testDoAddition(){
        result = Calculations.doAdd(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testDoSubstraction(){
        result = Calculations.doSub(7, 5);
        assertEquals(2, result);
    }

    @Test
    public void testDoDiv(){
        result = Calculations.doDiv(10, 5);
        assertEquals(2, result);
    }

    @Test
    public void testDoDiv1(){
        result = Calculations.doDiv(4, 0);
        assertEquals(0, result);
    }

    @Test
    public void testDoDiv2(){
        result = Calculations.doDiv(11, 3);
        assertEquals(3, result);
    }

    @Test
    public void testDoMult(){
        result = Calculations.doMult(2, 3);
        assertEquals(6, result);
    }
}
