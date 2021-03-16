package com.testng.parameterEx;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersExample {

    @Test
    @Parameters(value = {"userName", "password"})
    public void validLogin(String userName, String password) {
        System.out.println(userName + " " + password);
    }

    @Test
    @Parameters(value = {"userName", "password"})
    public void invalidLogin(String userName, String password) {
        System.out.println(userName + " " + password);
    }

    @Test
    @Parameters(value = {"userName", "password"})
    public void loginAndGoToSomePage(String userName, String password) {
        System.out.println(userName + " " + password);
    }

    @Test
    @Parameters(value = {"userName", "password"})
    public void loginAndGoToBuyProduct(String userName, String password) {
        System.out.println(userName + " " + password);
    }
}


