package com.ultimateqa.academy.first;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumManager {
    private WebDriver driver;

    @Test
    public void edgeTest() {
        // Instantiate edge driver
        driver = new EdgeDriver();
        // open a url
        driver.navigate().to("https://ultimateqa.com/automation");
        // wait for an element to exist on a page
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Big page with many elements")));
    }
    @Test
    public void chromeTest() {
        // start a new browser
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        // open a url
        driver.navigate().to("https://ultimateqa.com/automation");
        // wait for an element to exist on a page
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Big page with many elements")));
    }

    @Test
    public void safariTest() {
        // instantiate a new driver
        driver = new SafariDriver();
        // open a url
        driver.navigate().to("https://ultimateqa.com/automation");
        // wait for an element to exist on a page
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Big page with many elements")));
    }

    @After
    public void tearDown() {
        if(driver != null)
            driver.quit();
    }
}
