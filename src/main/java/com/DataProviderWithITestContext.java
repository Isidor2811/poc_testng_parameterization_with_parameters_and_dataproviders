package com;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class DataProviderWithITestContext {

    @DataProvider(name = "withITestContext")
    public static Object[][] getDataWithITextContext(ITestContext iTestContext) {
        String testNameFromXmlFile = iTestContext.getName();
        switch (testNameFromXmlFile) {
            case "Regression part #1" -> {
                return new Object[][]{{1, 3, 4}, {9, 9, 18}};
            }
            case "Regression part #2" -> {
                return new Object[][]{{1, 3, -2}, {9, 9, 0}};
            }
            default -> throw new IllegalStateException("Unexpected value: " + testNameFromXmlFile);
        }
    }
}
