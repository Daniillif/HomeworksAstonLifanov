package lesson_14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lesson14Test extends Assert {


    static WebDriver driver;
    String choiceXpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button";
    List<String> choiceList = new ArrayList<>(Arrays.asList
            ("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p",
                    "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p",
                    "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p",
                    "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p"));
    List<String> text0 = new ArrayList<>(Arrays.asList("Номер телефона", "Сумма", "E-mail для отправки чека"));
    List<String> text1 = new ArrayList<>(Arrays.asList("Номер абонента", "Сумма", "E-mail для отправки чека"));
    List<String> text2 = new ArrayList<>(Arrays.asList("Номер счета на 44", "Сумма", "E-mail для отправки чека"));
    List<String> text3 = new ArrayList<>(Arrays.asList("Номер счета на 2073", "Сумма", "E-mail для отправки чека"));

    @BeforeSuite
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        driver.findElement(By.id("cookie-agree")).click();
    }

    @AfterMethod
    void close() {
        driver.quit();
    }

    @Test
    void testChoice() {

        List<List<String>> arrayLists = new ArrayList<>();
        arrayLists.add(text0);
        arrayLists.add(text1);
        arrayLists.add(text2);
        arrayLists.add(text3);
        List<List<String>> wordList = new ArrayList<>();
        wordList.add(Arrays.asList("connection-phone", "connection-sum", "connection-email"));
        wordList.add(Arrays.asList("internet-phone", "internet-sum", "internet-email"));
        wordList.add(Arrays.asList("score-instalment", "instalment-sum", "instalment-email"));
        wordList.add(Arrays.asList("score-arrears", "arrears-sum", "arrears-email"));
        for (int i = 0; i < arrayLists.size(); i++) {
            driver.findElement(By.xpath(choiceXpath)).click();
            WebElement webElement = driver.findElement(By.xpath(choiceList.get(i)));
            webElement.click();
            for (int j = 0; j < arrayLists.get(i).size(); j++) {
                Assertions.assertEquals(driver.findElement(By.id(wordList.get(i).get(j))).getAttribute("placeholder"), arrayLists.get(i).get(j));
                System.out.println("Ожидаемый " + driver.findElement(By.id(wordList.get(i).get(j))).getAttribute("placeholder"));
                System.out.println("передаваемый" + arrayLists.get(i).get(j));
            }
        }
    }

    @DataProvider
    public Object[][] dataProviderMethod() {
        return new Object[][]{{10}, {100}, {350}, {499}};
    }

    @Test(dataProvider = "dataProviderMethod")
    public void testCorrectOfData(Integer locale) {
        //
        // номера телефона, а также надписей в незаполненных
        // полях для ввода реквизитов карты, наличие иконок платёжных систем.
        WebElement phone = driver.findElement(By.className("phone"));
        phone.click();
        phone.sendKeys("297777777");
        String phoneCorrect = driver.findElement(By.cssSelector("#pay-connection > div.input-wrapper.input-wrapper_label-left > label")).getAttribute("textContent").substring(1)+"297777777";
        WebElement conSum = driver.findElement(By.id("connection-sum"));
        conSum.click();
        conSum.sendKeys(String.valueOf(locale));
        System.out.println("телефон введен");
        WebElement email = driver.findElement(By.className("email"));
        email.click();
        email.sendKeys("lifanovdaniil@gmail.com");
        System.out.println("email введен");
        String xpath = "//*[@id=\"pay-connection\"]/button";
        driver.findElement(By.xpath(xpath)).click();
        System.out.println("тест кнопка пройден");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("body > app-root > div > div > app-payment-container > app-header > header > div > div > p.header__payment-amount"))));
        String str = driver.findElement(By.cssSelector("body > app-root > div > div > app-payment-container > app-header > header > div > div > p.header__payment-amount")).getAttribute("textContent");
        //проверка верхней надписи с суммой
        Assertions.assertEquals(Double.valueOf(str.substring(1, str.length() - 5)), Double.valueOf(locale));
        //перезапись в переменную строку с суммой из кнопки
        str = driver.findElement(By.cssSelector("body > app-root > div > div > app-payment-container > section > app-card-page > div > div.card-page__card > button")).getAttribute("textContent");
        String expectedPhone = driver.findElement(By.cssSelector("body > app-root > div > div > app-payment-container > app-header > header > div > div > p.header__payment-info")).getAttribute("textContent");
        //проверка суммы кнопки
        Assertions.assertEquals(Double.valueOf(str.substring(10, str.length() - 5)), Double.valueOf(locale));
        //проверка телефона
        Assertions.assertEquals(phoneCorrect,expectedPhone.substring(28,expectedPhone.length()-1));
        //проверка надписей пустых реквизитов 4шт
        Assertions.assertEquals(driver.findElement(By.cssSelector("body > app-root > div > div > app-payment-container > section > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c53-0 > div:nth-child(1) > app-input > div > div > div.content.ng-tns-c47-1 > label")).getAttribute("textContent"),"Номер карты");
        Assertions.assertEquals(driver.findElement(By.cssSelector("body > app-root > div > div > app-payment-container > section > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c53-0 > div:nth-child(2) > div.expires-input.ng-tns-c53-0.ng-star-inserted > app-input > div > div > div.content.ng-tns-c47-4 > label")).getAttribute("textContent"),"Срок действия");
        Assertions.assertEquals(driver.findElement(By.cssSelector("body > app-root > div > div > app-payment-container > section > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c53-0 > div:nth-child(2) > div.cvc-input.ng-tns-c53-0.ng-star-inserted > app-input > div > div > div.content.ng-tns-c47-5 > label")).getAttribute("textContent"),"CVC");
        Assertions.assertEquals(driver.findElement(By.cssSelector("body > app-root > div > div > app-payment-container > section > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c53-0 > div:nth-child(3) > app-input > div > div > div.content.ng-tns-c47-3 > label")).getAttribute("textContent"),"Имя держателя (как на карте)");
        //иконки
        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[2]")).isDisplayed());
        Assertions.assertTrue( driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[3]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div")).isDisplayed());
    }
}

