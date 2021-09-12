package ua.hillel.tests;

import com.company.pageObjects.SecurePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!", "You logged into a secure area!"},
                {"tomsmith", "Password", "Your password is invalid!"},
                {"tom", "SuperSecretPassword!", "Your username is invalid!"}};
    }

    @Test(dataProvider = "data-provider", description = "Login test")
    public void loginTest(String userName, String password, String message) {
        SecurePage securePage = openApp()
                .goToLoginPage()
                .setUserName(userName)
                .setPassword(password)
                .clickLoginButton();
        Assert.assertTrue(securePage.getMessage().contains(message));
    }
}
