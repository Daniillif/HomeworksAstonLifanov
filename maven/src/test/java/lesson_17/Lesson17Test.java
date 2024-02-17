package lesson_17;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.jupiter.api.Assertions;
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
    void checkCalculateTest(){
        initialize();
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Calculator\"]")).click();
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.ImageButton[@content-desc=\"3\"]")).click();

        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"plus\"]")).click();
        driver.findElement(By.xpath("\t\n" +
                "//android.widget.ImageButton[@content-desc=\"9\"]")).click();
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"equals\"]")).click();
        Assertions.assertEquals("12", driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.calculator:id/result_final\"]")).getText());
    }
}
