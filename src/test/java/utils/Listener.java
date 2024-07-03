package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    public void onStart(ITestContext context) {
        System.out.println("Test starts here");
    }

    public void onFinish(ITestContext context) {
        System.out.println("Test finished here");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Make a screenshot");
    }
}
