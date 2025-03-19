package com.thetestingacademy.basetest;

import com.thetestingacademy.driver.DriverManagerTL;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class CommonToAllTest {
    // to call the webDriver and down the webDriver
    @BeforeMethod
    protected void setUp() throws MalformedURLException {
        DriverManagerTL.init();
    }

    @AfterMethod
    protected void tearDown(){
        DriverManagerTL.down();
    }
}
