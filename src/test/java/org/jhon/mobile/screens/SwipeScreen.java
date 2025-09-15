package org.jhon.mobile.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.jhon.mobile.utils.BaseScreen;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Swipe horizontal\")")
    WebElement lblTitleSwipe;

    public SwipeScreen() {
        super(null);
    }

    public boolean isSwipeScreenVisible() {
        return isTheElementVisible(lblTitleSwipe, 5);
    }
}
