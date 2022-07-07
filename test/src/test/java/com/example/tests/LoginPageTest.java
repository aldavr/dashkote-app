package com.example.tests;

import com.example.base.BaseTest;
import com.example.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {


    @Test
    public void loginPage_TestCase01(){
        System.out.println("Running Login Page Test Case 01");

        LoginPage loginPage = new LoginPage();

        loginPage.signin();
    }

    @Test
    public void loginPage_TestCase02(){
        System.out.println("Running Login Page Test Case 02");
    }

}
