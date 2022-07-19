package com.example.framework.base;


import com.example.framework.utils.CookieUtils;
import io.restassured.http.Cookies;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class BaseTest {

    // Creates unique WebDriver instances to each thread.
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected WebDriver getDriver() {
        return this.driver.get();
    }

    // Getter and Setter for WebDriver.
    private void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    @Parameters({"browser"})
    @BeforeMethod
    public synchronized void startDriver(@Optional String browser) throws MalformedURLException {

        // Initializes new WebDriver
        setDriver(new DriverManager().initializeDriver(browser));

        System.out.println("STARTING NEW THREAD: " + Thread.currentThread().getId() + ", " + "DRIVER = " + getDriver());
    }

    @AfterMethod
    public synchronized void quitDriver(@Optional String browser, ITestResult result) throws IOException, InterruptedException {

        System.out.println("ENDING THREAD: " + Thread.currentThread().getId() + ", " + "DRIVER = " + getDriver());

        if (result.getStatus() == ITestResult.FAILURE) {
            File destFile = new File(System.getProperty("user.dir") + "\\target\\reports\\screenshots\\" +
                    result.getTestClass().getRealClass().getSimpleName() + "_" +
                    result.getMethod().getMethodName() + ".png");

            takeScreenshot(destFile);
        }

        if (null != getDriver()) {
            getDriver().quit();
        }
    }

    public void injectCookiesToBrowser(Cookies cookies) {
        List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        for (Cookie cookie : seleniumCookies) {
            System.out.println(cookie.toString());
            getDriver().manage().addCookie(cookie);
        }
    }

    private void takeScreenshot(File destFile) throws IOException, InterruptedException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, destFile);
    }


}
