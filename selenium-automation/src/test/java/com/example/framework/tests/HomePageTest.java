package com.example.framework.tests;

import com.example.framework.base.BaseTest;
import com.example.framework.pages.HomePage;
import com.example.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyRecentOrders(){

        // 1. Login to Home page
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = loginPage.login();

        // 2. Scroll to Recent Orders section
        homePage.scrollToRecentOrdersSection();

        // 3. Verify Order ID is present
        Assert.assertEquals(homePage.getOrderID(), "#89742");

    }



}
