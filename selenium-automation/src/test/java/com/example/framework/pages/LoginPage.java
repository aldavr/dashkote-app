package com.example.framework.pages;

import com.example.framework.base.BasePage;
import com.example.framework.objects.User;
import com.example.framework.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By Input_Textfield = By.id("");
    // ************************************************************************************************
    // Page Elements
    //      Naming conventions: elementButton, elementInput, elementLabel, elementLink, pageTitle
    // Page Factory
    //      https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/FindBy.html
    // ************************************************************************************************
    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pwd")
    private WebElement passwordInput;

    // @FindBys can be used to chain multiple @FindBy like below.
    // This could be used in case you have an element that may have multiple selectors.
    // @FindBys({@FindBy(tagName = "button"), @FindBy(xpath = "//button[@type='submit']")})
    @FindBy(xpath = "//button[@type='button']")
    private WebElement loginButton;


    // ************************************************************************************************
    // Default Constructor
    // ************************************************************************************************
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage load() {
        load("/app/login");
        return this;
    }

    // ************************************************************************************************
    // Public Methods
    // ************************************************************************************************

    /**
     * Default Login
     *
     * @return Home page object
     */
    public HomePage login() {
        driver.get(ConfigLoader.getInstance().getBaseUrl());
        User user = new User(ConfigLoader.getInstance().getUsername(),
                ConfigLoader.getInstance().getPassword());
        enterUsername(user.getUsername());
        enterPassword(user.getPassword());
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return new HomePage(driver);
    }

    /**
     * Login with data object
     *
     * @param user object
     * @return Home page object
     */
    public HomePage login(User user) {
        enterUsername(user.getUsername());
        enterPassword(user.getPassword());
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return new HomePage(driver);
    }

    // ************************************************************************************************
    // Private Methods
    // ************************************************************************************************

    private void enterUsername(String username) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(emailInput));
        e.clear();
        e.sendKeys(username);
    }

    private void enterPassword(String password) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(passwordInput));
        e.clear();
        e.sendKeys(password);
    }

}
