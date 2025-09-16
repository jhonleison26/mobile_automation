package org.jhon.mobile.tests;

import org.jhon.mobile.screens.HomeScreen;
import org.jhon.mobile.screens.SwipeScreen;
import org.jhon.mobile.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for validating the swipe functionality of the mobile application.
 * It includes tests for swiping through cards and scrolling to find specific text.
 */
public class SwipeTest extends BaseTest {

    @Test
    public void testSwipeCards() {
        // Go Home
        HomeScreen homeScreen = getHomeScreen();

        // Navigate to Swipe
        homeScreen.goToSwipe();
        SwipeScreen swipeScreen = getSwipeScreen();
        Assert.assertTrue(swipeScreen.isSwipeScreenVisible(), "Swipe screen is not visible");

        // Keep swiping until the last card is visible (only one card on screen) or max attempts reached
        int maxSwipes = 10;
        boolean lastCardVisible = false;

        for (int i = 0; i < maxSwipes; i++) {
            swipeScreen.swipeLeft();
            if (swipeScreen.isLastCardVisibleByCount()) {
                lastCardVisible = true;
                break;
            }
        }
        Assert.assertTrue(lastCardVisible, "Last card is not visible after swiping to the end");

        // Scroll until "You found me!!!" is visible
        boolean found = swipeScreen.scrollUntilFoundMe();
        Assert.assertTrue(found, "\"You found me!!!\" was not found after scrolling");
        Assert.assertTrue(swipeScreen.isYouFoundMeVisible(), "\"You found me!!!\" text is not visible");
    }

}
