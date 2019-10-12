package com.hellofresh.challenge.Tests;

import com.hellofresh.challenge.Domain.BaseTest;
import com.hellofresh.challenge.Pages.SignInPage;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.Date;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TC1_SignInTest extends BaseTest {

    @Test
    @Category(TC1_SignInTest.class)
    public void signInTest() {

        SignInPage signInPage = new SignInPage(getDriver());

        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        signInPage.enterEmailAddressToCreateAnAccount(email);

        signInPage.enterYourPersonalInformation("Firstname","Lastname");

        assertEquals(signInPage.getHeadingTextOnAnyPage(), "MY ACCOUNT");
        assertEquals(signInPage.getUsernameOnMyAccountPage(),  "Firstname Lastname");
        assertTrue(signInPage.getWelcomeMessageOnMyAccountPage().contains("Welcome to your account."));
        assertTrue(signInPage.isLogoutActionButtonDisplayed());
        assertTrue(signInPage.getAnyPageURL().contains("controller=my-account"));
    }
}
