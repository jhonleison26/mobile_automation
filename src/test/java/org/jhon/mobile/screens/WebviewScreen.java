package org.jhon.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.jhon.mobile.utils.BaseScreen;
import org.openqa.selenium.WebElement;

/**
 * Represents the Webview screen of the mobile application.
 * Provides methods to interact with webview components.
 */
public class WebviewScreen extends BaseScreen {

    @AndroidFindBy(className = "android.widget.TextView")
    WebElement btnWebview;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Next-gen browser and mobile automation test framework for Node.js\")")
    WebElement lblTextWebview;

    public WebviewScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isWebviewVisible() {
        return isTheElementVisible(lblTextWebview, 20);
    }
}
