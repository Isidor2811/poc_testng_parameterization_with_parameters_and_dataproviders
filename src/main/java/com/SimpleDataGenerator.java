package com;

import org.testng.annotations.DataProvider;

public class SimpleDataGenerator {

    @DataProvider(name = "simpleStaticGenerator")
    public static Object[][] staticDataGeneratorInOtherClass() {
        return new Object[][]{
                {1, 3, 4},
                {2, 12, 14},
                {8, 22, 30},
        };
    }

}
