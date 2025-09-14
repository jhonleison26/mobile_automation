package org.jhon.mobile.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeMethod
    public void setUp() {
        this.driver = createDriver();
    }

    public AppiumDriver createDriver() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setApp("C:\\Users\\jhon.olivares\\Downloads\\android.wdio.native.app.v1.0.8.apk")
                .setDeviceName("emulator-5554")
                .setPlatformVersion("16.0");

        try {
            AppiumDriver driver1 = new AppiumDriver(new java.net.URL(" http://127.0.0.1:4723/"), options);
            driver1.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
            return driver1;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}