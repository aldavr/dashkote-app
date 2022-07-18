package com.example.framework.base;

import com.example.framework.constants.DriverType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class DriverManager {

    public WebDriver initializeDriver(String browser) throws MalformedURLException {

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
            case docker -> {

                driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions());

                /*
                // https://bonigarcia.dev/webdrivermanager/#browsers-in-docker
                WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker().browserVersion("100");
                driver = wdm.create();
                 */

            }
            default -> throw new IllegalStateException("Invalid browser name: " + browser);
        }
        driver.manage().window().maximize();

        return driver;
    }

    // ***************************************************************************************
    // Browser Options
    // ***************************************************************************************

    // Chrome options
    private ChromeOptions chromeOptions() {

        ChromeOptions options = new ChromeOptions();

        // Other Chrome options
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--test-type");
        options.addArguments("--disable-extensions");
        options.addArguments("--dns-prefetch-disable");

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");

        options.addArguments("--disable-gpu");
        options.addArguments("–lang= ja");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        return options;
    }

    // Firefox Options
    private FirefoxOptions firefoxOptions() {

        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", false);

        return options;
    }

    // Edge Options
    private EdgeOptions edgeOptions() {

        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.valueOf("normal"));

        return options;
    }

    // Returns host IP
    private void getIPAddress() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        assert address != null;
        String ipAddress = address.getHostAddress();
        System.out.println("Host IP Address : " + ipAddress);
        String hostname = address.getHostName();
        System.out.println("Host Name : " + hostname);
    }


}
