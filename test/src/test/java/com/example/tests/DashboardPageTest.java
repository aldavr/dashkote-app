package com.example.tests;

import com.example.base.BaseTest;
import com.example.pages.DashboardPage;
import com.example.pages.LoginPage;
import org.testng.annotations.Test;

public class DashboardPageTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    public DashboardPageTest() {

        // Creating new instance of DashboardPage class.
        dashboardPage = new DashboardPage();

        // Creating new instance of LoginPage class.
        loginPage = new LoginPage();
    }

    @Test
    public void dashboardPage_TestCase01(){
        System.out.println("Running Dashboard Page Test Case 01");

        loginPage.signin();
        dashboardPage.logout();

    }

    @Test
    public void dashboardPage_TestCase02(){
        System.out.println("Running Dashboard Page Test Case 02");

        loginPage.signin();
        dashboardPage.logout();

    }

    @Test
    public void dashboardPage_TestCase03(){
        System.out.println("Running Dashboard Page Test Case 03");

        loginPage.signin();
        dashboardPage.logout();
    }
}
