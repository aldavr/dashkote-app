package com.example.framework.pages;

import com.example.framework.base.BasePage;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//h6[contains(text(), 'Recent Orders')]")
    private WebElement recentOrder;

    private By orderIdText = By.xpath("//table[@class='table align-middle mb-0']/tbody/tr[1]/td[1]");

    // private By recentOrder = By.xpath("//h6[contains(text(), 'Recent Orders')]");

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

    public void scrollToRecentOrdersSection() {
        scrollToElement(recentOrder);
    }

    public String getOrderID() {
        return driver.findElement(orderIdText).getText();
    }

    // ************************************************************************************************
    // Private Methods
    // ************************************************************************************************
}
