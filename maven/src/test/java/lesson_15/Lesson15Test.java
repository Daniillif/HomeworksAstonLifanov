package lesson_15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterMethod
    void close() {
        driver.quit();
    }

    @Test
    public void compareBasketAndMainInfoTest() throws InterruptedException {
        MainPage.goToMainPage();
        MainPage.addToBasket_3_Elements();
        BasketPage.goToBasket();
        List<ElementPage> listOfBasket = BasketPage.getElementsOfBasketTest();
        for (int i = 0; i < listOfBasket.size(); i++) {
            System.out.println("Сравниваем " + MainPage.listOfElements.get(i).name + " и " + listOfBasket.get(i).name);
            System.out.println("Сравниваем " + Math.ceil(Integer.parseInt(MainPage.listOfElements.get(i).prise) * 1.03099) + " и " + Integer.parseInt(listOfBasket.get(i).prise));
            Assertions.assertEquals(MainPage.listOfElements.get(i).name, listOfBasket.get(i).name);
            Assertions.assertEquals(Math.ceil(Integer.parseInt(MainPage.listOfElements.get(i).prise) * 1.03099), Integer.parseInt(listOfBasket.get(i).prise));
        }
    }@Test
    void checkBasketSumTest(){
        double result = MainPage.returnSumOfPrises();
        System.out.println("Общая сумма товаров из списка добавленных с главной страницы" + result);
        System.out.println("Общая сумма товара в корзине " + new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='b-right']")))).getAttribute("textContent"));
        Assertions.assertEquals(Integer.parseInt(new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='b-right']")))).getAttribute("textContent").replaceAll("[^0-9]","")),result);
    }

}

