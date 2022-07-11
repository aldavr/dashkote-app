package com.example.framework.pages;

import com.example.framework.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    // ************************************************************************************************
    // Page Elements
    // Naming conventions: elementButton, elementInput, elementLabel, elementLink, pageTitle
    // ************************************************************************************************
    @FindBy(xpath = "//title")
    private WebElement pageTitle;

    // ************************************************************************************************
    // Default Constructor
    // ************************************************************************************************
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // ************************************************************************************************
    // Public Methods
    // ************************************************************************************************
    public String getTitle() {
        return driver.getTitle();
    }

    // ************************************************************************************************
    // Private Methods
    // ************************************************************************************************
}
