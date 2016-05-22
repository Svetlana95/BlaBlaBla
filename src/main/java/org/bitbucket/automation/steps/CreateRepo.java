package org.bitbucket.automation.steps;

import org.bitbucket.automation.pages.CreateRepoPage;
import org.bitbucket.automation.utils.StringGenerator;
import org.openqa.selenium.WebDriver;

public class CreateRepo {

    public CreateRepo() {}

    public String createNewRepositoryWithoutAdvancedSettings(WebDriver driver, String repoName) {
        CreateRepoPage page = new CreateRepoPage(driver);

        page.setRepositoryName(repoName);
        page.setReportType(CreateRepoPage.ReportType.GIT);
        page.submitCreateRepository();

        return driver.getCurrentUrl();
    }

    public String createNewRepositoryWithAdvancedSettings(WebDriver driver, String repoName, String description,
                                                        String language) {
        CreateRepoPage page = new CreateRepoPage(driver);

        page.setRepositoryName(repoName);
        page.setReportType(CreateRepoPage.ReportType.GIT);
        page.showAdvancedSettings();
        page.setDescription(description);
        page.showLanguagePickList();
        page.inputLanguage(language);
        page.submitSelectLanguage();

        page.submitCreateRepository();
        return driver.getCurrentUrl();
    }

}
