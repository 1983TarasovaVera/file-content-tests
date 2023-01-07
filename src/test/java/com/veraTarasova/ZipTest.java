package com.veraTarasova;

import org.apache.poi.util.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipTest {

    @Test
    void zipTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String entryAsString = null;
        try (ZipInputStream stream = new ZipInputStream(classLoader.getResourceAsStream("hello.zip"))) {
        ZipEntry entry;
        while ((entry = stream.getNextEntry()) != null) {
            byte[] bytes = IOUtils.toByteArray(stream);
            entryAsString = new String(bytes, StandardCharsets.UTF_8);
        }
    }
        Assertions.assertTrue(entryAsString.contains("Hello, World!"));
    }
}
