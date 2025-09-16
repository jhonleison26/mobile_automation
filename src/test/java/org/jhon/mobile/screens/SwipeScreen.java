package org.jhon.mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.jhon.mobile.utils.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import io.appium.java_client.AppiumBy;

import java.time.Duration;
import java.util.Collections;

/**
 * Represents the "Swipe" screen of the mobile app.
 * Provides swipe and scroll gestures, as well as
 * validations for cards and the "You found me!!!" label.
 */
public class SwipeScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Swipe horizontal\")")
    WebElement lblTitleSwipe;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"You found me!!!\")")
    WebElement lblYouFoundMe;

    @AndroidFindBy(accessibility = "card")
    WebElement lastCard;

    public SwipeScreen(AppiumDriver driver) {
        super(driver);
    }

    // Perform a horizontal swipe to the LEFT (to reveal the next card)
    public void swipeLeft() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        int startX = (int) (width * 0.8);
        int endX = (int) (width * 0.2);
        int y = (int) (height * 0.8);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    // Perform a vertical swipe UP gesture
    public void swipeUp() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;


        int startX = (int) (width * 0.5);
        int startY = (int) (height * 0.5);
        int endY   = (int) (height * 0.1);


        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(scroll));
    }

    // Scroll down until the "You found me!!!" label is found or max attempts reached
    public boolean scrollUntilFoundMe() {
        //
        By byYouFoundMe = AppiumBy.androidUIAutomator("new UiSelector().text(\"You found me!!!\")");

        for (int i = 0; i < 5; i++) {
            if (!driver.findElements(byYouFoundMe).isEmpty()) {
                return true; // found
            }
            swipeUp();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public boolean isSwipeScreenVisible() {
        return isTheElementVisible(lblTitleSwipe, 5);
    }

    public boolean isLastCardVisible() {
        return isTheElementVisible(lastCard, 2);
    }

    public boolean isYouFoundMeVisible() {
        return isTheElementVisible(lblYouFoundMe, 0);
    }
}
