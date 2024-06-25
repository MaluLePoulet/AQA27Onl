import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalcTest extends BaseTest {

    @Test(description = "Valid test with int values",
            testName = "Correct division of int values", priority = 1)
    public void testDivInt() {
        Assert.assertEquals(calculator.divide(6, 2), 3);
    }

    @Test(description = "Test method when result is floating-point number",
            testName = "Incorrect int division result", priority = 2)
    public void testDivInt1() {
        Assert.assertEquals(calculator.divide(5, 2), 2, "Incorrect result");
    }

    @Test(enabled = false)
    public void testDivInt2() {
        Assert.assertEquals(calculator.divide(34, 3), 11.333, "Incorrect result");
    }

    @Test(description = "Valid test with double values",
            testName = "Correct division of double values", priority = 1)
    public void testDivDouble() {
        Assert.assertEquals(calculator.divide(6.2, 3.1), 2.0);
    }

    @Test(testName = "Division by zero (double)", dependsOnMethods = "testDivDouble", alwaysRun = true,
            invocationCount = 3, invocationTimeOut = 1000)
    public void testDivDouble1() {
        Assert.assertEquals(calculator.divide(2.0, 0), Double.POSITIVE_INFINITY);
        Assert.assertEquals(calculator.divide(-2.0, 0), Double.NEGATIVE_INFINITY);
        Assert.assertEquals(calculator.divide(0.0, 0), Double.NaN);
    }

    @Test(testName = "Division by zero (int)",
            expectedExceptions = ArithmeticException.class, dependsOnMethods = "testDivInt")
    public void testDivIntByZero() {
        calculator.divide(2, 0);
    }
}