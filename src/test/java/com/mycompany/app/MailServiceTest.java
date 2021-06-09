package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MailServiceTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.ru/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"mailbox\"]/form[1]/div[1]/div[2]/input")).sendKeys("jaka9898");
        WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"mailbox\"]/form[1]/button[1]"));
        nextButton.click();
        driver.findElement(By.xpath("//*[@id=\"mailbox\"]/form[1]/div[2]/input")).sendKeys("mydreamis98");
        WebElement enterButton = driver.findElement(By.xpath("//*[@id=\"mailbox\"]/form[1]/button[2]"));
        enterButton.click();
        Thread.sleep(2000);
    }
}
