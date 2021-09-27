package com.company.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class UploadPage extends BasePage {

    public UploadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='file']")
    private WebElement fileInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement uploadButton;

    @FindBy(xpath = "//h3[text()='File Uploaded!']")
    private WebElement message;


    public UploadPage uploadFile(String path) {
        fileInput.sendKeys(new File(path).getAbsolutePath());
        uploadButton.click();
        return this;
    }

    public String getMessage() {
        return message.getText();
    }
}
