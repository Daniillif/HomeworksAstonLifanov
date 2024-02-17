package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BasketPage {
    static WebDriver driver = MainPage.driver;
    static String path = "https://www.wildberries.ru/lk/basket";


    public BasketPage() {
    }

    public static void goToBasket() {
        driver.get(path);
    }

    public static List<ElementPage> getElementsOfBasketTest() throws InterruptedException {
        List<ElementPage> elementPageList = new ArrayList<>();
        for (int i = 3; i >= 1; i--) {
            WebElement el1 = driver.findElement(By.xpath("(//span[@class='good-info__good-name'])[" + i + "]"));
            String name =el1.getAttribute("textContent").replaceAll("[^A-Za-zА-Яа-я0-9]", "").strip();
            WebElement el2 = driver.findElement(By.xpath("(//div[@class='list-item__price-new'])[" + i + "]"));
            String prise = el2.getAttribute("textContent").replaceAll("[^0-9]", "").strip();
            elementPageList.add(new ElementPage(name, prise));
        }
        for (ElementPage elementPage : elementPageList) {
            System.out.println(elementPage.name + " " + elementPage.prise);
        }
        return elementPageList;
    }
}
