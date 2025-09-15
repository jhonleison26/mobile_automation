package org.jhon.mobile.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.jhon.mobile.utils.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Home\")")
    WebElement btnHome;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Webview\")")
    WebElement btnWebview;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\")")
    WebElement btnLogin;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Swipe\")")
    WebElement btnSwipe;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Drag\")")
    WebElement btnDrag;

    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }

    public void goToHome() {
        click(btnHome);
    }

    public void goToWebview() {
        click(btnWebview);
    }

    public void goToLogin() {
        click(btnLogin);
    }

    public void goToSwipe() {
        click(btnSwipe);
    }

    public void goToDrag() {
        click(btnDrag);
    }
}