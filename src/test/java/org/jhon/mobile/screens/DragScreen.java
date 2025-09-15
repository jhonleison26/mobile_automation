package org.jhon.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.jhon.mobile.utils.BaseScreen;
import org.openqa.selenium.WebElement;

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