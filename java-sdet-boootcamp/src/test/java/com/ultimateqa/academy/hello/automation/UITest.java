package com.ultimateqa.academy.hello.automation;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;
import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class UITest {
    @Test
    public void chromeSession() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://ultimateqa.com/automation");
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Big page with many elements")));
        driver.quit();
    }

    @Test
    public void unitTest() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(4, calculator.add(2,2));
    }

    @Test
    public void accessibilityTest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");

        WebDriver driver = new ChromeDriver(options);
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
}
