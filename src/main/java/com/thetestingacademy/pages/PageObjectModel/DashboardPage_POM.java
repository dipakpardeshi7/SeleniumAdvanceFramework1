package com.thetestingacademy.pages.PageObjectModel;

import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.By;

public class DashboardPage_POM extends CommonToAllPage {
    private final By userNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");

    public DashboardPage_POM() {
        // Constructor (empty or can have initialization logic)
    }

    // Page Actions
    public String loggedInUserName() {
        presenceOfElement(userNameOnDashboard); // Ensure element is present
        return getElement(userNameOnDashboard).getText(); // Return username text
    }
}
