package kaspi_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTestClass {
    BaseTestClass baseTestClass;
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public void beforeTest(){
        baseTestClass= new BaseTestClass();
        driver = new ChromeDriver();
        driver.get("https://kaspi.kz/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(5000, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver,20);
        if(driver.findElement(By.xpath("//div[@class='headerRegionConfirm__wrapper']")).isDisplayed()){
            WebElement confirmCityButton= driver.findElement(By.id("headerRegionConfirm__ConfirmButton"));
            confirmCityButton.click();
        }
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
