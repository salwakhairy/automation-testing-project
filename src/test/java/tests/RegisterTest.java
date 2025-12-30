package tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.RegisterPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest extends BaseTest {
    @Epic("EYOUTH Automation Project")
    @Feature("End To End")
    @Story("User subscribes to a course successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void registerWithEmptyUsername() {
        HomePage home = new HomePage(driver, wait);
        RegisterPage register = new RegisterPage(driver, wait);
        home.clickJoinUs();
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"));
        register.registerWithoutUsername();
        Assert.assertTrue(register.isUsernameErrorDisplayed());


    }

}
