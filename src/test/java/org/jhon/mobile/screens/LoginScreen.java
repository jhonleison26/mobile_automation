package org.jhon.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.jhon.mobile.utils.BaseScreen;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login / Sign up Form\")")
    WebElement lblTitleLogin;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up\")")
    WebElement btnSignUp;

    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    public void goToSignUp() {
        click(btnSignUp);
    }

    public boolean isLoginScreenVisible() {
        return isTheElementVisible(lblTitleLogin, 5);
    }
}
