package lesson_14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lesson14Test {
    //Продолжим работу над блоком «Онлайн пополнение без комиссии» сайта mts.by.
    //Проверить надписи в незаполненных полях каждого варианта оплаты услуг: услуги связи,
    // домашний интернет, рассрочка, задолженность;
    // Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы, нажать кнопку «Продолжить»
    // и в появившемся окне проверить корректность отображения суммы (в том числе на кнопке),
    // номера телефона, а также надписей в незаполненных
    // полях для ввода реквизитов карты, наличие иконок платёжных систем.
    static WebDriver driver;
    @BeforeAll
    static void setupAll(){
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void setup(){
        driver.findElement(By.id("cookie-agree")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
    @AfterAll
    static void close(){
        driver.quit();
    }
    @Test
    void testChoice(){
        String choiceXpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button";
        List<String> choiceList = new ArrayList<>(Arrays.asList
                ("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p",
                "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p",
                "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p",
                "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p"));
        List<String> text0 = new ArrayList<>(Arrays.asList("Номер телефона", "Сумма","E-mail для отправки чека"));
        List<String> text1 = new ArrayList<>(Arrays.asList("Номер абонента", "Сумма","E-mail для отправки чека"));
        List<String> text2 = new ArrayList<>(Arrays.asList("Номер счета на 44", "Сумма","E-mail для отправки чека"));
        List<String> text3 = new ArrayList<>(Arrays.asList("Номер счета на 2073", "Сумма","E-mail для отправки чека"));
        List<List<String>> arrayLists = new ArrayList<>();
        arrayLists.add(text0);
        arrayLists.add(text1);
        arrayLists.add(text2);
        arrayLists.add(text3);
        List<List<String>> wordList = new ArrayList<>();
        wordList.add(Arrays.asList("connection-phone","connection-sum","connection-email"));
        wordList.add(Arrays.asList("internet-phone","internet-sum","internet-email"));
        wordList.add(Arrays.asList("score-instalment","instalment-sum","instalment-email"));
        wordList.add(Arrays.asList("score-arrears","arrears-sum","arrears-email"));
            for (int i = 0; i < arrayLists.size(); i++) {
                driver.findElement(By.xpath(choiceXpath)).click();
                WebElement webElement = driver.findElement(By.xpath(choiceList.get(i)));
                webElement.click();
                for (int j = 0; j < arrayLists.get(i).size(); j++) {
                    Assertions.assertEquals(driver.findElement(By.id(wordList.get(i).get(j))).getAttribute("placeholder"),arrayLists.get(i).get(j));
                    System.out.println("Ожидаемый "+ driver.findElement(By.id(wordList.get(i).get(j))).getAttribute("placeholder"));
                    System.out.println("передаваемый"+ arrayLists.get(i).get(j));
                }
            }
        }
    }
