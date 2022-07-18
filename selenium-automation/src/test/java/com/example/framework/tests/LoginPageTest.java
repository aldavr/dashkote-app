package com.example.framework.tests;

import com.example.framework.base.BaseTest;
import com.example.framework.pages.HomePage;
import com.example.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test()
    public void login_withValidCredentials_shouldNavigateToHomePage() {

        // Arrange
        LoginPage loginPage = new LoginPage(getDriver()).load();

        // Act
        HomePage homePage = loginPage.login();

        // Assert
        Assert.assertEquals(homePage.getTitle(), "Dashkote");

    }
}
