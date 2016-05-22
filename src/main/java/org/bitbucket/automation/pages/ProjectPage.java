package org.bitbucket.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {

    private WebDriver driver;

    @FindBy(css = "#repo-settings-link")
    private WebElement settingsButton;

    @FindBy(css = "#id_description")
    private WebElement description;

    public ProjectPage(WebDriver driver, String pageUrl) {
        this.driver = driver;
        this.driver.get(pageUrl);
        PageFactory.initElements(this.driver, this);
    }

    public void clickSettingsButton() {
        settingsButton.click();
    }

    public String getDescription() {
        return description.getText();
    }

}
