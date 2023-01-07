package com.veraTarasova;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleFileDownloadTest {

//    static final String PATH_TO_DWD = "downloads";
//    @AfterAll
//    static void releaseFiles() throws IOException {
//        FileUtils.cleanDirectory(new File(PATH_TO_DWD));
//    }

    @Test
    void simpleDownload() throws IOException {
        //для скачивания файлов без href
//        Configuration.proxyEnabled = true;
//        Configuration.fileDownload = PROXY;
        //для скачивания в папку отличную от build. После теста нужно эту папку очистить.
//        Configuration.downloadsFolder = PATH_TO_DWD;
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadedFile = $("#raw-url").download();
        String s;
        try (InputStream is = new FileInputStream(downloadedFile)) {
            s = new String(is.readAllBytes(),"UTF-8");
        }

        String s1 = FileUtils.readFileToString(downloadedFile,"UTF-8");
        Assertions.assertTrue(s1.contains("This repository is the home of the next generation of JUnit"));
    }
}
