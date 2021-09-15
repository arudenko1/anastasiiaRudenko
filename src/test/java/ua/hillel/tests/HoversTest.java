package ua.hillel.tests;

import com.company.pageObjects.HoversPage;
import org.testng.annotations.Test;

import java.util.List;

public class HoversTest extends BaseTest {

    @Test(description = "Hovers test")
    public void hoversTest() {
        driver.get(" https://the-internet.herokuapp.com/hovers");
        HoversPage hoversPage = new HoversPage(driver);
        List<String> userNames = hoversPage.hoverOverElementAndGetName();
        for (int i = 0; i < userNames.size(); ++i) {
            System.out.println(userNames.get(i));
        }
    }
}
