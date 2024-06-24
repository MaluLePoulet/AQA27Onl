import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CalcTest extends BaseTest {

    @Test
    public void testSum() {
        Assert.assertEquals(calculator.add(2, 3), 5, "Incorrect result");
    }

    @Test(enabled = false)
    public void testSum1() {
        Assert.assertEquals(calculator.add(2, 3), 5, "Incorrect result");
    }

    @Test(description = "Test with description")
    public void testSum2() {
        Assert.assertEquals(calculator.add(2, 3), 5, "Incorrect result");
    }

    @Test(testName = "Test with Name")
    public void testSum3() {
        Assert.assertEquals(calculator.add(2, 3), 5, "Incorrect result");
    }

    @Test(timeOut = 1000)
    public void waitLongTimeTest() throws InterruptedException {
        Thread.sleep(900);
    }

    @Test(invocationCount = 4, threadPoolSize = 2)
    public void invocationCountTest() {
        System.out.println(Thread.currentThread().getName());
        Assert.assertTrue(true);
    }

    @Test(invocationCount = 4, invocationTimeOut = 1000)
    public void invocationCountTest1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(500);
        Assert.assertTrue(true);

    }

    @Test
    public void exceptionTest1() {
        // ТАК ДЕЛАТЬ НЕ НАДО
        try {
            List list = null;
            int size = list.size();
        } catch (NullPointerException ex) {
            Assert.assertTrue(true);
        }
    }

    // ТАК ДЕЛАТЬ НАДО
    @Test(expectedExceptions = NullPointerException.class)
    public void exceptionTest2() {
        List list = null;
        int size = list.size();
    }
}

