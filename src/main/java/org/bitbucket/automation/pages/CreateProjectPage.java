package org.bitbucket.automation.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProjectPage {

    private WebDriver driver;
    private String PAGE_URL = "https://bitbucket.org/account/projects/create";

    @FindBy(css = "#id_name")
    private WebElement projectName;

    @FindBy(css = "#id_description")
    private WebElement projectDescription;

    @FindBy(css = "#id_key")
    private WebElement projectKey;

    @FindBy(xpath = "//button[@class=\"aui-button aui-button-primary\"]")
    private WebElement createProjectButton;

    public CreateProjectPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(PAGE_URL);
        PageFactory.initElements(this.driver, this);
    }

    public void setProjectName(String projectName) {
        this.projectName.sendKeys(projectName);
    }

    public void setProjectKey(String projectKey) {
        this.projectKey.sendKeys(Keys.chord(Keys.CONTROL, "a"), projectKey);
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription.sendKeys(projectDescription);
    }

    public String getProjectKey() {
        return this.projectKey.getText();
    }

    public void submitCreateProject() {
        this.createProjectButton.click();
    }

}
