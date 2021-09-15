package ua.hillel.tests;

import com.company.pageObjects.ChallengingDomPage;
import org.testng.annotations.Test;

import java.util.List;

public class ChallengingDomTest extends BaseTest {

    @Test(description = "UI test")
    public void uiTest() {
        driver.get("https://the-internet.herokuapp.com/challenging_dom");

        ChallengingDomPage challengingDomPage = new ChallengingDomPage(driver)
                .clickButton()
                .clickButtonAlert()
                .clickButtonSuccess();
        List<String> valueInColumn4 = challengingDomPage
                .getText();

        for (int i = 0; i < valueInColumn4.size(); ++i) {
            System.out.println("Value in column 4: " + valueInColumn4.get(i));
        }
    }
}
