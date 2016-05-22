package org.bitbucket.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateTeamPage {

    private WebDriver driver;
    private final String PAGE_URL = "https://bitbucket.org/account/create-team/";

    @FindBy(css = "#id_team_name")
    private WebElement teamName;

    @FindBy(css = "#create-team-form > div.buttons-container > div > button")
    private WebElement createButton;

    public CreateTeamPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(PAGE_URL);
        PageFactory.initElements(this.driver, this);
    }

    public void setTeamName(String teamName) {
        this.teamName.sendKeys(teamName);
    }

    public void submitCreateTeam() {
        this.createButton.click();
    }

}
