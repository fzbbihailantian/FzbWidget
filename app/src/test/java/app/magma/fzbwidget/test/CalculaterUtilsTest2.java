package app.magma.fzbwidget.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculaterUtilsTest2 {

    CalculaterUtils calculaterUtils;
    @Before
    public void setUp() throws Exception {
        calculaterUtils = new CalculaterUtils();
    }

    @Test
    public void divide() {
        int a = calculaterUtils.divide(2,2);
        assertEquals("calculaterUtils.divide",1,a,0);
    }

    @Test
    public void multiply() {
        int a = calculaterUtils.multiply(2,4);
        assertEquals("multiply",8,a,0);
    }
}