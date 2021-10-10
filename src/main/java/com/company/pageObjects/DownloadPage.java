package com.company.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadPage extends BasePage {

    public DownloadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='some-file.txt']")
    private WebElement downloadTxtLink;

    @Step("Click Download txt file link")
    public DownloadPage clickDownloadTxtFileLink() {
        downloadTxtLink.click();
        return new DownloadPage(driver);
    }
}
