package org.jhon.mobile.tests;

import org.jhon.mobile.screens.*;
import org.jhon.mobile.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for validating navigation through the bottom menu of the mobile application.
 * It includes tests for navigating to different screens and verifying their visibility.
 */
public class NavigationTest extends BaseTest {

    @Test
    public void TestNavigationBottomMenu() {
        HomeScreen homeScreen = getHomeScreen();

        // Navigate to Webview
        homeScreen.goToWebview();
        WebviewScreen webviewScreen = getWebviewScreen();
        Assert.assertTrue(webviewScreen.isWebviewVisible(), "Webview screen is not visible");

        // Navigate to Login
        homeScreen.goToLogin();
        LoginScreen loginScreen = getLoginScreen();
        Assert.assertTrue(loginScreen.isLoginScreenVisible(), "Login screen is not visible");

        // Navigate to Forms
        homeScreen.goToForms();
        FormsScreen formsScreen = getFormsScreen();
        Assert.assertTrue(formsScreen.isFormsScreenVisible(), "Forms screen is not visible");

        // Navigate to Swipe
        homeScreen.goToSwipe();
        SwipeScreen swipeScreen = getSwipeScreen();
        Assert.assertTrue(swipeScreen.isSwipeScreenVisible(), "Swipe screen is not visible");

        // Navigate to Drag
        homeScreen.goToDrag();
        DragScreen dragScreen = getDragScreen();
        Assert.assertTrue(dragScreen.isDragScreenVisible(), "Drag screen is not visible");
    }
}