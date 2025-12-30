package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By loginBtnHeader = By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/button[1]");
    By username = By.name("username");
    By password = By.id("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    By errorMsg = By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[1]/div/div[3]/form/div[3]/div/div[2]");
    By reqMsg= By.xpath("//*[@id=\"password-helper-text\"]");
    public void openLoginPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtnHeader)).click();
    }
@Step
    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean isErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).isDisplayed();
    }
    public boolean isrequiredDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(reqMsg)).isDisplayed();
    }
}
