package com.poly.option9.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNextGeneration {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Thiết lập đường dẫn tới ChromeDriver
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Mở trang đăng nhập
        driver.get("http://localhost:1509/option1");
        System.out.println("Đã mở trình duyệt và chuyển đến trang đăng nhập");
    }

    @Test
    public void testValidLogin() throws InterruptedException {
        // Bước 1: Nhập tên người dùng hợp lệ
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("nguyenhoangtuananh1592005@gmail.com");
        System.out.println("Đã nhập tên người dùng: nguyenhoangtuananh1592005@gmail.com");
        Thread.sleep(3000); // Chờ 3 giây để bạn có thể theo dõi

        // Bước 3: Nhập mật khẩu hợp lệ
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("tuananh0520");
        System.out.println("Đã nhập mật khẩu: tuananh0520");
        Thread.sleep(3000); // Chờ 3 giây

        // Bước 2: Nhấn nút Tiếp theo
        WebElement nextButton = driver.findElement(By.id("identifierNext"));
        nextButton.click();
        System.out.println("Đã nhấn đăng nhập");
        Thread.sleep(3000); // Chờ 3 giây để trang tải trường mật khẩu

        // Bước 5: Kiểm tra đăng nhập thành côngs
        System.out.println(driver.getCurrentUrl());
        boolean isLoggedIn = driver.getCurrentUrl().contains("http://localhost:1509/option2");
        Assert.assertTrue(isLoggedIn, "Đăng nhập thành công!");

        System.out.println("Đăng nhập thành công! Bạn đã vào hộp thư đến.");
    }

    @AfterMethod
    public void tearDown() {
        // Đóng trình duyệt
        driver.quit(); // giai phong
        System.out.println("Đã đóng trình duyệt.");
    }
}
