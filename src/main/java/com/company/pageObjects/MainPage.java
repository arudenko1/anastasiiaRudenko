package com.company.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(linkText = "Form Authentication")
    private WebElement loginLink;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("GoToLogin Page")
    public LoginPage goToLoginPage() {
        loginLink.click();
        return new LoginPage(driver);
    }
}
