package com.hellofresh.challenge.Domain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 50);
    }

    public void enterExistingCustomerCredentials(String existingUserEmail, String existingUserPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
        driver.findElement(By.id("email")).sendKeys(existingUserEmail);
        driver.findElement(By.id("passwd")).sendKeys(existingUserPassword);
        driver.findElement(By.id("SubmitLogin")).click();
    }

    public String getAnyPageURL() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        return driver.getCurrentUrl();
    }

    public String getHeadingTextOnAnyPage() {
        WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1")));
        return heading.getText();
    }

    public String getUsernameOnMyAccountPage() {
        return driver.findElement(By.className("account")).getText();
    }

    public String getWelcomeMessageOnMyAccountPage() {
        return driver.findElement(By.className("info-account")).getText();
    }

    public boolean isLogoutActionButtonDisplayed() {
        return driver.findElement(By.className("logout")).isDisplayed();
    }
}
