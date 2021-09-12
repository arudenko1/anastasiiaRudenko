package com.company.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ChallengingDomPage extends BasePage {
    public ChallengingDomPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='button']")
    private WebElement button;

    @FindBy(xpath = "//a[@class='button alert']")
    private WebElement buttonAlert;

    @FindBy(xpath = "//a[@class='button success']")
    private WebElement buttonSuccess;

    @FindBys({
            @FindBy(xpath = "//td[4]")
    })

    private List<WebElement> valueInColumn4;

    public ChallengingDomPage clickButton() {
        button.click();
        return new ChallengingDomPage(driver);
    }

    public ChallengingDomPage clickButtonAlert() {
        buttonAlert.click();
        return new ChallengingDomPage(driver);
    }

    public ChallengingDomPage clickButtonSuccess() {
        buttonSuccess.click();
        return new ChallengingDomPage(driver);
    }

    public List<String> getText() {
        List<String> result = new ArrayList<String>();
        int cells_count = valueInColumn4.size();
        for (int cell = 0; cell < cells_count; cell++) {
            String cellText = valueInColumn4.get(cell).getText();
            result.add(cellText);
        }
        return result;
    }
}
