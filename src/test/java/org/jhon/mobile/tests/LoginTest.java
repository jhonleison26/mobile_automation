package org.jhon.mobile.tests;

import org.jhon.mobile.screens.*;
import org.jhon.mobile.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for validating the login functionality of the mobile application.
 * It includes tests for successful login after user registration.
 */
public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        HomeScreen homeScreen = new HomeScreen(driver);

        // Navigate to Login
        homeScreen.goToLogin();
        LoginScreen loginScreen = new LoginScreen(driver);
        Assert.assertTrue(loginScreen.isLoginScreenVisible(), "Login screen is not visible");

        // Go SignUp and create a new user
        loginScreen.goToSignUp();
        SignUpScreen signUpScreen = new SignUpScreen(driver);
        String email = "user" + System.currentTimeMillis() + "@mail.com";
        String password = "Password123";
        signUpScreen.doSignup(email, password);
        Assert.assertTrue(signUpScreen.isSignupSuccessful(), "SignUp was not successful");
        signUpScreen.confirmSuccess();

        // come back to Log in screen
        signUpScreen.goToLogin();

        // Perform Login with the new user
        loginScreen.doLogin(email, password);

        // Validate Login success
        Assert.assertTrue(loginScreen.isLoginSuccessful(), "Login was not successful");
        Assert.assertEquals(
                loginScreen.getLoginMessage(),
                "You are logged in!",
                "Login message is not as expected"
        );
    }
}
