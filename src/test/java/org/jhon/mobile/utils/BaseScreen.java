package org.jhon.mobile.utils;

import io.appium.java_client.AppiumDriver;

public class BaseScreen {
    protected AppiumDriver driver;

    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
    }
}
