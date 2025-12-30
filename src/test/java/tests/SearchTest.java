package tests;

import Base.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;

import java.time.Duration;

public class SearchTest extends BaseTest {
    private By menu=By.xpath("/html/body/div[1]/div/div[1]/div[1]/button");
    @Epic("EYOUTH Automation Project")
    @Feature("End To End")
    @Story("User subscribes to a course successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void searchWithValidKeyword() {
        HomePage home = new HomePage(driver, wait);
        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
        home.search("كيف تنضم إلى البنك");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        String title = home.getTitleText();

        Assert.assertEquals(title, "كيف تنضم إلى البنك", "Expected page title 'كيف تنضم إلى البنك'");
    }
}

