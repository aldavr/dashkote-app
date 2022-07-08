package com.example.framework.tests;

import com.example.framework.base.BaseTest;
import com.example.framework.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginPage_TestCase01(){
        System.out.println("Running Login Page Test Case 01");

        LoginPage loginPage = new LoginPage();

        loginPage.signin();
    }
}
