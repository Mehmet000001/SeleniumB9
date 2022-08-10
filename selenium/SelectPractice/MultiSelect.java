package selenium.SelectPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultiSelect {
    @Test
    public void multipleSelectPractice() {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/suphi/Downloads/Techtorial%20(1).html");
        WebElement multiSelect=driver.findElement(By.className("select"));
        Select select=new Select(multiSelect);
        select.selectByIndex(1);
        select.selectByIndex(2);
        select.selectByIndex(3);

        select.deselectAll();

    }
}