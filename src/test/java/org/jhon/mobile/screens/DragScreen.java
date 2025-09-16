package org.jhon.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.jhon.mobile.utils.BaseScreen;
import org.openqa.selenium.WebElement;

/**
 * Represents the Drag screen of the mobile application.
 * Provides methods to interact with drag-and-drop components.
 */
public class DragScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Drag and Drop\")")
    WebElement lblTitleDrag;

    public DragScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isDragScreenVisible() {
        return isTheElementVisible(lblTitleDrag, 5);
    }
}