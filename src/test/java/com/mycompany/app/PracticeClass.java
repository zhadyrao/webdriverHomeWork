package com.mycompany.app;

import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PracticeClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            driver.get("https://pagination.js.org/");
            Thread.sleep(2000);
            List<WebElement> elements = driver.findElements(By.xpath("//div[@class='data-container'] /ul/li"));
            List<WebElement> pages = driver.findElements(By.xpath("//div[@class='paginationjs-pages'] /ul/li"));
            String text = elements.get(5).getText();
            System.out.println(text);
            pages.get(2).click();
            wait.until(ExpectedConditions.invisibilityOf(elements.get(5)));
            elements = driver.findElements(By.xpath("//div[@class='data-container' /ul/li]"));
            text = elements.get(5).getText();
            System.out.println(text);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //Thread.sleep(20000);
            driver.quit();
        }

    }
}
