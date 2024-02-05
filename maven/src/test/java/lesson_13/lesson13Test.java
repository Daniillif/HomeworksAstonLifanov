package lesson_13;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class lesson13Test {
    //Необходимо написать автотесты для сайта mts.by. Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
    //Проверить название указанного блока;
    // Проверить наличие логотипов платёжных систем;
    // Проверить работу ссылки «Подробнее о сервисе»;
    // Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи»,
    // номер для теста 297777777)
    WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        if(driver==null) {
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        driver.findElement(By.id("cookie-agree")).click();
    }
    @AfterEach
    void close(){
        driver.close();
    }
    @Test
    void testName() {
        String xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div";
        if(driver.findElement(By.xpath(xpath)).isDisplayed()) {
            System.out.println("тест testName пройден");
        }else
            System.out.println("тест на поиск названия не пройден");
        }


    @Test
    void testPartners() {
        String xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div";
        if (driver.findElement(By.xpath(xpath)).isDisplayed()){
            System.out.println("тест tesPartners пройден");
        }else
            System.out.println("тест на блок партнеров не пройден");

    }
    @Test
    void testClickUrl() {
        driver.findElement(By.linkText("Подробнее о сервисе")).click();
        System.out.println("тест на клик пройден");
    }
    @Test
    void testBtnContinue() {
        WebElement phone =driver.findElement(By.className("phone"));
        phone.click();
        phone.sendKeys("297777777");
        System.out.println("телефон введен");
        WebElement email = driver.findElement(By.className("email"));
        email.click();
        email.sendKeys("lifanovdaniil@gmail.com");
        System.out.println("email введен");
        String xpath = "//*[@id=\"pay-connection\"]/button";
        driver.findElement(By.xpath(xpath)).click();
        System.out.println("тест кнопка пройден");
    }
}
