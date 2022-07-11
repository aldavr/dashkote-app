package com.example.framework.tests;

import com.example.framework.base.BaseTest;
import com.example.framework.pages.HomePage;
import com.example.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelTests extends BaseTest {

    @Test
    public void ParallelTestCase_01() {

        // Arrange
        LoginPage loginPage = new LoginPage(getDriver()).load();

        // Act
        HomePage homePage = loginPage.login();

        // Assert
        Assert.assertEquals(homePage.getTitle(), "Dashkote");

    }

    @Test
    public void ParallelTestCase_02() {

        // Arrange
        LoginPage loginPage = new LoginPage(getDriver()).load();

        // Act
        HomePage homePage = loginPage.login();

        // Assert
        Assert.assertEquals(homePage.getTitle(), "Dashkote");
    }

    @Test
    public void ParallelTestCase_03() {

        // Arrange
        LoginPage loginPage = new LoginPage(getDriver()).load();

        // Act
        HomePage homePage = loginPage.login();

        // Assert
        Assert.assertEquals(homePage.getTitle(), "Dashkote");
    }

    @Test
    public void ParallelTestCase_04() {

        // Arrange
        LoginPage loginPage = new LoginPage(getDriver()).load();

        // Act
        HomePage homePage = loginPage.login();

        // Assert
        Assert.assertEquals(homePage.getTitle(), "Dashkote");
    }

}
