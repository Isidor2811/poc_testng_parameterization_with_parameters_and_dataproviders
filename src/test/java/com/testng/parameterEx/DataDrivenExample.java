package com.testng.parameterEx;

import com.DataProviderWithITestContext;
import com.DataProviderWithMethod;
import com.SimpleDataGenerator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenExample {


    @DataProvider
    public Object[][] getDataForTest() {
        return new Object[][]{
                {"Admin", "admin134"},
                {"General", "user"},
                {"Buyer", "buyer0999"},
                {"Global", "gLobUser"},

        };
    }

    @Test(dataProvider = "getDataForTest")
    public void loginTest(String userName, String password) {
        System.out.println(Thread.currentThread().getId());
        System.out.println("Login with: " + userName + "" + password);
    }


    // Если дата провайдер находиться в другом классе, то такой метод должен быть статическим
    // и в самом тесте нужно указать клас в котором находиться даный метод
    @Test(dataProvider = "simpleStaticGenerator", dataProviderClass = SimpleDataGenerator.class)
    public void sumTest(int a, int b, int expected) {
        Assert.assertEquals(a + b, expected);
    }


    // два следующих тестовых метода используют дата провайдер который принимает на вход название тестового метода
    // и в зависимости от этого название генерирует тестовою дату
    @Test(dataProvider = "getDataWithMethod", dataProviderClass = DataProviderWithMethod.class)
    public void testSumOfTwoNumbers(int a, int b, int expected) {
        Assert.assertEquals(a + b, expected);
    }

    @Test(dataProvider = "getDataWithMethod", dataProviderClass = DataProviderWithMethod.class)
    public void testSumOfThreeNumbers(int a, int b, int c, int expected) {
        Assert.assertEquals(a + b + c, expected);
    }


    //два следующих тестовых метода используют дата провайдер который принимает на вход название ITestContext
    //это интерфейс который позволяет получить тестовою инфоримацию (название теста, название сьюта, тесты которые упали, тесты которые прошли и так далее)
    // в дата драйвер провайдере мы получаем название тестов с xml файла, и в зависимости от названия генерим дату
    @Test(dataProvider = "withITestContext", dataProviderClass = DataProviderWithITestContext.class)
    public void sumOfTwoWithITestContext(int a, int b, int expected) {
        Assert.assertEquals(a + b, expected);
    }

    @Test(dataProvider = "withITestContext", dataProviderClass = DataProviderWithITestContext.class)
    public void diffOfTwoWithITestContext(int a, int b, int expected) {
        Assert.assertEquals(a - b, expected);
    }


}
