package com.company.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeolocationPage extends BasePage {

    public GeolocationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Where am I?']")
    private WebElement buttonWhereAmI;


    @FindBy(id = "lat-value")
    private WebElement textLatitude;

    @FindBy(id = "long-value")
    private WebElement textLongitude;

    @Step("Click Where Am I Button")
    public GeolocationPage clickWhereAmIButton() {
        buttonWhereAmI.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(textLatitude));
        return new GeolocationPage(driver);
    }

    @Step("Get Latitude")
    public String getLatitude() {
        return textLatitude.getText();
    }

    @Step("Get Longitude")
    public String getLongitude() {
        return textLongitude.getText();
    }
}
