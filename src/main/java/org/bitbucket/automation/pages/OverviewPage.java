package org.bitbucket.automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {

    private WebDriver driver;
    private final String PAGE_URL = "https://bitbucket.org/dashboard/overview";

    @FindBy(css = "#repositories-dropdown-trigger")
    private WebElement menuItem_Repositories;

    @FindBy(css = "#create-repo-link")
    private WebElement menuSubItem_Repositories_CreateRepository;

    @FindBy(css = "#import-repo-link")
    private WebElement menuSubItem_Repositories_ImportRepository;

    @FindBy(css = "#create-repo")
    private WebElement createRepository;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(PAGE_URL);
        PageFactory.initElements(this.driver, this);
    }

    public String clickCreateRepositoryButton() {
        createRepository.click();
        return this.driver.getCurrentUrl();
    }

    public void clickRepositoryMenuItem() {
        menuItem_Repositories.click();
    }

    public String clickCreateRepository() {
        menuSubItem_Repositories_CreateRepository.click();
        return driver.getCurrentUrl();
    }

}
