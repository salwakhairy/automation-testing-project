package tests;

import Base.BaseTest;
import Pages.HomePage;
import io.qameta.allure.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FooterLinksTest extends BaseTest {
    @Epic("EYOUTH Automation Project")
    @Feature("End To End")
    @Story("User subscribes to a course successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 0)
    public void testfacbook() {
        HomePage home = new HomePage(driver, wait);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        home.clickfacebook();
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));


    }
    @Epic("EYOUTH Automation Project")
    @Feature("End To End")
    @Story("User subscribes to a course successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void testlinckedin() {
        HomePage home = new HomePage(driver, wait);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        home.clickLinkedIn();
        Assert.assertTrue(driver.getCurrentUrl().contains("linkedin"));
    }
    @Epic("EYOUTH Automation Project")
    @Feature("End To End")
    @Story("User subscribes to a course successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void testinsta() {
        HomePage home = new HomePage(driver, wait);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        home.clickinsta();
        Assert.assertTrue(driver.getCurrentUrl().contains("instagram"));
    }

}
