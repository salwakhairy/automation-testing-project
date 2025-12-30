package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    private By title= By.xpath("/html/body/div[1]/div/div[3]/div/div[1]/div[1]/h1");

    By searchInput = By.xpath("/html/body/div[4]/div[3]/ul/li[1]/div/div/div/div[1]/div/input");
    By searchButton = By.xpath("//*[@id=\"basic-menu\"]/div[3]/ul/li[1]/div/div/div/div[2]");
    private By allResults = By.cssSelector("[id^='highlights-demo-option-0']");
    By allCourses = By.linkText("جميع الدورات");
    By joinUs = By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/button[2]");

    private By linkedin = By.xpath("//*[@id=\"root\"]/div/footer/div[1]/div[5]/div/div[3]/a");
    private By facebook = By.xpath("//*[@id=\"root\"]/div/footer/div[1]/div[5]/div/div[1]/a");
    private By insta = By.xpath("//*[@id=\"root\"]/div/footer/div[1]/div[5]/div/div[4]/a");

    @Step
    public void search(String keyword) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).sendKeys(keyword);
        wait.until(ExpectedConditions.elementToBeClickable(allResults)).click();
        driver.findElement(searchButton).click();
    }
    public String getTitleText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(title)).isDisplayed();
        return driver.findElement(title).getText();
    }
    @Step
    public void openAllCourses() {
        wait.until(ExpectedConditions.elementToBeClickable(allCourses)).click();
    }
@Step
    public void clickJoinUs() {
        wait.until(ExpectedConditions.elementToBeClickable(joinUs)).click();
    }
    @Step
    public void clickLinkedIn() {
        WebElement fb =
                wait.until(ExpectedConditions.presenceOfElementLocated(linkedin));

        //  Scroll element into view (centered)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", fb);

        //  Wait until clickable
        wait.until(ExpectedConditions.elementToBeClickable(fb));

        //  JS Click (avoids interception)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", fb);
    }
@Step
    public void clickfacebook() {
        WebElement fb =
                wait.until(ExpectedConditions.presenceOfElementLocated(facebook));

        //  Scroll element into view (centered)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", fb);

        //  Wait until clickable
        wait.until(ExpectedConditions.elementToBeClickable(fb));

        //  JS Click (avoids interception)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", fb);    }
@Step
    public void clickinsta() {
        WebElement fb =
                wait.until(ExpectedConditions.presenceOfElementLocated(insta));

        //  Scroll element into view (centered)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", fb);

        //  Wait until clickable
        wait.until(ExpectedConditions.elementToBeClickable(fb));

        //  JS Click (avoids interception)
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", fb);
    }

}
