package com.veraTarasova;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PdfDownloadTest {

    @Test
    void pdfDownload() throws IOException {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File pdfDownload = $(byText("PDF download")).download();
        PDF parsedPdf = new PDF(pdfDownload);
        Assertions.assertTrue(new String(parsedPdf.text).contains("Table of Contents"));
//        Assertions.assertThat(new String(parsedPdf.text).contains("Table of Contents");
//        assertThat(parsedPdf).containsExactText("Table of Contents");
//        assertThat(new String(parsedPdf.content).contains("Table of Contents"));
    }
}
