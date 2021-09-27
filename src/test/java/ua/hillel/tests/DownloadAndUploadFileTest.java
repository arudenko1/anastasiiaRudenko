package ua.hillel.tests;

import com.company.pageObjects.DownloadPage;
import com.company.pageObjects.UploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DownloadAndUploadFileTest extends BaseTest {

    /* Написать тест, который будет скачивать файл с сервера, его модифицировать и потом загружать обратно.
     Для скачивания - использовать страницу https://the-internet.herokuapp.com/download
     Отсюда нужно скачать любой текстовый файл (при желании - можно усложнить, скачать рандомно любой из текстовых).
     В этот файл записать несколько строк (содержимое строк - не важно)
     Для загрузки файла на сервер - использовать страницу https://the-internet.herokuapp.com/upload
     проверить, что файл загружается
     Логику работы со страницами - вынести в классы PageObject
     Логика работы с файлами должны быть в тесте */

    @Test(description = "Download and upload file test")
    public void downloadAndUploadFileTest() throws IOException {
        driver.get("https://the-internet.herokuapp.com/download");
        DownloadPage downloadPage = new DownloadPage(driver);
        downloadPage
                .clickDownloadTxtFileLink();
        String pathName = "/Users/anastasiiarudenko/Downloads/some-file.txt";
        Path path = Paths.get(pathName);
        List<String> lines = Files.readAllLines(path);
        lines.add("Test 1");
        lines.add("Test 2");
        Files.write(path, lines);
        driver.get("https://the-internet.herokuapp.com/upload");
        UploadPage uploadPage = new UploadPage(driver);
        uploadPage
                .uploadFile(pathName);
        Assert.assertTrue(uploadPage.getMessage().contains("File Uploaded!"));
    }
}
