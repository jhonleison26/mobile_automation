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
    public void testSwipeCards() throws InterruptedException {
        // Go Home
        HomeScreen homeScreen = new HomeScreen(driver);

        // Navigate to Swipe
        homeScreen.goToSwipe();
        SwipeScreen swipeScreen = new SwipeScreen(driver);
        Assert.assertTrue(swipeScreen.isSwipeScreenVisible(), "Swipe screen is not visible");

        // Swipe left through all cards
        for (int i = 0; i < 5; i++) {
            swipeScreen.swipeLeft();
            Thread.sleep(500);
        }

        // Validate that the last card is visible
        Assert.assertTrue(swipeScreen.isLastCardVisible(), "Last card is not visible after swiping to the end");

        // Scroll until "You found me!!!" is visible
        boolean found = swipeScreen.scrollUntilFoundMe();
        Assert.assertTrue(found, "\"You found me!!!\" was not found after scrolling");
        Assert.assertTrue(swipeScreen.isYouFoundMeVisible(), "\"You found me!!!\" text is not visible");
    }
}
