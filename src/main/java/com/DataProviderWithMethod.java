package com;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderWithMethod {

    @DataProvider
    public static Object[][] getDataWithMethod(Method testMethod) {
        String testMethodName = testMethod.getName();
        switch (testMethodName) {
            case "testSumOfTwoNumbers" -> {
                return new Object[][]{{3, 5, 8}, {11, 11, 22}};
            }
            case "testSumOfThreeNumbers" -> {
                return new Object[][]{{3, 5, 5, 13}, {11, 11, 0, 22}};
            }
            default -> throw new IllegalStateException("Unexpected value: " + testMethodName);
        }
    }

}
