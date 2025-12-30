package tests;

import Base.BaseTest;
import Pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Epic("EYOUTH Automation Project")
    @Feature("End To End")
    @Story("User subscribes to a course successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loginWithInvalidCredentials() {
        LoginPage login = new LoginPage(driver, wait);
        login.openLoginPage();
        login.login("salwa71", "1234567");
        Assert.assertTrue(login.isErrorDisplayed());
    }
    @Epic("EYOUTH Automation Project")
    @Feature("End To End")
    @Story("User subscribes to a course successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void loginWithEmptyFields() {
        LoginPage login = new LoginPage(driver, wait);
        login.openLoginPage();
        login.login("", "");
        Assert.assertTrue(login.isrequiredDisplayed());
    }
}
