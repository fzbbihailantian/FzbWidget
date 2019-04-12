package app.magma.fzbwidget.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)   //测试数组
public class CalculaterUtilsTest {

    CalculaterUtils calculaterUtils;
    int a, b, c;


    @Parameterized.Parameters       //静态方法获取测试数据
    public static Collection list() {
        return Arrays.asList(new Integer[][]{{1, 2, 3}, {4, 5, 9}, {11, 12, 23}});
    }

    public CalculaterUtilsTest(int a, int b, int c) {  //保存测试数据
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Before
    public void setUp() throws Exception {
        calculaterUtils = new CalculaterUtils();
    }

    @Test
    public void sum() {
        int sum = calculaterUtils.sum(a, b);
        assertEquals("calculaterUtils.sum", c, sum, 0);
        assertNotNull(calculaterUtils);
    }

    @Test
    public void substract() {
        int sum = calculaterUtils.substract(5, 1);
        assertEquals("calculaterUtils.sum", 4, sum, 0);
    }
}