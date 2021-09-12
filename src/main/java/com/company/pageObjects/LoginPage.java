package com.company.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(userNameInput));
    }

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;


    @FindBy(xpath = "//button[@type='submit' and .=' Login']")
    private WebElement loginButton;

    public LoginPage setUserName(String userName) {
        setValue(userNameInput, userName);
        return this;
    }

    public LoginPage setPassword(String password) {
        setValue(passwordInput, password);
        return this;
    }

    public SecurePage clickLoginButton() {
        loginButton.click();
        return new SecurePage(driver);
    }
}
