package ua.hillel.tests;

import com.company.pageObjects.GeolocationPage;
import org.testng.annotations.Test;

public class GeolocationTest extends BaseTest {
    @Test(description = "Find geolocation test")
    public void findGeolocationTest() {
        driver.get("https://the-internet.herokuapp.com/geolocation");
        GeolocationPage geolocationPage = new GeolocationPage(driver);
        geolocationPage.clickWhereAmIButton();
        String latitude = geolocationPage.getLatitude();
        String longitude = geolocationPage.getLongitude();
        System.out.println("Latitude is " + latitude + " & Longitude is " + longitude);
    }
}
