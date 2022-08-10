package selenium.AlertPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertIntro {
    WebDriver driver;
    @BeforeMethod
    public  void  setup(){
        WebDriverManager.chromedriver().setup();//local variable we have to webdriver int before method
        driver=new ChromeDriver();
        driver.navigate().to("https://sweetalert.js.org/");
        //it will run one before each test annotation.
    }
    @Test
    public  void  htmlPopup() throws InterruptedException {
        //navigate to the sweetAlert page
        //click sweetAlert
        //Validate Sweething went wrong is displayed
        //close the popup


        WebElement sweetPreview=driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",sweetPreview);
        Thread.sleep(1000);
        WebElement errorMessage=driver.findElement(By.xpath("//div[@class='swal-text']"));
        String actualMessage=errorMessage.getText();
        Assert.assertEquals(actualMessage,"Something went wrong!");
        Assert.assertTrue(errorMessage.isDisplayed());
        WebElement okButton=driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();
        driver.quit();

    }
    @Test
    public  void javaScript(){

        WebElement previewButton=driver.findElement(By.xpath("//button[contains(@onclick, 'alert')]"));
        previewButton.click();
        Alert alert=driver.switchTo().alert();
        String actualErrMessage=alert.getText();
        Assert.assertEquals(actualErrMessage,"Oops, something went wrong!");
        alert.accept();//(OK BUTTON)
        driver.quit();

    }
    @AfterMethod
    public  void tearDown(){
        driver.quit();
        //it will be executed after each test annotation we use it to quit the driver.later we will use afterMethod annotation to take a screenshot as well
    }
}
