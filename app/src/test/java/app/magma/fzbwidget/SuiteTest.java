package app.magma.fzbwidget;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import app.magma.fzbwidget.test.CalculaterUtilsTest;
import app.magma.fzbwidget.test.CalculaterUtilsTest2;

@RunWith(Suite.class)
@Suite.SuiteClasses({CalculaterUtilsTest.class, CalculaterUtilsTest2.class})
public class SuiteTest {
}
