package com.company.selenidePages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.*;

public class DownloadPage {

    SelenideElement linkToFile = $(By.linkText("some-file.txt"));

    public File downloadFile() throws FileNotFoundException {
        File file = linkToFile.download();
        return file;
    }
}
