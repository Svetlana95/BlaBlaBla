package org.bitbucket.automation.steps;

import org.bitbucket.automation.pages.LoginPage;
import org.bitbucket.automation.pages.OverviewPage;
import org.openqa.selenium.WebDriver;

public class LogIn {

    private String user;
    private String password;

    public LogIn() {
        this.user = "empty";
        this.password = "empty";
    }

    public LogIn(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String doLogIn(WebDriver driver) {
        LoginPage page = new LoginPage(driver);

        page.setUserName(this.user);
        page.setPassword(this.password);

        return page.submitLogIn();
    }

}
