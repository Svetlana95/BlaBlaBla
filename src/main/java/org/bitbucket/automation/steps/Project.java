package org.bitbucket.automation.steps;

import org.bitbucket.automation.pages.ProjectPage;
import org.openqa.selenium.WebDriver;

public class Project {

    public String getProjectDescription(WebDriver driver, String pageUrl) {
        ProjectPage page = new ProjectPage(driver, pageUrl);

        page.clickSettingsButton();
        return page.getDescription();
    }

}
