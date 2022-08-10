package selenium.Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test7 {
    @Test
    public  void Test7() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        WebElement maleClick=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div/div/div/div/label/input[@value='Male']"));
        Thread.sleep(2000);
        maleClick.click();
        boolean MaleIsChecked=maleClick.isSelected();
        Assert.assertTrue(MaleIsChecked);
        WebElement FemaleClick=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div/div/div/div/label/input[@value='Female']"));
        boolean FemaleIsNotChecked=FemaleClick.isSelected();
        Assert.assertFalse(FemaleIsNotChecked);
        WebElement AgeGroupClick=driver.findElement(By.xpath("//input[@value='15 - 50']"));
        AgeGroupClick.click();
        WebElement GetValue=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div/div/div/button"));
        String actual=GetValue.getText();
        String expected="Get values";
        Assert.assertEquals(actual,expected);

    }
}
