package ua.hillel.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AdvancedTests extends BaseTest {
   /* Написать несколько тестов по взаимодействию со страницами:

    https://crossbrowsertesting.github.io/drag-and-drop.html -
    написать тест, который будет перетаскивать элементы и проверять результат (Dropped!)

    https://crossbrowsertesting.github.io/hover-menu.html -
    написать тест, который раскрывает dropdown-меню,
    кликает на пункт Secondary Action и проверяет, что текст "Secondary Page" отобразился на странице

    https://the-internet.herokuapp.com/hovers - написать тест, который выводит юзернейм каждого пользователя
    (для этого нужно навести мышку на аватар) */

    @Test(priority = 1, description = "Drag & drop test")
    public void dragAndDropTest() {
        driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
        WebElement From = driver.findElement(By.id("draggable"));
        WebElement To = driver.findElement(By.id("droppable"));
        Actions act = new Actions(driver);
        act.dragAndDrop(From, To).build().perform();
        String text = driver.findElement(By.xpath("//div[@class='ui-widget-header ui-droppable ui-state-highlight']/p")).getText();
        Assert.assertTrue(text.contains("Dropped!"));
    }

    @Test(priority = 2, description = "Dropdown menu test")
    public void dropDownMenuTest() {
        driver.get("https://crossbrowsertesting.github.io/hover-menu.html");
        WebElement dropdownMenu = driver.findElement(By.xpath("//li[@class='dropdown']"));
        Actions act = new Actions(driver);
        act.moveToElement(dropdownMenu).perform();
        WebElement menuSecondary = driver.findElement(By.xpath("//a[text()='Secondary Menu ']"));
        act.moveToElement(menuSecondary).perform();
        WebElement menuSecondaryAction = driver.findElement(By.xpath("//a[text()='Secondary Action']"));
        act.moveToElement(menuSecondaryAction).click(menuSecondaryAction).perform();
        String text = driver.findElement(By.xpath("//div[@class='jumbotron secondary-clicked']/h1")).getText();
        Assert.assertTrue(text.contains("Secondary Page"));
    }

    @Test(priority = 3, description = "Hovers test")
    public void hoversTest() {
        driver.get(" https://the-internet.herokuapp.com/hovers");
        List<WebElement> avatar = driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        int avatarCount = avatar.size();
        for (int user = 0; user < avatarCount; user++) {
            Actions act = new Actions(driver);
            act.moveToElement(avatar.get(user)).perform();
            List<WebElement> username = driver.findElements(By.xpath("//div[@class='figcaption']/h5"));
            String usernameText = username.get(user).getText();
            System.out.println(usernameText);
        }
    }
}
