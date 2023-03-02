package com.ultimateqa.academy.hello.automation;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UITests {

    WebDriver driver;

    @Test
    public void chromeSession() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.navigate().to("https://ultimateqa.com/automation");
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Big page with many elements")));
    }

    @Test
    public void accessibilityTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");

        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");

        List<String> tags = Arrays.asList("wcag21aa");
        AxeBuilder builder = new AxeBuilder();
        builder.withTags(tags);
        Results axeResults = builder.analyze(driver);
        List<Rule> violations = axeResults.getViolations();
        for (Rule i : violations) {
            System.out.println(i);
        }
        Assert.assertEquals(0, violations.size());
    }

    @After
    public void cleanup() {
        driver.quit();
    }
}
