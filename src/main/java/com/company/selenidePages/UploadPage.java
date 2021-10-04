package com.company.selenidePages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UploadPage {

    SelenideElement fileInput = $(("input[type ='file']"));
    SelenideElement uploadButton = $("#file-submit");
    SelenideElement message = $x("//h3[text()='File Uploaded!']");

    @Step("Upload file")
    public UploadPage uploadFile(File file) {
        fileInput.uploadFile(file);
        uploadButton.click();
        return this;
    }

    @Step("Get message")
    public String getMessage() {
        return message.getText();
    }
}
