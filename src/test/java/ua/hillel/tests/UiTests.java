package ua.hillel.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class UiTests extends BaseTest {

    /* Task 1:
    Написать несколько тестов по взаимодействию со страницами:
    https://the-internet.herokuapp.com/challenging_dom - нужно кликнуть на каждую кнопку.
    после этого нужно выбрать все значения из 4й колонки и вывести на экран.
    Уточнение: число внизу, которое меняется по клику, отрисовывается динамически, его достать нельзя,
    потому не нужно проверять что оно изменилось после клика */

    @Test(priority = 1, description = "UI test")
    public void uiTest() {
        driver.get("https://the-internet.herokuapp.com/challenging_dom");
        driver.findElement(By.xpath("//a[@class='button']")).click();
        driver.findElement(By.xpath("//a[@class='button alert']")).click();
        driver.findElement(By.xpath("//a[@class='button success']")).click();
        List<WebElement> valueInColumn4 = driver.findElements(By.xpath("//td[4]"));
        int cells_count = valueInColumn4.size();
        for (int cell = 0; cell < cells_count; cell++) {
            String cellText = valueInColumn4.get(cell).getText();
            System.out.println("Value in column 4: " + cellText);
        }
    }

    /* Task 2:
    https://the-internet.herokuapp.com/login - написать 2 теста, на корректный и некорректный логин.
    В первом случае - проверить, что отображается сообщение "You logged into a secure area!",
    во втором сообщение об ошибке логина/пароля */

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!", "You logged into a secure area!"},
                {"tomsmith", "Password", "Your password is invalid!"},
                {"tom", "SuperSecretPassword!", "Your username is invalid!"}};
    }

    @Test(priority = 2, dataProvider = "data-provider", description = "Login test")
    public void loginTest(String userName, String password, String message) {
        driver.get("https://the-internet.herokuapp.com/login");
        WebElement inputField1 = driver.findElement(By.xpath("//input[@id='username']"));
        inputField1.sendKeys(userName);
        WebElement inputField2 = driver.findElement(By.xpath("//input[@id='password']"));
        inputField2.sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit' and .=' Login']")).click();
        String text = driver.findElement(By.id("flash")).getText();
        Assert.assertTrue(text.contains(message));
    }

    /* Task 3:
    https://the-internet.herokuapp.com/geolocation - кликнуть на кнопку, и после клика - достать значения координат,
    которые будут выводиться на экран.
    После клика нужно вставить задержку, иначе код может падать.
    Проще всего сделать через Thread.sleep(1000) (также нужно обработать исключение) */

    @Test(priority = 3, description = "Find geolocation test")
    public void findGeolocationTest() {
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.findElement(By.xpath("//button[text()='Where am I?']")).click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lat-value")));
        String latitude = driver.findElement(By.id("lat-value")).getText();
        String longitude = driver.findElement(By.id("long-value")).getText();
        System.out.println("Latitude is " + latitude + " & Longitude is " + longitude);
    }
}
