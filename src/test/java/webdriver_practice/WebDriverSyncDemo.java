package webdriver_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverSyncDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        //driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://mvnrepository.com/");

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='textfield']")));
        WebElement searchElement = driver.findElement(By.xpath("//input[@class='textfield']"));
        searchElement.sendKeys("Testng");
        driver.quit();
    }
}
