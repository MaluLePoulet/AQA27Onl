package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test
    public void test2() {
        userSteps
                .successfulLogin(ReadProperties.username(), ReadProperties.password());

        projectSteps
                .addProject("sdfsd");
    }
}
