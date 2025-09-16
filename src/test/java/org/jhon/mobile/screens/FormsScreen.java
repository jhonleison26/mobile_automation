package org.jhon.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.jhon.mobile.utils.BaseScreen;
import org.openqa.selenium.WebElement;

/**
 * Represents the Forms screen of the mobile application.
 * Provides methods to interact with form components.
 */
public class FormsScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Form components\")")
    WebElement lblTitleForms;

    public FormsScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isFormsScreenVisible() {
        return isTheElementVisible(lblTitleForms, 5);
    }
}
