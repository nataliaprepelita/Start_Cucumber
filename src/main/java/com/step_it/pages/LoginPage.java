package com.step_it.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = ".login_logo")
    private WebElement logo;

    @FindBy(css = "#user-name")
    private WebElement userNameInput;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(css = "#login-button")
    private WebElement loginButton;

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public void login(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
