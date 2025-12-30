package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CoursePage {

    WebDriver driver;
    WebDriverWait wait;

    public CoursePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By courseCards = By.cssSelector(".course-card");
    By subscribeButton = By.xpath("//*[@id=\"coursesbody\"]/div/div[1]/div[3]/div[2]/button");
@Step
    public void openAnyCourse() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(courseCards)).click();
    }
@Step
    public void subscribeToCourse() {
        wait.until(ExpectedConditions.elementToBeClickable(subscribeButton)).click();
    }
@Step
   public WebElement getSingleCourseCard() {
        return driver.findElement(courseCards);    }
}
