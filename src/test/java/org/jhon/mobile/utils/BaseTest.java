package org.jhon.mobile.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.jhon.mobile.screens.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

/**
 * BaseTest class to set up and tear down the Appium driver for mobile tests.
 */
public class BaseTest {
    protected AppiumDriver driver;

    @BeforeMethod
    public void setUp() {
        this.driver = createDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public HomeScreen getHomeScreen() {
        return new HomeScreen(driver);
    }

    public WebviewScreen getWebviewScreen() {
        return new WebviewScreen(driver);
    }

    public LoginScreen getLoginScreen() {
        return new LoginScreen(driver);
    }

    public FormsScreen getFormsScreen() {
        return new FormsScreen(driver);
    }

    public SwipeScreen getSwipeScreen() {
        return new SwipeScreen(driver);
    }

    public DragScreen getDragScreen() {
        return new DragScreen(driver);
    }

    public SignUpScreen getSignUpScreen() {
        return new SignUpScreen(driver);
    }



    public AppiumDriver createDriver() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp("C:\\Users\\jhon.olivares\\Downloads\\android.wdio.native.app.v1.0.8.apk")
                .setDeviceName("emulator-5554")
                .setPlatformVersion("16.0")
                .setAppPackage("com.wdiodemoapp")
                .setAppActivity("com.wdiodemoapp.MainActivity");

        try {
            AppiumDriver driver1 = new AppiumDriver(new java.net.URL("http://127.0.0.1:4723/"), options);
            driver1.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
            return driver1;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}