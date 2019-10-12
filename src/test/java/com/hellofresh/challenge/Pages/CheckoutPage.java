package com.hellofresh.challenge.Pages;

import com.hellofresh.challenge.Domain.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickWomenButtonInHeader() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Women"))).click();
    }

    public void clickProductName() {
        driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")).click();
        driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Submit"))).click();
    }

    public void proceedToPaymentPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("processAddress"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-cgv"))).click();
        driver.findElement(By.name("processCarrier")).click();
    }

    public void completeOrderPayment() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bankwire"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_navigation']/button"))).click();
    }

    public String getOrderConfirmationMessageOnLastPage() {
        return driver.findElement(By.xpath("//*[@class='cheque-indent']/strong")).getText();
    }

    public boolean isPaymentPageTheLastStepOfOrdering() {
        return driver.findElement(By.xpath("//li[@id='step_end' and @class='step_current last']")).isDisplayed();
    }
}
