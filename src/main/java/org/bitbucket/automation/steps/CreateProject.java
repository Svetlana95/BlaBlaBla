package org.bitbucket.automation.steps;

import org.bitbucket.automation.pages.CreateProjectPage;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class CreateProject {

    public String createNewProject(WebDriver driver, String projectName, String projectDescription,
                                                String keyName) {
        CreateProjectPage page = new CreateProjectPage(driver);

        page.setProjectName(projectName);
        page.setProjectDescription(projectDescription);
        page.setProjectKey(keyName);
        page.submitCreateProject();

        return driver.getCurrentUrl();
    }

}
