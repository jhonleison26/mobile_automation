package org.jhon.mobile.tests;

import org.jhon.mobile.screens.*;
import org.jhon.mobile.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    public void TestNavigationBottomMenu() {
        HomeScreen homeScreen = new HomeScreen(driver);

        // Navigate to Webview
        homeScreen.goToWebview();
        WebviewScreen webviewScreen = new WebviewScreen(driver);
        Assert.assertTrue(webviewScreen.isWebviewVisible(), "Webview screen is not visible");

        // Navigate to Login
        homeScreen.goToLogin();
        LoginScreen loginScreen = new LoginScreen(driver);
        Assert.assertTrue(loginScreen.isLoginScreenVisible(), "Login screen is not visible");

        // Navigate to Forms
        homeScreen.goToForms();
        FormsScreen formsScreen = new FormsScreen(driver);
        Assert.assertTrue(formsScreen.isFormsScreenVisible(), "Forms screen is not visible");

        // Navigate to Swipe
        homeScreen.goToSwipe();
        SwipeScreen swipeScreen = new SwipeScreen(driver);
        Assert.assertTrue(swipeScreen.isSwipeScreenVisible(), "Swipe screen is not visible");

        // Navigate to Drag
        homeScreen.goToDrag();
        DragScreen dragScreen = new DragScreen(driver);
        Assert.assertTrue(dragScreen.isDragScreenVisible(), "Drag screen is not visible");
    }
    }