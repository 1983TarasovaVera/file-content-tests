package com.veraTarasova;

import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.extractor.POITextExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DocTest {

    @Test
    void docTest() throws IOException {
        POIFSFileSystem fileSystem;
        String extractedText;
        try (InputStream stream = new FileInputStream("src/test/resources/hello.doc")) {
            fileSystem = new POIFSFileSystem(stream);
            POITextExtractor extractor = ExtractorFactory.createExtractor(fileSystem);
            extractedText = extractor.getText();
        }
        Assertions.assertTrue(extractedText.contains("Hello, World!"));
    }
}
