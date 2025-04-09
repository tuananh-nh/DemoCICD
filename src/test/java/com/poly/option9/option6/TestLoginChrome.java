package com.poly.option9.option6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLoginChrome {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static Map<String, Object[]> TestResultNG;
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        // set up path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win64\\chromedriver.exe");

        // get path
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login");

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Test Results");
        TestResultNG = new HashMap<>();

        System.out.println("Browser opened and setup completed");
    }

    @Test
    public void testURL() {
        // step1: enter username and password
        WebElement usernameField = driver.findElement(By.id("username"));
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        usernameField.sendKeys("student");

        WebElement passwordField = driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys("Password123");

        // step2: click button Submit
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();
        wait.until(ExpectedConditions.urlContains("logged-in-successfully"));

        // step3: Check login success
        boolean isLoggedIn = driver.getCurrentUrl().contains("logged-in-successfully");

        // test case - step test - test data - expected results - actual results
        TestResultNG.put("1", new Object[] { "Check URL", "Expected URL",
                "Enter username and password, click login", isLoggedIn ? "pass" : "fail" });

        assertTrue(isLoggedIn, "Login failed");
    }

    @Test
    public void testHeading() {
        WebElement headingField = driver.findElement(By.cssSelector("h1.post-title"));

        boolean isCorrectHeading = headingField.getText().equals("Logged In Successfully");

        TestResultNG.put("2", new Object[] { "Check Heading", "Logged In Successfully",
                "Check page heading after login", isCorrectHeading ? "pass" : "fail" });

        assertEquals("Logged In Successfully", headingField.getText(), "Heading incorrect");
    }

    @AfterAll
    public static void tearDown() {
        Set<String> keySet = TestResultNG.keySet();
        int rowNum = 0;

        for (String key : keySet) {
            Row row = sheet.createRow(rowNum++);
            Object[] data = TestResultNG.get(key);
            int cellnum = 0;
            for (Object obj : data) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Boolean) {
                    cell.setCellValue((Boolean) obj);
                }
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream("F:\\Polytechnic\\testing\\Test.xlsx")) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // close browser
        driver.quit();
        System.out.println("Browser closed and test results saved");
    }
}
