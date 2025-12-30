package tests;

import Base.BaseTest;
import Pages.CoursePage;
import Pages.HomePage;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifyCourseCardUITest extends BaseTest {
    private By menu=By.xpath("/html/body/div/div/div[1]/div[1]/button");
    @Epic("EYOUTH Automation Project")
    @Feature("End To End")
    @Story("User subscribes to a course successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void verifyCourseCardUI() {
        HomePage home = new HomePage(driver, wait);
        CoursePage courses = new CoursePage(driver, wait);
        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
        home.openAllCourses();
        WebElement card = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".course-card")));
        WebElement image = card.findElement(By.xpath("//*[@id=\"coursesbody\"]/div/div[1]/div[1]"));
        Assert.assertTrue(image.isDisplayed(), "Course image is not displayed");

        WebElement title = card.findElement(By.xpath("//*[@id=\"coursesbody\"]/div/div[1]/div[2]/strong"));
        Assert.assertTrue(title.isDisplayed(), "Course title is not displayed");

        WebElement instructor =
                card.findElement(By.xpath("//*[@id=\"coursesbody\"]/div/div[1]/div[2]/span/strong"));
        Assert.assertTrue(instructor.isDisplayed(), "Instructor name is not displayed");

        WebElement subscribeBtn =
                card.findElement(By.xpath("//*[@id=\"coursesbody\"]/div/div[1]/div[3]/div[2]/button"));
        Assert.assertTrue(subscribeBtn.isDisplayed(), "Subscribe button is not displayed");

    }
}
