package selenium.AlertPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JSAlert {
    WebDriver driver;
    SoftAssert softAssert;
    @BeforeMethod
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        softAssert=new SoftAssert();
    }
    @Test
    public  void  validateJSConfirm(){
        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        softAssert.assertEquals(actualText,"I am a JS Confirm","JS Confirm validation");
        alert.accept();//it will click ok button
        WebElement result = driver.findElement(By.id("result"));
        String actualResult = result.getText();
        softAssert.assertEquals(actualResult,"You clicked: Ok");
        jsConfirm.click();
        alert.dismiss();
        String actualCancelResult = result.getText();
        softAssert.assertEquals(actualCancelResult,"You clicked: Cancel");
        softAssert.assertAll();
    }
    @Test
    public  void  validateJSPrompt(){
        //click the JSpromt
        //send TECHTORIAL as an input
        //click okay button
        //validate you entered:TECHTORIAL IN THE RESULT

        WebElement jsPromt=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPromt.click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("TECHTORIAL ");
        alert.accept();

        WebElement result=driver.findElement(By.id("result"));
        String actualResult=result.getText();
        softAssert.assertEquals(actualResult,"You entered: TECHTORIAL");
        softAssert.assertAll();
    }
}
