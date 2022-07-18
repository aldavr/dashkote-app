package com.example.framework.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class DockerChromeVncTest {

    WebDriver driver;

    WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker()
            .enableVnc();

    @BeforeTest
    void setupTest() {
        driver = wdm.create();
    }

    @AfterTest
    void teardown() {
        wdm.quit();
    }

    @Test
    void test() throws Exception {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        Assert.assertEquals(driver.getTitle(), "Selenium WebDriver");

        // Verify URL for remote session
        URL noVncUrl = wdm.getDockerNoVncUrl();
        Assert.assertNotNull(noVncUrl);

        // Pause for manual inspection
        Thread.sleep(Duration.ofSeconds(60).toMillis());
    }
}
