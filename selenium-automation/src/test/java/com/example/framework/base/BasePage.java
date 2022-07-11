package com.example.framework.base;

import com.example.framework.utils.ConfigLoader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void load(String endPoint) {
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }

// ************************************************************************************************
// Fluent Wait Methods
// ************************************************************************************************

    // An expectation for checking an element is visible and enabled such that you can click it.
    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // An expectation for checking that an element is present on the DOM of a page and visible.
    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // An expectation for checking that an element is either invisible or not present on the DOM.
    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

    // Waits until page is completely loaded.
    protected void waitUntilPageLoad() {
        wait.until(d -> ((JavascriptExecutor) d).executeScript("return (document.readyState === 'complete' || document.readyState === 'interactive')"));
    }


    public void waitUntillPageCompletedLoading() {
        try {
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return (document.readyState === 'complete' || document.readyState === 'interactive')"));
        } catch (Exception e) {
            /* print(MSG_EXCEPTION, e);*/
        }
    }

    // An expectation for checking that an element, known to be present on the DOM of a page, is visible.
    protected void waitForElementIsVisible(final WebElement elementFindBy) {
        wait.until(ExpectedConditions.visibilityOf(elementFindBy));
    }

    // An expectation for checking if the given text is present in the specified element.
    protected void waitForElementTextIsVisible(final WebElement elementFindBy, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(elementFindBy, text));
    }

    protected void waitForOverlaysToDisappear(By overlay) {
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAY SIZE" + overlays.size());
        if (overlays.size() > 0) {
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
            System.out.println("OVERLAYS INVISIBLE");
        } else {
            System.out.println("OVERLAY NOT FOUND");
        }
    }

    // Clicks on an element, waits for element is visible and enabled such that you can click it.
    protected void Click(WebElement element) {
        try {
            waitForElementToBeClickable(element);
            System.out.println("Clicking the <b>" + element.getText());
            element.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Exception while clicking: " + element +
                    ". See Execution log for more details." + e);
        }
    }

    // Simulates typing into an element, which may set its value.
    protected void InsertText(WebElement element, String text) {
        try {
            waitForElementIsVisible(element);
            scrollToElement(element);
            element.clear();
            element.sendKeys(text);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception while entering text " + text + " into "
                    + element + ". See Execution log for more details." + e);
        }
    }

    // Sets focus to a specific Web Element.
    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Scrolls to top of the page.
    protected void scrollToTop() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");
    }

    // Scrolls to bottom of the page.
    protected void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // Checks if a Web Element is displayed or not.
    protected boolean isDisplayed(WebElement element) {
        return element.getSize() != null;
    }

}
