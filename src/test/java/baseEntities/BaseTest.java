package baseEntities;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import configuration.ReadProperties;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import services.WaitsService;
import steps.ProjectSteps;
import steps.UserSteps;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected UserSteps userSteps;
    protected ProjectSteps projectSteps;
    protected WaitsService waitsService;
    protected Faker faker;

    //Test Data
    protected User admin;

    @BeforeSuite
    public void beforeSuite() {
        Configuration.baseUrl = ReadProperties.getUrl();
    }

    @BeforeMethod
    public void setUp() {
        open(ReadProperties.getUrl());

        faker = new Faker();

        userSteps = new UserSteps();
        projectSteps = new ProjectSteps();

        admin = new User();
        admin.setUsername(ReadProperties.username());
        admin.setPassword(ReadProperties.password());
    }
}
