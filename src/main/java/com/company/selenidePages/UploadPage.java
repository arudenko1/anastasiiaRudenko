package com.company.selenidePages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UploadPage {

    SelenideElement fileInput = $(("input[type ='file']"));
    SelenideElement uploadButton = $("#file-submit");
    SelenideElement message = $x("//h3[text()='File Uploaded!']");

    public UploadPage uploadFile(File file) {
        fileInput.uploadFile(file);
        uploadButton.click();
        return this;
    }

    public String getMessage() {
        return message.getText();
    }
}
