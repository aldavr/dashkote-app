package com.example.framework.factory.abstractFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DockerManagerAbstract extends DriverManagerAbstract{
    @Override
    protected void startDriver() {

        WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker();
        WebDriver driver = wdm.create();
        driver.manage().window().maximize();
    }
}
