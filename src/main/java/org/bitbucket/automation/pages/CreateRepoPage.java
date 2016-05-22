package org.bitbucket.automation.pages;

import org.bitbucket.automation.utils.StringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateRepoPage {

    private WebDriver driver;
    private final String PAGE_URL = "https://bitbucket.org/repo/create";

    @FindBy(css = "#id_name")
    private WebElement repositoryName;

    @FindBy(css = "#id_scm_0")
    private WebElement repositoryType_Git;

    @FindBy(css = "#id_scm_1")
    private WebElement repositoryType_Mercurial;

    @FindBy(css = "#create-form > div.repo-create--expandable > button > span")
    private WebElement advancedSettings;

    @FindBy(css = "#id_description")
    private WebElement settingsDescription;

    @FindBy(css = "#s2id_id_language > a > span.select2-chosen")
    private WebElement languagePickList;

    @FindBy(css = "#select2-drop > div > input")
    private WebElement languageInput;

    @FindBy(css = "#create-form > div.buttons-container > div > button")
    private WebElement createRepository;

    @FindBy(css = "#select2-drop > ul > li > ul > li:nth-child(1)")
    private WebElement targetLanguage;

    public enum ReportType {
        GIT,
        MERCURIAL
    }

    public CreateRepoPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(PAGE_URL);
        PageFactory.initElements(this.driver, this);
    }

    public void setRepositoryName(String nameRepository) {
        repositoryName.sendKeys(nameRepository);
    }

    public void setReportType(ReportType type) {
        switch (type) {
            case GIT: repositoryType_Git.click();
                break;
            case MERCURIAL: repositoryType_Mercurial.click();
                break;
        }
    }

    public void showAdvancedSettings() {
        advancedSettings.click();
    }

    public void setDescription(String description) {
        settingsDescription.sendKeys(description);
    }

    public void showLanguagePickList() {
        languagePickList.click();
    }

    public void inputLanguage(String language) {
        languageInput.sendKeys(language);
    }

    public void submitCreateRepository() {
        createRepository.click();
    }

    public void submitSelectLanguage() {
        targetLanguage.click();
    }

}
