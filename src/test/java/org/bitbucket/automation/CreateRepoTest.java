package org.bitbucket.automation;

import org.bitbucket.automation.businessObject.User;
import org.bitbucket.automation.steps.CreateRepo;
import org.bitbucket.automation.steps.LogIn;
import org.bitbucket.automation.steps.Project;
import org.bitbucket.automation.utils.StringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateRepoTest {

    private WebDriver driver;
    private CreateRepo actions;

    @BeforeTest
    public void prepareUtils() {
        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
        this.actions = new CreateRepo();

        new LogIn(User.email, User.password).doLogIn(driver);
    }

    @AfterTest
    public void completeUtils() {
        this.driver.quit();
    }

    @Test
    public void testCreteRepo_withoutSettings() {
        String repoName = StringGenerator.getString();

        String result = this.actions.createNewRepositoryWithoutAdvancedSettings(this.driver, repoName);

        Assert.assertEquals(result.contains(repoName), true);
    }

    @Test
    public void testCreteRepo_withSettings() {
        String repoName = StringGenerator.getString();
        String description = "Test project: ".concat(repoName);
        String language = "Java";

        String resultUrl = this.actions.createNewRepositoryWithAdvancedSettings(this.driver, repoName,
                description, language);

        Project createdProject = new Project();
        String projectDescription = createdProject.getProjectDescription(this.driver, resultUrl);

        Assert.assertEquals(resultUrl.contains(repoName), true);
        Assert.assertEquals(description.contains(projectDescription), true);
    }

}