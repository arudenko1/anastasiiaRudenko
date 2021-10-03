package com.company.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePage extends BasePage {

    @FindBy(id = "flash")
    private WebElement message;

    @FindBy(css = "a.button")
    private WebElement logoutButton;


    public SecurePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Get message")
    public String getMessage() {
        return message.getText();
    }

    @Step("Logout")
    public LoginPage logout() {
        logoutButton.click();
        return new LoginPage(driver);
    }
}
