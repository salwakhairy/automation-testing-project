package tests;

import Base.BaseTest;
import Pages.CourseDetailsPage;
import Pages.CoursePage;
import Pages.HomePage;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CourseTest extends BaseTest {
    private By menu=By.xpath("/html/body/div[1]/div/div[1]/div[1]/button");
    @Epic("EYOUTH Automation Project")
    @Feature("End To End")
    @Story("User subscribes to a course successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void openCourseDetails() {
        HomePage home = new HomePage(driver, wait);
        CoursePage courses = new CoursePage(driver, wait);
        CourseDetailsPage details = new CourseDetailsPage(driver, wait);
        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
        home.openAllCourses();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        courses.openAnyCourse();
        Assert.assertTrue(details.isAboutSectionDisplayed());
    }

}
