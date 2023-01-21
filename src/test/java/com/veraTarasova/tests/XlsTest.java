package com.veraTarasova.tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class XlsTest {

    @Test
    void simpleXlsTest() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream stream = classLoader.getResourceAsStream("xls-route.xlsx");
        XLS xlsFile = new XLS(stream);
        String cellValue = xlsFile.excel.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
        Assertions.assertTrue(cellValue.equals("msk"));
    }
}
