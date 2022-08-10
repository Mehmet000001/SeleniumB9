package selenium.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropPractice {
    @Test
    public void validateBox() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();//will maximize the chrome page.
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement blueBox = driver.findElement(By.className("test1"));
        WebElement orangeBox = driver.findElement(By.className("test2"));
        String actualBlueText = blueBox.getText();
        String expectedBlueText = "Drag the small circle here ...";
        Assert.assertEquals(actualBlueText, expectedBlueText);
        //bc it is hard assertion  when the assertion fails the next line will not be executed
        String actualOrangeText = orangeBox.getText();
        String expectedOrangeText = "... Or here.";
        Assert.assertEquals(actualOrangeText, expectedOrangeText);

    }


    @Test
    public void validateBlueBox() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement blueBox = driver.findElement(By.className("test1"));
        WebElement orangeBox = driver.findElement(By.className("test2"));
        WebElement blueCircle=driver.findElement(By.id("draggable"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(blueCircle,blueBox).perform();
        //this line will take source(blueCircle) and drop on top of the target (bluebox)
        blueBox = driver.findElement(By.className("test1"));//re-instantiate
        String actualBlueText = blueBox.getText();
        String expectedBlueText = "You did great!";
        Assert.assertEquals(actualBlueText, expectedBlueText);
        //bc it is hard assertion  when the assertion fails the next line will not be executed
        orangeBox = driver.findElement(By.className("test2"));//re-instantiate
        String actualOrangeText = orangeBox.getText();
        String expectedOrangeText = "(Drop here)";
        Assert.assertEquals(actualOrangeText, expectedOrangeText);


    }
    @Test
    public  void validateOrangeBox() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
//        Thread.sleep(2000);
//        WebElement acceptCookies=driver.findElement(By.id("onetrust-accept-btn-handler"));
//        acceptCookies.click();

        WebElement blueBox = driver.findElement(By.className("test1"));
        WebElement orangeBox = driver.findElement(By.className("test2"));
        WebElement blueCircle=driver.findElement(By.id("draggable"));
        Actions actions=new Actions(driver);
       actions.clickAndHold(blueCircle).moveToElement(orangeBox).release().perform();///release() unclick
        //this line will take source(blueCircle) and drop on top of the target (bluebox)
        blueBox = driver.findElement(By.className("test1"));//re-instantiate
        String actualBlueText = blueBox.getText();
        String expectedBlueText = "(Drop here)";
        Assert.assertEquals(actualBlueText, expectedBlueText);
        //bc it is hard assertion  when the assertion fails the next line will not be executed
        orangeBox = driver.findElement(By.className("test2"));//re-instantiate
        String actualOrangeText = orangeBox.getText();
        String expectedOrangeText = "You did great!";
        Assert.assertEquals(actualOrangeText, expectedOrangeText);

    }
}