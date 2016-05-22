package org.bitbucket.automation.steps;

import org.bitbucket.automation.pages.CreateTeamPage;
import org.openqa.selenium.WebDriver;

public class CreateTeam {

    public String createTeam(WebDriver driver, String teamName) {
        CreateTeamPage page = new CreateTeamPage(driver);

        page.setTeamName(teamName);
        page.submitCreateTeam();

        return driver.getCurrentUrl();
    }

}
