import kaspi_test.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class MailServiceTest {
    WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.get("https://mail.ru/");
        driver.manage().window().maximize();
    }
    @AfterTest
    public void afterTest(){
        //driver.quit();
    }
    @Test
    public void mailServiceTest() throws InterruptedException {
        String email = "jaka9898@mail.ru";
        String password = "mydreamis98";
        String emailToSend = "oralkhanova.zhadyra@gmail.com";
        String subjectOfEmail = "Email from Selenium WebDriver";
        String bodyOfEmail="Hello, this email was send by the work of Selenium Webdriver";
        WebElement inputEmailField = driver.findElement(By.xpath("//*[@id=\"mailbox\"]/form[1]/div[1]/div[2]/input"));
        inputEmailField.sendKeys(email);
        WebElement enterPasswordButton = driver.findElement(By.xpath("//button[@data-testid='enter-password']"));
        enterPasswordButton.click();
        Thread.sleep(4000);
        WebElement inputPasswordField = driver.findElement(By.xpath("//*[@id=\"mailbox\"]/form[1]/div[2]/input"));
        inputPasswordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"mailbox\"]/form[1]/button[2]"));
        loginButton.click();
        Thread.sleep(5000);
        WebElement logoWithEmail = driver.findElement(By.xpath("//*[@id=\"ph-whiteline\"]/div/div[2]/div[2]/span[2]"));
        Assert.assertTrue(logoWithEmail.getText().contains(email));
        Thread.sleep(5000);
        WebElement ret=driver.findElement(By.xpath("//span[contains(text(),'Написать письмо')]"));
        ret.click();
        Thread.sleep(4000);
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input"));
        WebElement subjectInput = driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input"));
        WebElement mainBodyInput = driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]/div[2]"));
        //List<WebElement> icons = driver.findElements(By.xpath("//div[@class='inputContainer--nsqFu']/input[@class='container--H9L5q size_s_compressed--2c-eV']"));
        emailInput.sendKeys(emailToSend);
        subjectInput.sendKeys(subjectOfEmail);
        mainBodyInput.sendKeys(bodyOfEmail);
        WebElement saveEmail = driver.findElement(By.xpath("/html/body/div[15]/div[2]/div/div[2]/div[1]/span[2]/span/span"));
        saveEmail.click();
        Thread.sleep(4000);
        WebElement closeButton = driver.findElement(By.xpath("//button[@tabindex='700'][@class='container--2lPGK type_base--rkphf color_base--hO-yz']"));
        closeButton.click();
        Thread.sleep(4000);
        WebElement draftsTab = driver.findElement(By.xpath("//div[@class='nav__folder-name__txt'][contains(text(),'Черновики')]"));
        draftsTab.click();
        Thread.sleep(4000);
        List<WebElement> draftMessages = driver.findElements(By.xpath("//span[@class='ll-sj__normal']"));
        WebElement neededDraftMessage=null;
        boolean isPresentMessage = false;
        for(WebElement it : draftMessages){
            if(it.getText().contains(subjectOfEmail)){
                isPresentMessage = true;
                neededDraftMessage = it;
                break;
            }
        }
        Assert.assertTrue(isPresentMessage);
        if (isPresentMessage) {
            neededDraftMessage.click();
        }
        else {
            System.out.println("Message is not placed to the Draft Folder");
        }
        Thread.sleep(5000);
        WebElement sendButton = driver.findElement(By.xpath("//span[@tabindex='570']/span[@class='button2__txt']"));
        sendButton.click();
        Thread.sleep(5000);
        WebElement sentMessageWindow = driver.findElement(By.xpath("//div[@class='layer-sent-page']"));
        Thread.sleep(10000);
        isPresentMessage=false;
        draftMessages = driver.findElements(By.xpath("//span[@class='ll-sj__normal']"));
        for(WebElement it : draftMessages){
            if(it.getText().contains(subjectOfEmail)){
                isPresentMessage = true;
                break;
            }
        }
        Assert.assertFalse(isPresentMessage);
        Thread.sleep(5000);
        WebElement sentMessagesTab = driver.findElement(By.xpath("//div[@class='nav__folder-name__txt'][contains(text(),'Отправленные')]"));
        sentMessagesTab.click();
        Thread.sleep(5000);
        List<WebElement> sentMessages = driver.findElements(By.xpath("//span[@class='ll-sj__normal']"));
        Assert.assertEquals(sentMessages.get(0).getText(),subjectOfEmail);
        Thread.sleep(5000);
        WebElement iconOfAccount = driver.findElement(By.xpath("//div[@class='ph-project ph-project__account svelte-a0l97g'][@data-testid='whiteline-account']"));
        iconOfAccount.click();
        Thread.sleep(5000);
        WebElement logOffButton = driver.findElement(By.xpath("//a[@class='ph-item ph-item__hover-active svelte-ylcw5t']/div[contains(text(),'Выйти')]"));
        logOffButton.click();
    }
}
