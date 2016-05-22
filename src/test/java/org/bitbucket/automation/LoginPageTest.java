package org.bitbucket.automation;

import org.bitbucket.automation.businessObject.User;
import org.bitbucket.automation.steps.LogIn;
import org.bitbucket.automation.utils.StringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {

    private WebDriver driver;

    @BeforeTest
    public void prepareUtils() {
        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
    }

    @AfterTest
    public void completeUtils() {
        this.driver.quit();
    }

    @Test
    public void testLogin() {
        LogIn actions = new LogIn(User.email, User.password);

        String result = actions.doLogIn(driver);

        Assert.assertEquals(result.toLowerCase().contains("home"), true);
    }

}
