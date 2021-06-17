package kaspi_test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainMenuTest extends BaseTestClass{
    @Test(description = "Test Scenario 1")
    public void mainMenuTest(){
        WebElement mainMenu = driver.findElement(By.xpath("//div[@class='grid__full-24 header__inner']"));
        Assert.assertTrue(mainMenu.isDisplayed());
    }
    @Test(description = "Test Scenario 3 ")
    public void selectItemsWithSpecifiedFilter() throws InterruptedException {
        WebElement magazinTabLink = driver.findElement(By.xpath("//a[contains(text(), 'Магазин')]"));
        magazinTabLink.click();
        Thread.sleep(3000);
        WebElement cityAlmatyLink = driver.findElement(By.xpath("//a[contains(text(), 'Алматы')]"));
        cityAlmatyLink.click();
        WebElement obuvTab = driver.findElement(By.xpath("//a[.//span[contains(text(), 'Обувь')]]"));
        obuvTab.click();
        WebElement priceCheckBox = driver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[1]/div[2]/div/div[2]/label[1]"));
        priceCheckBox.click();
        Thread.sleep(3000);
        Assert.assertTrue(priceCheckBox.getAttribute("checked")==null);

    }


}
