import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTests {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void hepsiburadaLoginTests() throws InterruptedException {
        driver.get("http://127.0.0.1:8000/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("myAccount")));
        driver.findElement(By.id("myAccount")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtUserName")));
        driver.findElement(By.id("txtUserName")).sendKeys("");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogin")));
        driver.findElement(By.id("btnLogin")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtPassword")));
        driver.findElement(By.id("txtPassword")).sendKeys("");
    }

    @AfterEach
    void tearDown() {
        driver.close();
    }
}
