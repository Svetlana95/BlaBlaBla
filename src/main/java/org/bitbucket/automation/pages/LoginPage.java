package org.bitbucket.automation.pages;

import com.google.common.annotations.VisibleForTesting;
import org.bitbucket.automation.businessObject.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;
    private final String PAGE_URL = "https://bitbucket.org/account/signin/";

    // это аннотация(@) с полем
    // элемент  на стронице может быть выбран либо с использованием css селекторов или xpath
    // свзязывает поле класса с полем на странице
    @FindBy(css = "#js-email-field")
    private WebElement userName; // поле класса

    @FindBy(css = "#js-password-field")
    private WebElement password;

    @FindBy(css = "#aid-login-form > div.button-container.submit-container > input")
    private WebElement logInButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(PAGE_URL);
        PageFactory.initElements(this.driver, this);// связывает драйвер со страницей
    }

    // создаем методы для обращения к свойстам класса, т.к. они private
    public LoginPage setUserName(String name) {
        this.userName.sendKeys(name);
        return this;
    }

    public LoginPage setPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public String submitLogIn() {
        this.logInButton.click();
        this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        return this.driver.getTitle();
    }

}
