package com.example.framework.factory.abstractFactory;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public abstract class DriverManagerAbstract {
    protected WebDriver driver;

    protected abstract void startDriver() throws MalformedURLException;

    public void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() throws MalformedURLException {
        if(driver == null){
            startDriver();
        }
        return driver;
    }
}
