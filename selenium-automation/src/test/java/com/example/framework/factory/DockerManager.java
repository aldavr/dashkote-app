package com.example.framework.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DockerManager implements DriverManager {

    @Override
    public WebDriver createDriver() {

        WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker();

        WebDriver driver = wdm.create();

        driver.manage().window().maximize();
        return driver;
    }
}
