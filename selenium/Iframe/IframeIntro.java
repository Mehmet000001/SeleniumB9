package selenium.Iframe;

import selenium.Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeIntro {
    /*
    -goto internet.heroupp.com
    click frames
    click iframe
    send hello tectorical
     */

    @Test
    public  void  validateIframe(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        WebElement frames=driver.findElement(By.xpath("//a[.='Frames']"));
        frames.click();
        WebElement ifremes=driver.findElement(By.linkText("iFrame"));
        ifremes.click();
        driver.switchTo().frame("mce_0_ifr");
        //it will switch to the inner frame with given id
        //This id,index,or webelement should be belongs to iframe
        WebElement textBox=driver.findElement(By.id("tinymce"));
        textBox.clear();
        textBox.sendKeys("Hello Techtorial!");
        //assert that hello Tectorial! enterde
        //clear the text
        //validate empty page.
        String actual=textBox.getText();
        String expected="Hello Techtorial!";
        Assert.assertEquals(actual,expected,"Text Box Validated");
        textBox.clear();
        Assert.assertTrue(textBox.getText().trim().isEmpty());


    }
    @Test
    public  void  nestedFrame(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame(1);//this will switch to middle
        WebElement middleText=driver.findElement(By.id("content"));
        Assert.assertEquals(middleText.getText(),"MIDDLE");
        driver.switchTo().parentFrame();//parent frame goes to the one parent
        driver.switchTo().frame("frame-left");//NOFRAMEEXCEPTION
        WebElement body=driver.findElement(By.tagName("body"));
        Assert.assertEquals(body.getText().trim(),"LEFT");
//        driver.switchTo().parentFrame();
//        driver.switchTo().parentFrame();//main html
        driver.switchTo().defaultContent();//defaultContetnt method will switch back to the main html.
        driver.switchTo().frame("frame-bottom");
        body=driver.findElement(By.tagName("body"));
        Assert.assertEquals(BrowserUtils.getText(body).trim(),"BOTTOM");


    }

}
