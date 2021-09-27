package ua.hillel.tests.selenide;

import com.codeborne.selenide.Configuration;
import com.company.selenidePages.DownloadPage;
import com.company.selenidePages.UploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class DownloadUploadWithSelenideTest {

    @Test
    public void selenideTest() throws IOException {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";

        open("download");
        DownloadPage downloadPage = new DownloadPage();
        File file = downloadPage.downloadFile();
        String pathName = file.getAbsolutePath();//"/Users/anastasiiarudenko/Downloads/some-file.txt";
        Path path = Paths.get(pathName);
        List<String> lines = Files.readAllLines(path);
        lines.add("Test 1");
        lines.add("Test 2");
        Files.write(path, lines);
        open("upload");
        UploadPage uploadPage = new UploadPage();
        uploadPage.uploadFile(file);
        Assert.assertTrue(uploadPage.getMessage().contains("File Uploaded!"));
    }
}
