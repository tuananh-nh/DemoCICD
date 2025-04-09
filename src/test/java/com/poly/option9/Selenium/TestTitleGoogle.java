package com.poly.option9.Selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestTitleGoogle {
    @Autowired
    WebDriver driver;

    String titleToTest = "Google";

    @BeforeMethod
    public void setup() {
        // set up path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win64\\chromedriver.exe");

        // get path
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("open browser");

        // zoom google
        driver.manage().window().maximize();
    }

    @Test
    public void testTitleGoogle() {
        // test
        assertEquals(titleToTest, driver.getTitle());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        // close browner
        System.out.println("close browner");
        driver.quit();
    }
}
