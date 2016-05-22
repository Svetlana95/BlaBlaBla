package org.bitbucket.automation;

import org.bitbucket.automation.businessObject.User;
import org.bitbucket.automation.steps.CreateRepo;
import org.bitbucket.automation.steps.CreateTeam;
import org.bitbucket.automation.steps.LogIn;
import org.bitbucket.automation.utils.StringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateTeamTest {

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
    public void testCreateNewTeam() {
        CreateTeam action = new CreateTeam();
        String teamName = StringGenerator.getString();

        String resultUrl =  action.createTeam(this.driver, teamName);
        Assert.assertEquals(resultUrl.contains(teamName), true);
    }

}
