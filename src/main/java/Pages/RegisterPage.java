package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    By email = By.name("email");
    By password = By.name("password");
    By confirmPassword = By.id("confirmPassword");
    By registerBtn = By.xpath("//button[contains(text(),'انشاء')]");
    By usernameError = By.xpath("//*[contains(text(),'الاسم مطلوب')]");
@Step
    public void registerWithoutUsername() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(email))
                .sendKeys("test@test.com");
        driver.findElement(password).sendKeys("123456");
        driver.findElement(confirmPassword).sendKeys("123456");
        WebElement createBtn =
                wait.until(ExpectedConditions.elementToBeClickable(registerBtn));

        // 🔹 Scroll to button
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", createBtn);

        // 🔹 JS Click to avoid interception
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", createBtn);

    }
@Step
    public boolean isUsernameErrorDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameError))
                .isDisplayed();
    }
}
