package com.thetestingacademy.driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

public class DriverManagerTL {

    //private static WebDriver driver;
    //private static WebDriver driver; // Fix
    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverRef) {
        dr.set(driverRef);
    }

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void unload() {
        dr.remove();
    }

    public static void init() throws MalformedURLException {

        if (Objects.isNull(DriverManagerTL.getDriver())) {
            ChromeOptions options = new ChromeOptions();
            options.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true,
                    "videoName", "test1-video.mp4"
            ));
            WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
            setDriver(driver);
        }
    }

    public static void down() {
        if (Objects.nonNull(DriverManagerTL.getDriver())) {
            getDriver().quit();
            unload();
        }
    }
}