package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class MainPage {
    static WebDriver driver = new ChromeDriver();
    static String pathMain = "https://www.wildberries.ru/";
    static List<ElementPage> listOfElements = new ArrayList<>();
    static String btnToAdd = "//a[@class='product-card__add-basket j-add-to-basket btn-main']";
    static String lowestPrise = "//ins[@class='price__lower-price wallet-price']";
    static String sizeL = "//span[@class='sizes-list__size']";

    public MainPage() {
    }

    public static void goToMainPage() {
        driver.get(pathMain);
    }

    public static void addToBasket_3_Elements() {
        for (int i = 1; i < 4; i++) {
            try {
                WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
                webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(btnToAdd)))).click();
                WebElement el1 = webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[@class='product-card__name'])[" + i + "]"))));
                String name = el1.getAttribute("textContent").replaceAll("[^A-Za-zА-Яа-я0-9]", "");
                WebElement el2 = webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(" + lowestPrise + ")[" + i + "]"))));
                String prise = el2.getAttribute("textContent").replaceAll("[^0-9]", "");
                listOfElements.add(new ElementPage(name, prise));
                WebElement elementOfSize = driver.findElement(By.xpath(sizeL));
                Actions actions = new Actions(driver);
                actions.moveToElement(elementOfSize).click().build().perform();
            } catch (NoSuchElementException exception) {
                System.out.println("бузразмерный");
            }
        }
        for (ElementPage listOfElement : listOfElements) {
            System.out.println(listOfElement.name + " " + listOfElement.prise);
        }
    }
    public static double returnSumOfPrises(){
        int result = 0;
        for (ElementPage element : MainPage.listOfElements) {
            result+=Integer.parseInt(element.prise);
        }return Math.ceil(result*1.031);
    }
}
