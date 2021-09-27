package ua.hillel.tests.selenide;

import com.company.selenidePages.DynamicControlsPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

//        Написать PageObject и тест для https://the-internet.herokuapp.com/dynamic_controls .
//        На странице нужно удалять/добавлять чекбокс и включать/выключать текстовое поле

public class DynamicControlTest {

    @Test
    public void dynamicControlTest() {
        open("https://the-internet.herokuapp.com/dynamic_controls");
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
        dynamicControlsPage.setCheckbox();
        dynamicControlsPage.addOrRemoveCheckbox(true);
        dynamicControlsPage.addOrRemoveCheckbox(false);
        dynamicControlsPage.setCheckbox();
        dynamicControlsPage.enableOrDisableTextField(false);
        dynamicControlsPage.enableOrDisableTextField(true);
    }
}
