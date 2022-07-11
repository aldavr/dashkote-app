package com.example.framework.factory.abstractFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxDriverManagerGridAbstract extends DriverManagerAbstract {
    private final String grid;

    public FirefoxDriverManagerGridAbstract(String grid) {
        this.grid = grid;
    }

    @Override
    protected void startDriver() throws MalformedURLException {
        WebDriverManager.firefoxdriver().cachePath("target\\drivers").setup();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        driver = new RemoteWebDriver(new URL(grid), caps);
        driver.manage().window().maximize();
    }
}
