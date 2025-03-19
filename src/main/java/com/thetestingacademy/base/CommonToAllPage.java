package com.thetestingacademy.base;

import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.driver.DriverManagerTL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonToAllPage {

    public CommonToAllPage(){
        System.out.println("If you want to call something before every page object class call, put code here");
    //open file, open db connection write code here
    }


    //private DriverManager DriverManagerTL;

    public void implicitWait() {
        DriverManagerTL.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //common functions
    public void clickElement(By by) {
        DriverManagerTL.getDriver().findElement(by).click();
    }

    public WebElement presenceOfElement(final By elementLocation) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(final By elementLocation) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    protected void enterInput(By by, String key) {
        DriverManagerTL.getDriver().findElement(by).sendKeys(key);
    }

    protected WebElement getElement(By key) {
        return DriverManagerTL.getDriver().findElement(key);
    }
}


