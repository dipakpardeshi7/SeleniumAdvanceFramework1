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

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }
        dr.set(driver);
    }

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void unload() {
        dr.remove();
    }

    public static void init() throws MalformedURLException {

        if (Objects.isNull(DriverManagerTL.getDriver())) {
            // Optional: Add ChromeOptions if needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); // Optional: open maximized

            WebDriver driver = new ChromeDriver(options);
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