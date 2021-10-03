package com.company.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HoversPage extends BasePage {

    public HoversPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindAll(@FindBy(xpath = "//img[@alt='User Avatar']"))
    List<WebElement> avatar;

    @FindAll(@FindBy(xpath = "//div[@class='figcaption']/h5"))
    List<WebElement> userName;

    @Step("Hover over Element and get name")
    public List<String> hoverOverElementAndGetName() {
        int avatarCount = avatar.size();
        List<String> res = new ArrayList<String>();
        for (int user = 0; user < avatarCount; user++) {
            Actions act = new Actions(driver);
            act.moveToElement(avatar.get(user)).perform();
            String usernameText = userName.get(user).getText();
            res.add(usernameText);
        }
        return res;
    }
}
