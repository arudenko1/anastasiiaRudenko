package ua.hillel.tests;

import com.company.App;
import org.testng.annotations.Test;

public class AppTest {
    @Test
    public void appTest() {
        App app = new App();
        app.getAppInfo();

        System.out.println("I'm test");
    }
}
