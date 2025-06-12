package com.example.user.e2e;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserE2ETest {
    @Test
    void nonAdminShouldNotDeleteUser() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/login");

        driver.findElement(By.id("username")).sendKeys("user");
        driver.findElement(By.id("password")).sendKeys("userpass");
        driver.findElement(By.id("login-button")).click();

        driver.get("http://localhost:8080/users");
        driver.findElement(By.cssSelector(".delete-button")).click();

        WebElement error = driver.findElement(By.id("error-message"));
        assertEquals("Permission denied", error.getText());

        driver.quit();
    }
}
