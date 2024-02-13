package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BasketPage {
    WebDriver driver = MainPage.driver;
    String path = "https://www.wildberries.ru/lk/basket";


    public BasketPage() {
    }

    public void goToBasket() {
        driver.get(path);
    }

    public List<ElementPage> getElementsOfBasket() throws InterruptedException {
        List<ElementPage> elementPageList = new ArrayList<>();
        for (int i = 3; i >= 1; i--) {
            Thread.sleep(2000);
            String name = driver.findElement(By.xpath("(//span[@class='good-info__good-name'])[" + i + "]")).getAttribute("textContent").replaceAll("[^A-Za-zА-Яа-я0-9]", "").strip();
            String prise = driver.findElement(By.xpath("(//div[@class='list-item__price-new'])[" + i + "]")).getAttribute("textContent").replaceAll("[^0-9]", "").strip();
            elementPageList.add(new ElementPage(name, prise));
        }
        for (ElementPage elementPage : elementPageList) {
            System.out.println(elementPage.name + " " + elementPage.prise);
        }
        return elementPageList;
    }
}
