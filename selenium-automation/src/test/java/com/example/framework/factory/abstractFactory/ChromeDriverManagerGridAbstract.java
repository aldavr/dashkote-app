package com.example.framework.factory.abstractFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverManagerGridAbstract extends DriverManagerAbstract {
    private final String grid;

    public ChromeDriverManagerGridAbstract(String grid) {
        this.grid = grid;
    }

    @Override
    protected void startDriver() throws MalformedURLException {
        WebDriverManager.chromedriver().cachePath("target\\drivers").setup();
        driver = new RemoteWebDriver(new URL(grid), chromeOptions());
        driver.manage().window().maximize();
    }

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
}
