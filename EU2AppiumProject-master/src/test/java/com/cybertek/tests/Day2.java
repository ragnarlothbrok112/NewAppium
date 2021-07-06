package com.cybertek.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Day2 {

    AppiumDriver<MobileElement> driver;

    @Test
    public void SauceLabsTest() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("appiumVersion", "1.17.1");
        desiredCapabilities.setCapability("deviceName","Samsung Galaxy S8 FHD GoogleAPI Emulator");
        desiredCapabilities.setCapability("deviceOrientation", "portrait");
        desiredCapabilities.setCapability("browserName", "");
        desiredCapabilities.setCapability("platformVersion","8.0");
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        //to specfiy app for testing
        //it can be on your computer or somewhere in cloud
        desiredCapabilities.setCapability("app","https://cybertek-appium.s3.amazonaws.com/etsy.apk");
        driver = new AppiumDriver<>(new URL("https://jamaldemir:eeb12eac-37ce-4d1c-a0f1-501e2583b1be@ondemand.us-west-1.saucelabs.com:443/wd/hub"),desiredCapabilities);

        Thread.sleep(1000);

        MobileElement you = driver.findElement(MobileBy.AccessibilityId("You tab, 4 of 5"));
        you.click();
        Thread.sleep(1000);

        MobileElement settings = driver.findElement(By.xpath("//*[@text='Settings']"));
        settings.click();
        Thread.sleep(1000);

        MobileElement checkbox = driver.findElement(By.id("com.etsy.android:id/settings_checkbox"));
        checkbox.click();
        Thread.sleep(1000);

        //verify after click the checkbox it is not selected
        Assert.assertFalse(driver.findElement(By.id("com.etsy.android:id/settings_checkbox")).isSelected());
        Thread.sleep(1000);



        driver.quit();

    }

    @Test
    public void SauceLabsTestWithIOS() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("appiumVersion", "1.17.1");
        desiredCapabilities.setCapability("deviceName","iPhone XS Simulator");
        desiredCapabilities.setCapability("deviceOrientation", "portrait");
        desiredCapabilities.setCapability("platformVersion","13.2");
        desiredCapabilities.setCapability("platformName", "iOS");
        desiredCapabilities.setCapability("browserName", "Safari");
        //to specfiy app for testing
        //it can be on your computer or somewhere in cloud
        driver = new AppiumDriver<>(new URL("https://jamaldemir:eeb12eac-37ce-4d1c-a0f1-501e2583b1be@ondemand.us-west-1.saucelabs.com:443/wd/hub"),desiredCapabilities);

        driver.get("https://www.cybertekschool.com");

        Thread.sleep(2000);

        driver.quit();

    }

    public static String userName = "jamaldemir1";
    public static String accessKey = "acGNvfAzG1UajypsjzyS";

    @Test
    public void BrowserStackTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", "Samsung Galaxy S10e");
        caps.setCapability("os_version", "9.0");
        caps.setCapability("project", "My First Project");
        caps.setCapability("build", "My First Build");
        caps.setCapability("name", "Bstack-[Java] Sample Test");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        driver = new AndroidDriver<MobileElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

        driver.get("https://qa3.vytrack.com");

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);

        Thread.sleep(3000);


        driver.quit();

    }
}
