package com.thetestingacademy.vwo.LoginTests;

import com.thetestingacademy.basetest.CommonToAllTest;
import com.thetestingacademy.pages.PageObjectModel.DashboardPage_POM;
import com.thetestingacademy.pages.PageObjectModel.LoginPage_POM;
import static org.assertj.core.api.Assertions.assertThat;

import com.thetestingacademy.utils.PropertyReader;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class LoginTest extends CommonToAllTest {

    @Test
    public void testLoginPositive() throws Exception {
        LoginPage_POM pagePom = new LoginPage_POM();
        pagePom.openURL(PropertyReader.readKey("url"));
        pagePom.loginToVWOPositive();

        DashboardPage_POM dashboardPagePom = pagePom.afterLogin();
        String expected_username = dashboardPagePom.loggedInUserName();

        assertThat(expected_username)
                .isNotNull()
                .isNotBlank()
                .contains(PropertyReader.readKey("expected_username"));
    }

}
