package com.company.selenidePages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DynamicControlsPage {

    private SelenideElement checkbox = $("input[type='checkbox']");
    private SelenideElement removeCheckboxButton = $("#checkbox-example button");
    private SelenideElement textField = $x("//input[@type='text']");
    private SelenideElement enableButton = $("#input-example > button");

    public void setCheckbox() {
        checkbox.shouldBe(Condition.appear).shouldBe(Condition.visible).click();
    }

    public void addOrRemoveCheckbox(boolean remove) {
        removeCheckboxButton.shouldBe(Condition.enabled).click();
        if (remove) {
            checkbox.should(Condition.disappear);
        } else
            checkbox.should(Condition.appear);
    }

    public void enableOrDisableTextField(boolean disable) {
        enableButton.click();
        if (disable) {
            textField.should(Condition.disabled);
        } else
            textField.should(Condition.enabled);
    }
}
