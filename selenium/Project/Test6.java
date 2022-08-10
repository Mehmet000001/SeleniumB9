package selenium.Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test6 {
    @Test
    public  void testcase6(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        WebElement maleClick=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div/div/div/label/input[@value='Male']"));
        maleClick.click();
        boolean isFemaleSelected=maleClick.isSelected();
        Assert.assertTrue(isFemaleSelected);
        WebElement FemaleClick=driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div/div/div/label/input[@value='Female']"));
        boolean isFemaleClick=FemaleClick.isSelected();
        Assert.assertFalse(isFemaleClick);
}
}
