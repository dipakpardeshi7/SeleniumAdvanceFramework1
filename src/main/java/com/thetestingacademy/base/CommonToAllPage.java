package com.thetestingacademy.base;

import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.driver.DriverManagerTL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonToAllPage {
    protected WebDriver driver;

    public CommonToAllPage() {
        this.driver = DriverManagerTL.getDriver();
        if (this.driver == null) {
            throw new IllegalStateException("WebDriver is not initialized properly");
        }
    }

    public WebElement presenceOfElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void clickElement(By by) {
        presenceOfElement(by).click();
    }

    public WebElement visibilityOfElement(final By elementLocation) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    protected void enterInput(By by, String key) {
        presenceOfElement(by).sendKeys(key);
    }

    protected WebElement getElement(By key) {
        return presenceOfElement(key);
    }
}


