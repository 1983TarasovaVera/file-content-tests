package com.veraTarasova.tests;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class PdfTest {

    @Test
    void simplePdfTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("hello.pdf");
        PDF pdfFile = new PDF(stream);
        Assertions.assertTrue(new String(pdfFile.text).contains("Hello, World!"));
    }
}
