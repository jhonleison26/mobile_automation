package org.jhon.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.jhon.mobile.utils.BaseScreen;

/**
 * Represents the login screen of the mobile application.
 * Provides methods to interact with the login screen elements.
 */
public class LoginScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login / Sign up Form\")")
    WebElement lblTitleLogin;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sign up\")")
    WebElement btnSignUp;

    @AndroidFindBy(accessibility = "input-email")
    WebElement txtEmail;

    @AndroidFindBy(accessibility = "input-password")
    WebElement txtPassword;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(16)")
    WebElement btnLogin;

    @AndroidFindBy(id = "android:id/message")
    WebElement lblSuccessMessage;

    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    public void goToSignUp() {
        click(btnSignUp);
    }

    public boolean isLoginScreenVisible() {
        return isTheElementVisible(lblTitleLogin, 5);
    }

    public void doLogin(String email, String password) {
        sendKeys(txtEmail, email);
        sendKeys(txtPassword, password);
        click(btnLogin);
    }

    public String getLoginMessage() {
        return lblSuccessMessage.getDomAttribute("text");
    }

    public boolean isLoginSuccessful() {
        return isTheElementVisible(lblSuccessMessage, 5);
    }
}
