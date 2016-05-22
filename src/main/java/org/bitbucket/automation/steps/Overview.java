package org.bitbucket.automation.steps;

import org.bitbucket.automation.pages.OverviewPage;
import org.openqa.selenium.WebDriver;

public class Overview {

    public String doCreateRepository(WebDriver driver) {
        OverviewPage page = new OverviewPage(driver);

        return page.clickCreateRepositoryButton();
    }

    public String doCreateRepositoryAcrossMenu(WebDriver driver) {
        OverviewPage page = new OverviewPage(driver);
        page.clickRepositoryMenuItem();
        return page.clickCreateRepository();
    }

}
