package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By aboutSection = By.xpath("//*[contains(text(),'حول الدورة التدريبية:')]");

    public CourseDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
@Step
    public boolean isAboutSectionDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(aboutSection))
                .isDisplayed();
    }
}
