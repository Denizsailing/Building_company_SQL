import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class Login_test1 {

    WebDriver driver;

    @BeforeEach
    void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\seleniumserver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void constructionCompanyLoginTests() throws InterruptedException {
        driver.get("http://127.0.0.1:8000/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class, 'nav-link') and @href='/user/login/']")));
        WebElement loginLink = driver.findElement(By.xpath("//a[contains(@class, 'nav-link') and @href='/user/login/']"));
        loginLink.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_username")));
        WebElement usernameField = driver.findElement(By.id("id_username"));
        usernameField.sendKeys("denizsailing");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_password")));
        WebElement passwordField = driver.findElement(By.id("id_password"));
        passwordField.sendKeys("Karabiga3517");

        WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-danger"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", loginButton);

    }

    @AfterEach
    void tearDown() {
        driver.close();
    }
}
