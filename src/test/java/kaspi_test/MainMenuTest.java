package kaspi_test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainMenuTest extends BaseTestClass{
    @Test(description = "Test Scenario 1")
    public void mainMenuTestTest(){
        WebElement mainMenu = driver.findElement(By.xpath("//div[@class='grid__full-24 header__inner']"));
        Assert.assertTrue(mainMenu.isDisplayed());
    }
    @Test(description = "Test Scenario 2")
    public void registerWindowDisplayTest() throws InterruptedException {
        WebElement iconPerson = driver.findElement(By.xpath("//*[@id=\"headerAuth\"]/a"));
        iconPerson.click();
        Thread.sleep(3000);
        WebElement registerButton = driver.findElement(By.xpath("//div[contains(text(),'Зарегистрироваться')]"));
        registerButton.click();
        WebElement phoneNumberInput = driver.findElement(By.id("phoneNumberSendSmsTo"));
        Assert.assertTrue(phoneNumberInput.isDisplayed());
    }
    @Test(description = "Test Scenario 3 ")
    public void selectItemsWithSpecifiedFilterTest() throws InterruptedException {
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
    @Test(description = "Test Scenario 4")
    public void searchingWordInGidTabTest() throws InterruptedException {
        WebElement gidTab = driver.findElement(By.xpath("//a[contains(text(), 'Гид')]"));
        gidTab.click();
        Thread.sleep(3000);
        WebElement inputSearchBox = driver.findElement(By.id("search-block-items_help-input"));
        String searchStr="депозит";
        inputSearchBox.sendKeys(searchStr);
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(),'Искать')]"));
        searchButton.click();
        WebElement inputResultSpan = driver.findElement(By.xpath("//div[@class='search-block-option'][.//span[contains(text(), 'Найдено')]]"));
        Assert.assertTrue(inputResultSpan.getText().contains(searchStr));
    }
    @Test(description = "Test Scenario 5")
    public void wrongDataEnterTest() throws InterruptedException {
        WebElement iconPerson = driver.findElement(By.xpath("//*[@id=\"headerAuth\"]/a"));
        iconPerson.click();
        Thread.sleep(3000);
        WebElement inputField = driver.findElement(By.id("txtLogin"));
        inputField.sendKeys("7076466198");
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys("thisIsWrongPass");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Войти']"));
        loginButton.click();
        WebElement errorDiv = driver.findElement(By.xpath("//div[@class='entrance__inputErrorMessage entrance__inputErrorMessage--active']"));
        Assert.assertTrue(errorDiv.isDisplayed());
    }

    @Test(description = "Test Scenario 6")
    public void correctDataEnterTest() throws InterruptedException {
        WebElement iconPerson = driver.findElement(By.xpath("//*[@id=\"headerAuth\"]/a"));
        iconPerson.click();
        Thread.sleep(3000);
        WebElement inputField = driver.findElement(By.id("txtLogin"));
        inputField.sendKeys("7076466198");
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys("mydreamis98");
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Войти']"));
        loginButton.click();
        Thread.sleep(4000);
        Assert.assertTrue(driver.findElement(By.id("SMSCodeForm")).isDisplayed());
    }
    @Test(description = "Test Scenario 7")
    public void selectOneProductAndAddToCardTest() throws InterruptedException {
        WebElement magazinTabLink = driver.findElement(By.xpath("//a[contains(text(), 'Магазин')]"));
        magazinTabLink.click();
        Thread.sleep(3000);
        WebElement cityAlmatyLink = driver.findElement(By.xpath("//a[contains(text(), 'Алматы')]"));
        cityAlmatyLink.click();
        WebElement inputElement = driver.findElement(By.xpath("//input[@class='search-bar__input']"));
        inputElement.sendKeys("iphone 12");
        WebElement searchButton = driver.findElement(By.xpath("//button[@class='search-bar__submit button']"));
        searchButton.click();
        WebElement oneItemToChoose = driver.findElement(By.xpath("//div[@data-product-id='100658112']"));
        oneItemToChoose.click();
        WebElement chooseSellerButton = driver.findElement(By.xpath("//a[contains(text(), 'Выбрать продавца')]"));
        chooseSellerButton.click();
        Thread.sleep(4000);
    }
    @Test(description = "Test Scenario 8")
    public void changeCityTest() throws InterruptedException {
        WebElement mapsTab = driver.findElement(By.xpath("//a[contains(text(),'Maps')]"));
        mapsTab.click();
        WebElement citySemeyChoice = driver.findElement(By.xpath("//a[contains(text(), 'Семей')]"));
        citySemeyChoice.click();
        WebElement cityIcon = driver.findElement(By.xpath("//*[@id=\"headerRegionSelection\"]/span"));
        Assert.assertEquals(cityIcon.getText(),"Семей");
    }
}
