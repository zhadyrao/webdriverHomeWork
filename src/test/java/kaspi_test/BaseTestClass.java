package kaspi_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestClass {
    BaseTestClass baseTestClass;
    WebDriver driver;
    @BeforeClass
    public void beforeTest(){
        baseTestClass= new BaseTestClass();
        driver = new ChromeDriver();
        driver.get("https://kaspi.kz/");
        if(driver.findElement(By.xpath("//div[@class='headerRegionConfirm__wrapper']")).isDisplayed()){
            WebElement confirmCityButton= driver.findElement(By.id("headerRegionConfirm__ConfirmButton"));
            confirmCityButton.click();
        }

    }
    @AfterClass
    public void afterTest(){
       driver.quit();
    }
}
