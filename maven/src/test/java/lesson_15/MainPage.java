package lesson_15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    static WebDriver driver = new ChromeDriver();
    String pathMain = "https://www.wildberries.ru/";
    static List<ElementPage> listOfElements=  new ArrayList<>();
    static String btnToAdd = "//a[@class='product-card__add-basket j-add-to-basket btn-main']";
    static String lowestPrise = "//ins[@class='price__lower-price wallet-price']";
    static String sizeL = "(//span[@class='sizes-list__size'])[1]";

    public MainPage() {

    }
    public void goToMainPage(){
        driver.get(pathMain);
    }

    public static void addToBasket_3_Elements() {
        for (int i = 1; i < 4; i++) {
            try {
                Thread.sleep(2000);
                driver.findElement(By.xpath(btnToAdd)).click();
                Thread.sleep(1000);
                String name = driver.findElement(By.xpath("(//article[@data-card-index='0']//div[@class='product-card__wrapper']//div[@class='product-card__middle-wrap']//h2[@class='product-card__brand-wrap product-card__brand-wrap--no-wrap']//span[@class='product-card__name'])["+ i + "]")).getAttribute("textContent").replaceAll("[^A-Za-zА-Яа-я0-9]", "");
                Thread.sleep(1000);
                String prise = driver.findElement(By.xpath("("+lowestPrise+ ")["+ i + "]")).getAttribute("textContent").replaceAll("[^0-9]", "");
                Thread.sleep(1000);
                listOfElements.add(new ElementPage(name, prise));
                Thread.sleep(1500);
                driver.findElement(By.xpath(sizeL)).click();
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
}
