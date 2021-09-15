package ua.hillel.tests;

import com.company.pageObjects.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    static void webDriverManagerSetup() {
        driver = new ChromeDriver();
    }

    @AfterClass
    static void quitBrowser() {
        driver.quit();
    }

    public MainPage openApp() {
        driver.get("https://the-internet.herokuapp.com/");
        return new MainPage(driver);
    }
}
