package ua.hillel.tests;

import com.codeborne.selenide.commands.TakeScreenshot;
import com.company.pageObjects.MainPage;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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

    @AfterMethod
    public void takeScreenshot(ITestResult result) throws IOException {
       if (!result.isSuccess()) {
         File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         saveScreenshot(Files.readAllBytes(screenshot.toPath()));
       }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
