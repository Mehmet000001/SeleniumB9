package selenium.FileUpload;

import selenium.Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadPractice {
    @Test
    public void  validateFileUpload(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\suphi\\OneDrive\\Masaüstü/techtorial.png");//we need to send the location of the file
        WebElement upload=driver.findElement(By.id("file-submit"));
        upload.submit();
        //submit() method : 1- it should be under the from then you can use it.
        WebElement text=driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(BrowserUtils.getText(text),"techtorial.png");

    }
}
