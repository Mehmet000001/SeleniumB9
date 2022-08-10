package selenium.SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitPractice {
    @Test
    public void  validateFluentWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton=driver.findElement(By.tagName("button"));
        startButton.click();
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("After poll the element is not available")
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(Exception.class);
        WebElement hello=fluentWait.until(mydriver->driver.findElement(By.id("finish")));//it print empty string.we should use explicit and wait until this element is visible.
        System.out.println(hello.getText());

    }
    @Test
    public  void validateDynamicControl(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton=driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();
        Wait<WebDriver>fluentWait=new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(1))
                .withMessage("Fluent Wait polling every...")
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(Exception.class);
        WebElement message=fluentWait.until(mydriver -> driver.findElement(By.id("message")));//nosuchelementexception
        System.out.println(message.getText());

    }
}
