package com.example.framework.base;

import com.example.framework.constants.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public WebDriver initializeDriver(String browser) {

        WebDriver driver;
        if (browser == null) browser = "chrome";

        switch (DriverType.valueOf(browser.toLowerCase())) {
            case chrome -> {
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                driver = new ChromeDriver();
            }
            case firefox -> {
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver = new FirefoxDriver();
            }
            case remoteChrome -> {
                // https://bonigarcia.dev/webdrivermanager/#browsers-in-docker
                WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker();
                driver = wdm.create();
            }
            default -> throw new IllegalStateException("Invalid browser name: " + browser);
        }
        driver.manage().window().maximize();

        return driver;
    }
}
