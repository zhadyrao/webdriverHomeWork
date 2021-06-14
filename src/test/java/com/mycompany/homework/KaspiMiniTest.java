package com.mycompany.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KaspiMiniTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://kaspi.kz/");
        Thread.sleep(2000);
        WebElement cityConfirmButton = driver.findElement(By.id("headerRegionConfirm__ConfirmButton"));
        cityConfirmButton.click();
        WebElement shopLink = driver.findElement(By.xpath("//*[@id=\"headerMenu\"]/a[1]"));
        shopLink.click();
        WebElement almatySelectButton = driver.findElement(By.xpath("//*[@id=\"dialogService\"]/div/div[1]/div[1]/div/ul[1]/li[8]/a"));
        almatySelectButton.click();
        WebElement telephonesLink = driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/nav/div/ul/li[5]/a/span"));
        telephonesLink.click();
        WebElement coverForElectronicBook = driver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[3]/div[1]/div/div[2]/div[2]/ul[2]/li[2]/a"));
        coverForElectronicBook.click();
        Thread.sleep(2000);
        WebElement firstItem = driver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[3]/div[2]/div/div[1]/div[2]/div[1]/a"));
        firstItem.click();
        WebElement chooseBuyer = driver.findElement(By.xpath("//*[@id=\"offers-list\"]/div/div/div/table/tbody/tr/td[7]/div/div"));
        chooseBuyer.click();
        WebElement addressInput = driver.findElement(By.xpath("//*[@id=\"DeliveryView\"]/div[2]/div/div[2]/div/div[1]/div[2]/div/div[3]/div/div[2]/input"));
        addressInput.click();
        addressInput.sendKeys("75");
        WebElement homeNumber = driver.findElement(By.xpath("//*[@id=\"DeliveryView\"]/div[2]/div/div[2]/div/div[1]/div[2]/div/div[3]/div/div[3]/input"));
        homeNumber.click();
        homeNumber.sendKeys("37");
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"DeliveryView\"]/div[2]/div/div[2]/div/div[1]/button"));
        continueButton.click();
        driver.quit();

    }
}
