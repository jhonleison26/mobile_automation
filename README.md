# 📱 Mobile Automation Framework

This project is a **mobile test automation framework** built with **Java, Appium, and TestNG**, designed for Android application testing (and ready to scale to iOS if needed).

---

## 🚀 Tech Stack

- **Java 17**
- **Appium Java Client**
- **TestNG**
- **Maven**
- **Page Object Model (POM)**

---

## ⚙️ Prerequisites

1. **Install Appium**
   npm install -g appium

   Verify installation:
   appium -v

2. **Android SDK & Emulator**
    - Set the `ANDROID_HOME` environment variable.
    - Make sure a device/emulator is available:
      adb devices

3. **Maven**
   mvn -v

4. **App under test (AUT)**
    - This project is configured for `android.wdio.native.app.v1.0.8.apk`.

---

## ▶️ Running Tests

### 🔹 Option 1: Run all tests with Maven
```bash
mvn clean test
```

### 🔹 Option 2: Run using TestNG suite
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

---

## 📑 testng.xml

Example configuration included:

<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="Mobile Automation Suite" parallel="false">

    <parameter name="platformName" value="Android"/>
    <parameter name="deviceName" value="emulator-5554"/>
    <parameter name="platformVersion" value="16.0"/>
    <parameter name="automationName" value="UiAutomator2"/>
    <parameter name="appPackage" value="com.wdiodemoapp"/>
    <parameter name="appActivity" value="com.wdiodemoapp.MainActivity"/>

    <test name="Mobile Tests">
        <packages>
            <package name="org.jhon.mobile.tests"/>
        </packages>
    </test>
</suite>

---

## 🧪 Example Test

@Test
public void testSwipeCards() throws InterruptedException {
HomeScreen homeScreen = new HomeScreen(driver);
homeScreen.goToSwipe();

    SwipeScreen swipeScreen = new SwipeScreen(driver);
    Assert.assertTrue(swipeScreen.isSwipeScreenVisible(), "Swipe screen is not visible");

    for (int i = 0; i < 5; i++) {
        swipeScreen.swipeLeft();
        Thread.sleep(500); // Wait for animation
    }

    Assert.assertTrue(swipeScreen.isLastCardVisible(), "Last card is not visible");
    swipeScreen.scrollUntilFoundMe();
    Assert.assertTrue(swipeScreen.isYouFoundMeVisible(), "\"You found me!!!\" not found");
}

---

## 📌 Best Practices Applied

- **Page Object Model (POM):** clear separation between tests and UI logic.
- **TestNG + testng.xml:** environment parameterization and suite organization.
- **Code reuse:** `BaseTest` manages setup/teardown.
- **Touch gestures:** implemented with W3C Actions API (`PointerInput`, `Sequence`).

---

## ✨ Next Improvements

- Add **Allure Reports** for detailed reporting.
- Implement **BeforeSuite/AfterSuite hooks** to start/stop Appium automatically.
- Enable **parallel execution** on multiple devices/emulators.
- Add support for **iOS testing with XCUITest**.

---

## 👨‍💻 Author

Developed by [@jhonleison26](https://github.com/jhonleison26) as part of a mobile automation project with Appium + Java + TestNG.
