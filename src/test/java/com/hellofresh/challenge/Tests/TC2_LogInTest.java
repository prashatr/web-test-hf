package com.hellofresh.challenge.Tests;

import com.hellofresh.challenge.Domain.BaseTest;
import com.hellofresh.challenge.Pages.LogInPage;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TC2_LogInTest extends BaseTest {

    @Test
    @Category(TC2_LogInTest.class)
    public void logInTest() {

        LogInPage loginInPage = new LogInPage(getDriver());

        String existingUserName = "Joe Black";
        String existingUserEmail = "hf_challenge_123456@hf123456.com";
        String existingUserPassword = "12345678";
        loginInPage.enterExistingCustomerCredentials(existingUserEmail, existingUserPassword);

        assertEquals(loginInPage.getHeadingTextOnAnyPage(), "MY ACCOUNT");
        assertEquals(loginInPage.getUsernameOnMyAccountPage(),  existingUserName);
        assertTrue(loginInPage.getWelcomeMessageOnMyAccountPage().contains("Welcome to your account."));
        assertTrue(loginInPage.isLogoutActionButtonDisplayed());
        assertTrue(loginInPage.getAnyPageURL().contains("controller=my-account"));
    }
}
