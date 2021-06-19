package kaspi_test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MainMenuTest extends BaseTestClass{

    @Test(description = "check that main menu is displayed")
    public void mainMenuTestTest(){
        WebElement mainMenu = driver.findElement(By.xpath("//div[@class='grid__full-24 header__inner']"));
        Assert.assertTrue(mainMenu.isDisplayed());
    }
    @Test(description = "check that window for registration is shown")
    public void registerWindowDisplayTest() {
        WebElement iconPerson = driver.findElement(By.xpath("//*[@id=\"headerAuth\"]/a"));
        iconPerson.click();
        WebElement registerButton = driver.findElement(By.xpath("//div[contains(text(),'Зарегистрироваться')]"));
        registerButton.click();
        WebElement phoneNumberInput = driver.findElement(By.id("phoneNumberSendSmsTo"));
        Assert.assertTrue(phoneNumberInput.isDisplayed());
    }
    @Test(description = "chek that list of products according to assigned filter are shown ")
    public void selectItemsWithSpecifiedFilterTest() {
        WebElement magazinTabLink = driver.findElement(By.xpath("//a[contains(text(), 'Магазин')]"));
        magazinTabLink.click();
        WebElement cityAlmatyLink = driver.findElement(By.xpath("//a[contains(text(), 'Алматы')]"));
        cityAlmatyLink.click();
        WebElement obuvTab = driver.findElement(By.xpath("//a[.//span[contains(text(), 'Обувь')]]"));
        obuvTab.click();
        WebElement priceCheckBox = driver.findElement(By.xpath("//*[@id=\"page\"]/div[3]/div/div[1]/div[2]/div/div[2]/label[1]"));
        priceCheckBox.click();
        Assert.assertTrue(priceCheckBox.getAttribute("checked")==null);
    }
    @Test(description = "check that corresponding to entered data in Guide tap are displayed")
    public void searchingWordInGidTabTest() {
        WebElement gidTab = driver.findElement(By.xpath("//a[contains(text(), 'Гид')]"));
        gidTab.click();
        wait.until(ExpectedConditions.urlMatches("https://kaspi.kz/guide"));
        WebElement inputSearchBox = driver.findElement(By.id("search-block-items_help-input"));
        String searchStr="депозит";
        inputSearchBox.sendKeys(searchStr);
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(),'Искать')]"));
        searchButton.click();
        WebElement inputResultSpan = driver.findElement(By.xpath("//div[@class='search-block-option'][.//span[contains(text(), 'Найдено')]]"));
        Assert.assertTrue(inputResultSpan.getText().contains(searchStr));
    }
    @Test(description = "check that error message is displayed when not correct data is enetered ")
    public void wrongDataEnterTest()  {
        WebElement iconPerson = driver.findElement(By.xpath("//a[@class='headerAuth__link']"));
        iconPerson.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("txtLogin"))));
        WebElement inputField = driver.findElement(By.id("txtLogin"));
        inputField.sendKeys("7076466198");
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys("thisIsWrongPass");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Войти']"));
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("//div[@class='entrance__inputErrorMessage entrance__inputErrorMessage--active']"))));
        WebElement errorDiv = driver.findElement(By.xpath("//div[@class='entrance__inputErrorMessage entrance__inputErrorMessage--active']"));
        Assert.assertTrue(errorDiv.isDisplayed());
    }

    @Test(description = "check whether window for 4 digit code request is shown, when correct data is entered")
    public void correctDataEnterTest()  {
        WebElement iconPerson = driver.findElement(By.xpath("//a[@class='headerAuth__link']"));
        iconPerson.click();
        WebElement inputField = driver.findElement(By.id("txtLogin"));
        inputField.sendKeys("7076466198");
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys("correctPassword");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Войти']"));
        loginButton.click();
        Assert.assertTrue(driver.findElement(By.id("SMSCodeForm")).isDisplayed());
    }
    @Test(description = "Check whether list of sellers are shown when one product is selected")
    public void selectOneProductAndAddToCardTest() {
        WebElement magazinTabLink = driver.findElement(By.xpath("//a[contains(text(), 'Магазин')]"));
        magazinTabLink.click();
        WebElement cityAlmatyLink = driver.findElement(By.xpath("//a[contains(text(), 'Алматы')]"));
        cityAlmatyLink.click();
        WebElement inputElement = driver.findElement(By.xpath("//input[@class='search-bar__input']"));
        inputElement.sendKeys("iphone 12");
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-bar__submit button']"));
        searchButton.click();
        WebElement oneItemToChoose = driver.findElement(By.xpath("//div[@data-product-id='100658112']"));
        oneItemToChoose.click();
        WebElement chooseSellerButton = driver.findElement(By.xpath("//a[contains(text(), 'Выбрать продавца')]"));
        wait.until(ExpectedConditions.visibilityOf(chooseSellerButton));
        chooseSellerButton.click();

    }
    @Test(description = "test for ability to change the city")
    public void changeCityTest()  {
        WebElement mapsTab = driver.findElement(By.xpath("//a[contains(text(),'Maps')]"));
        mapsTab.click();
        wait.until(ExpectedConditions.urlContains("maps"));
        WebElement citySemeyChoice = driver.findElement(By.xpath("//a[contains(text(), 'Семей')]"));
        citySemeyChoice.click();
        WebElement cityIcon = driver.findElement(By.xpath("//*[@id=\"headerRegionSelection\"]/span"));
        Assert.assertEquals(cityIcon.getText(),"Семей");

    }
}
