package org.jhon.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.jhon.mobile.utils.BaseScreen;
import org.openqa.selenium.WebElement;

public class SignUpScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(17)")
    WebElement btnSignUp;

    @AndroidFindBy(accessibility = "input-email")
    WebElement txtEmail;

    @AndroidFindBy(accessibility = "input-password")
    WebElement txtPassword;

    @AndroidFindBy(accessibility = "input-repeat-password")
    WebElement txtConfirmPassword;

    @AndroidFindBy(id = "android:id/message")
    WebElement lblSuccessMessage;

    @AndroidFindBy(id = "android:id/button1")
    WebElement btnSuccessOk;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Login\").instance(0)")
    WebElement btnLogin;

    public SignUpScreen(AppiumDriver driver) {
        super(driver);
    }

    public void doSignup(String email, String password) {
        sendKeys(txtEmail, email);
        sendKeys(txtPassword, password);
        sendKeys(txtConfirmPassword, password);
        click(btnSignUp);
    }

    public boolean isSignupSuccessful() {
        return isTheElementVisible(lblSuccessMessage, 5);
    }

    public void confirmSuccess() {
        click(btnSuccessOk);
    }

    public void goToLogin() {
        click(btnLogin);
    }
}
