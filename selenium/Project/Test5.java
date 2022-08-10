package selenium.Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test5 {
    @Test
    public  void testcase5(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        WebElement femaleClick=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div/div/div/label/input[@value='Female']"));
        femaleClick.click();
        boolean isFemaleSelected=femaleClick.isSelected();
        Assert.assertTrue(isFemaleSelected);
        WebElement maleClick=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div/div/div/label/input[@value='Male']"));
        boolean isMaleClick=maleClick.isSelected();
        Assert.assertFalse(isMaleClick);

    }
}
