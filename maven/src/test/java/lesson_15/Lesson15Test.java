package lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lesson15Test {
    //Написать автотесты для сайта wildberries.ru, в ходе которых на главной странице
    // несколько товаров кладется в корзину, затем осуществляется переход в корзину и
    // происходят проверки на соответствие названия товаров, их количество, цен каждого
    // товара в корзине и общей суммы товаров.
    //При написании автотестов необходимо использовать подходящие паттерны,
    // изученные в данной теме.
    static WebDriver driver;

    @BeforeSuite
    void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.wildberries.ru/");
    }

    @AfterMethod
    void close() {
        driver.quit();
    }

    @Test
    void testBasket() throws InterruptedException {
        try {
            driver.findElement(By.xpath("//a[@class='product-card__add-basket j-add-to-basket btn-main']")).click();
            driver.findElement(By.xpath("//span[text()=\"L\"]")).click();
        }catch (NoSuchElementException exception){
            System.out.println("бузразмерный");
        }
        try {
            driver.findElement(By.xpath("//a[@class='product-card__add-basket j-add-to-basket btn-main']")).click();
            driver.findElement(By.xpath("//span[text()=\"L\"]")).click();
        }catch (NoSuchElementException exception){
            System.out.println("бузразмерный");
        }
        try {
            driver.findElement(By.xpath("//a[@class='product-card__add-basket j-add-to-basket btn-main']")).click();
            driver.findElement(By.xpath("//span[text()=\"L\"]")).click();
        }catch (NoSuchElementException exception){
            System.out.println("бузразмерный");
        }
    }
}

