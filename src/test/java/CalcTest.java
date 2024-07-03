import data.StaticDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalcTest extends BaseTest {

    @Test(description = "Valid test with int values", testName = "Correct division of int values",
            groups = {"smoke", "regression"}, priority = 1)
    public void testDivInt() {
        Assert.assertEquals(calculator.divide(6, 2), 3);
    }

    @Test(description = "Test method when result is floating-point number", testName = "Incorrect int division result",
            groups = "regression", dependsOnGroups = "smoke", priority = 2)
    public void testDivInt1() {
        Assert.assertEquals(calculator.divide(5, 2), 2, "Incorrect result");
    }

    @Test(enabled = false)
    public void testDivInt2() {
        Assert.assertEquals(calculator.divide(34, 3), 11.333, "Incorrect result");
    }

    @Test(description = "Valid test with double values", testName = "Correct division of double values",
            groups = {"smoke", "regression"}, priority = 1)
    public void testDivDouble() {
        Assert.assertEquals(calculator.divide(6.2, 3.1), 2.0);
    }

    @Test(testName = "Division by zero (double)", dependsOnMethods = "testDivDouble",
            alwaysRun = true, invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3,
            groups = {"smoke", "regression"})
    public void testDivDouble1() {
        Assert.assertEquals(calculator.divide(2.0, 0), Double.POSITIVE_INFINITY);
        Assert.assertEquals(calculator.divide(-2.0, 0), Double.NEGATIVE_INFINITY);
        Assert.assertEquals(calculator.divide(0.0, 0), Double.NaN);
        System.out.println(Thread.currentThread().getName());
    }

    @Test(testName = "Division by zero (int)", expectedExceptions = ArithmeticException.class,
            dependsOnMethods = "testDivInt", groups = {"smoke", "regression"})
    public void testDivIntByZero() {
        calculator.divide(2, 0);
    }

    @Test(description = "Dividing int values with Data Provider",
            dataProvider = "dataIntForDivTest", dataProviderClass = StaticDataProvider.class, threadPoolSize = 3,
            groups = {"smoke", "regression"})
    public void testDivInt(int a, int b, int result) {
        System.out.println(Thread.currentThread().getName());
        Assert.assertEquals(calculator.divide(a, b), result);
    }

    @Test(description = "Dividing double values with Data Provider",
            dataProvider = "dataForDoubleDivTest", dataProviderClass = StaticDataProvider.class, threadPoolSize = 3,
            groups = {"smoke", "regression"})
    public void testDivDouble(double a, double b, double result) {
        System.out.println(Thread.currentThread().getName());
        Assert.assertEquals(calculator.divide(a, b), result);
    }
}