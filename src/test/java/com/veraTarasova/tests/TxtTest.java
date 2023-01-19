package com.veraTarasova.tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class TxtTest {

    @Test
    void txtTest() throws IOException {
        String s1 = FileUtils.readFileToString(new File("src/test/resources/hello.txt"),"UTF-8");
        Assertions.assertTrue(s1.contains("Hello, World!"));
    }
}
