package com.thetestingacademy.pages.PageObjectModel;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.utils.PropertyReader;
import org.openqa.selenium.By;

public class LoginPage_POM extends CommonToAllPage {
    public LoginPage_POM(){
        super();
    }
    //Page Locators

    By username = By.id("login-username");
    By password = By.id("login-password");
    By signButton = By.id("js-login-btn");

    // Page Actions

    public LoginPage_POM loginToVWOPositive() throws Exception {
        enterInput(username, PropertyReader.readKey("username"));
        enterInput(password, PropertyReader.readKey("password"));
        clickElement(signButton);
        return this;

        //Pass the control to dashboard page
    }
public LoginPage_POM openURL(String url){
    DriverManagerTL.getDriver().get(url);
    return this;
}
    public void loginToVWONegative() throws Exception {
        enterInput(username, PropertyReader.readKey("username"));
        enterInput(password, PropertyReader.readKey("password"));
        clickElement(signButton);
    }

    public DashboardPage_POM afterLogin(){
        return new DashboardPage_POM();
    }

}
