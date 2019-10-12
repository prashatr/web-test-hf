package com.hellofresh.challenge.Tests;

import com.hellofresh.challenge.Domain.BaseTest;
import com.hellofresh.challenge.Pages.CheckoutPage;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TC3_CheckoutTest extends BaseTest {

    @Test
    @Category(TC3_CheckoutTest.class)
    public void checkoutTest() {

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());

        String existingUserEmail = "hf_challenge_123456@hf123456.com";
        String existingUserPassword = "12345678";
        checkoutPage.enterExistingCustomerCredentials(existingUserEmail, existingUserPassword);

        checkoutPage.clickWomenButtonInHeader();
        checkoutPage.clickProductName();
        checkoutPage.proceedToPaymentPage();
        checkoutPage.completeOrderPayment();

        assertEquals("ORDER CONFIRMATION", checkoutPage.getHeadingTextOnAnyPage());
        assertTrue(checkoutPage.isPaymentPageTheLastStepOfOrdering());
        assertTrue(checkoutPage.getOrderConfirmationMessageOnLastPage().contains("Your order on My Store is complete."));
        assertTrue(checkoutPage.getAnyPageURL().contains("controller=order-confirmation"));
    }
}
