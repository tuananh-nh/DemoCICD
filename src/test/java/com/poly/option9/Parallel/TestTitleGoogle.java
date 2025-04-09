package com.poly.option9.Parallel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestTitleGoogle {
    WebDriver driver;
    String titleToTest = "Google";

    @BeforeMethod
    public void setup() {
        // Set đường dẫn tới ChromeDriver và EdgeDriver
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win64\\chromedriver.exe");
        System.setProperty("webdriver.edge.driver", "F:\\edgedriver_win64\\msedgedriver.exe");
    }

    @Test
    public void testTitleGoogle_Chrome() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        // Chờ tiêu đề trang xuất hiện bằng WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(titleToTest));

        // Kiểm tra tiêu đề
        assertEquals(titleToTest, driver.getTitle());
    }

    @Test
    public void testTitleGoogle_Edge() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        // Chờ tiêu đề trang xuất hiện bằng WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(titleToTest));

        // Kiểm tra tiêu đề
        assertEquals(titleToTest, driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        // Đóng trình duyệt
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Trình duyệt đã đóng");
    }
}