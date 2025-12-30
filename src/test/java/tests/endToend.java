package tests;

import Base.BaseTest;
import Pages.CoursePage;
import Pages.HomePage;
import Pages.LoginPage;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
public class endToend extends BaseTest {
    private By menu=By.xpath("/html/body/div/div/div[1]/div[1]/button");
    private By card=By.cssSelector("#root > div > div.navbar_mobile_div_navbar__iCHLr > div.d-flex.align-items-center > a > strong > svg");
    @Epic("EYOUTH Automation Project")
    @Feature("End To End")
    @Story("User subscribes to a course successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void endToEndScenario() {
        LoginPage login = new LoginPage(driver, wait);
        HomePage home = new HomePage(driver, wait);
        CoursePage courses = new CoursePage(driver, wait);

        login.openLoginPage();
        login.login("salwa71", "123456789");
        wait.until(ExpectedConditions.visibilityOfElementLocated(card));
        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
        home.openAllCourses();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        courses.subscribeToCourse();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@aria-level=\"2\"]/span")));
        Assert.assertTrue(driver.getCurrentUrl().contains("payment"));
    }

}
