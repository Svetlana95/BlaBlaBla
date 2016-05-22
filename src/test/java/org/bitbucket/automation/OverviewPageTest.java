package org.bitbucket.automation;

import org.bitbucket.automation.businessObject.User;
import org.bitbucket.automation.steps.LogIn;
import org.bitbucket.automation.steps.Overview;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OverviewPageTest {

    private WebDriver driver;
    private Overview actions;

    @BeforeTest
    public void prepareUtils() {
        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
        this.actions = new Overview();

        new LogIn(User.email, User.password).doLogIn(driver);
    }

    @AfterTest
    public void completeUtils() {
        this.driver.quit();
    }

    /*@Test
    public void testCreateRepository_AcrossButton() {
        String result = this.actions.doCreateRepository(this.driver);

        Assert.assertEquals(result.toLowerCase().contains("repo/create"), true);
    }*/

    @Test
    public void testCreateRepository_AcrossMenu() {
        String result = this.actions.doCreateRepositoryAcrossMenu(this.driver);

        Assert.assertEquals(result.toLowerCase().contains("repo/create"), true);
    }

}
