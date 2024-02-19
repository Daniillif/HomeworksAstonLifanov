package lesson_17;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Attachment;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Lesson17Test {
    AndroidDriver driver = null;
    public void initialize() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability("Pixel 7 Pro","");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    @Order(1)
    @Step
    @DisplayName("Test sum")
    @Owner("Daniil Lifanov")
    @Attachment(value = "Вложение", type = "application/json", fileExtension = ".txt")
    void checkCalculateSumTest(){
        initialize();
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Calculator\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"clear\"]")).click();
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.ImageButton[@content-desc=\"3\"]")).click();

        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"plus\"]")).click();
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.ImageButton[@content-desc=\"9\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"equals\"]")).click();
        Assertions.assertEquals("12", driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.calculator:id/result_final\"]")).getText());
    }
    @Test
    @Order(2)
    @Step
    @DisplayName("Test minus")
    @Owner("Daniil Lifanov")
    @Attachment(value = "Вложение", type = "application/json", fileExtension = ".txt")
    void checkCalculateMinusTest(){
        initialize();
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Calculator\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"clear\"]")).click();
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.ImageButton[@content-desc=\"9\"]")).click();

        driver.findElement(By.xpath("\t\n" +
                "//android.widget.ImageButton[@content-desc=\"minus\"]")).click();
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.ImageButton[@content-desc=\"3\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"equals\"]")).click();
        Assertions.assertEquals("6", driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.calculator:id/result_final\"]")).getText());
    }
    @Test
    @Order(3)
    @Step
    @DisplayName("Test multiply")
    @Owner("Daniil Lifanov")
    @Attachment(value = "Вложение", type = "application/json", fileExtension = ".txt")
    void checkCalculateMultiTest(){
        initialize();
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Calculator\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"clear\"]")).click();
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.ImageButton[@content-desc=\"3\"]")).click();

        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"multiply\"]")).click();
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.ImageButton[@content-desc=\"9\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"equals\"]")).click();
        Assertions.assertEquals("27", driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.calculator:id/result_final\"]")).getText());
    }
    @Test
    @Order(4)
    @Step
    @DisplayName("Test divide")
    @Owner("Daniil Lifanov")
    @Attachment(value = "Вложение", type = "application/json", fileExtension = ".txt")
    void checkCalculateDivideTest(){
        initialize();
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Calculator\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"clear\"]")).click();
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.ImageButton[@content-desc=\"9\"]")).click();

        driver.findElement(By.xpath("\t\n" +
                "//android.widget.ImageButton[@content-desc=\"divide\"]")).click();
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.ImageButton[@content-desc=\"3\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"equals\"]")).click();
        Assertions.assertEquals("3", driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.calculator:id/result_final\"]")).getText());
    }
}
