package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    static WebDriver driver = new ChromeDriver();
    String pathMain = "https://www.wildberries.ru/";
    static List<ElementPage> listOfElements = new ArrayList<>();
    static String btnToAdd = "//a[@class='product-card__add-basket j-add-to-basket btn-main']";
    static String lowestPrise = "//ins[@class='price__lower-price wallet-price']";
    static String sizeL = "//span[@class='sizes-list__size']";

    public MainPage() {

    }

    public void goToMainPage() {
        driver.get(pathMain);
    }

    public static void addToBasket_3_Elements() {
        for (int i = 1; i < 4; i++) {
            try {
                Thread.sleep(2000);
                driver.findElement(By.xpath(btnToAdd)).click();
                Thread.sleep(1000);
                String name = driver.findElement(By.xpath("(//span[@class='product-card__name'])[" + i + "]")).getAttribute("textContent").replaceAll("[^A-Za-zА-Яа-я0-9]", "");
                Thread.sleep(1000);
                String prise = driver.findElement(By.xpath("(" + lowestPrise + ")[" + i + "]")).getAttribute("textContent").replaceAll("[^0-9]", "");
                Thread.sleep(1000);
                listOfElements.add(new ElementPage(name, prise));
                Thread.sleep(1500);
                WebElement elementOfSize = driver.findElement(By.xpath(sizeL));
                Actions actions = new Actions(driver);
                actions.moveToElement(elementOfSize).click().build().perform();
            } catch (NoSuchElementException exception) {
                System.out.println("бузразмерный");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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
