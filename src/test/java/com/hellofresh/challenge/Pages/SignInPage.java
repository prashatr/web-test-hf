package com.hellofresh.challenge.Pages;

import com.hellofresh.challenge.Domain.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAddressToCreateAnAccount(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login"))).click();
        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();
    }

    public void enterYourPersonalInformation(String firstName, String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2"))).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
        driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
        driver.findElement(By.id("passwd")).sendKeys("Qwerty");
        Select select = new Select(driver.findElement(By.id("days")));
        select.selectByValue("1");
        select = new Select(driver.findElement(By.id("months")));
        select.selectByValue("1");
        select = new Select(driver.findElement(By.id("years")));
        select.selectByValue("2000");
        driver.findElement(By.id("company")).sendKeys("Company");
        driver.findElement(By.id("address1")).sendKeys("Qwerty, 123");
        driver.findElement(By.id("address2")).sendKeys("zxcvb");
        driver.findElement(By.id("city")).sendKeys("Qwerty");
        select = new Select(driver.findElement(By.id("id_state")));
        select.selectByVisibleText("Colorado");
        driver.findElement(By.id("postcode")).sendKeys("12345");
        driver.findElement(By.id("other")).sendKeys("Qwerty");
        driver.findElement(By.id("phone")).sendKeys("12345123123");
        driver.findElement(By.id("phone_mobile")).sendKeys("12345123123");
        driver.findElement(By.id("alias")).sendKeys("hf");
        driver.findElement(By.id("submitAccount")).click();
    }
}
