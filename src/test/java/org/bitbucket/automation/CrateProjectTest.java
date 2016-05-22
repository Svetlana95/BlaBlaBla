package org.bitbucket.automation;

import org.bitbucket.automation.businessObject.User;
import org.bitbucket.automation.steps.CreateProject;
import org.bitbucket.automation.steps.CreateRepo;
import org.bitbucket.automation.steps.LogIn;
import org.bitbucket.automation.utils.StringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class CrateProjectTest {

    private WebDriver driver;

    @BeforeTest
    public void prepareUtils() {
        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();

        new LogIn(User.email, User.password).doLogIn(driver);
    }

    @AfterTest
    public void completeUtils() {
        this.driver.quit();
    }

    @Test
    public void testCreateNewProject() {
        CreateProject action = new CreateProject();
        String projectName = StringGenerator.getString();
        String projectKey = "A".concat(projectName.substring(0,4));
        String projectDescription = "Test description ".concat(projectName);

        String resultUrl = action.createNewProject(this.driver, projectName, projectDescription, projectKey);

        Assert.assertEquals(resultUrl.contains(projectKey), true);
    }

}
