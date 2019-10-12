package com.hellofresh.challenge.Domain;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    public WebDriver getDriver() {
        return driver;
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
