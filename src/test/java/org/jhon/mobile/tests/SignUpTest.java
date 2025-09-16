package org.jhon.mobile.tests;

import org.jhon.mobile.screens.HomeScreen;
import org.jhon.mobile.screens.LoginScreen;
import org.jhon.mobile.screens.SignUpScreen;
import org.jhon.mobile.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * Test class for validating the sign-up functionality of the mobile application.
 * It includes tests for successful user registration.
 */
public class SignUpTest extends BaseTest {

    @Test
    public void testSuccessfulSignUp() {
        // Go Home
        HomeScreen homeScreen = getHomeScreen();

        // Navigate to Login
        homeScreen.goToLogin();
        LoginScreen loginScreen = getLoginScreen();
        Assert.assertTrue(loginScreen.isLoginScreenVisible(), "Login screen is not visible");

        // Go SignUp
        loginScreen.goToSignUp();
        SignUpScreen signUpScreen = getSignUpScreen();

        // Generate random email and password
        String randomEmail = "test_" + UUID.randomUUID().toString().substring(0, 5) + "@mail.com";
        String password = "Password123";

        // Perform SignUp
        signUpScreen.doSignup(randomEmail, password);

        // Validate SignUp success
        Assert.assertTrue(signUpScreen.isSignupSuccessful(), "Sign Up was not successful");
    }
}

