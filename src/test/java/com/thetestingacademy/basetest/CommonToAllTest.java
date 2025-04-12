package com.thetestingacademy.basetest;

import com.thetestingacademy.driver.DriverManagerTL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.time.Duration;

public class CommonToAllTest {

    @BeforeMethod
    public void setUp() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverManagerTL.setDriver(driver);
    }

    @AfterMethod
    public void tearDown() {
        WebDriver driver = DriverManagerTL.getDriver();
        if (driver != null) {
            driver.quit();
            DriverManagerTL.unload();
        }
    }
    // to call the webDriver and down the webDriver
   // @BeforeMethod
    //protected void setUp() throws MalformedURLException {
      //  DriverManagerTL.init();
    //}

    //@AfterMethod
    //protected void tearDown(){
      //  DriverManagerTL.down();
    //}
}
