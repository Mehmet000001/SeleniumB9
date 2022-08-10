package selenium.HomeWorkLast;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Part1 {
    WebDriver driver;
    @BeforeMethod
    public  void  setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://demo.openemr.io/openemr");
        driver.manage().window().maximize();

    }
    @Test
    public void Case1() throws InterruptedException {
        WebElement userName=driver.findElement(By.xpath("//input[@id='authUser']"));
        WebElement passWord=driver.findElement(By.xpath("//input[@id='clearPass']"));
        userName.sendKeys("admin");
        passWord.sendKeys("pass");
        WebElement language=driver.findElement(By.xpath("//select[@name='languageChoice']"));
        Select select=new Select(language);
        select.selectByValue("1");
        Thread.sleep(1000);
        WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        WebElement patientClient=driver.findElement(By.xpath("//div[contains(text(),'Patient/Client')]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(patientClient).perform();
        WebElement newPatient=driver.findElement(By.xpath("//div[.='New']"));
        newPatient.click();
        Thread.sleep(2000);
        driver.switchTo().frame("pat");
        WebElement titleBox=driver.findElement(By.xpath("//select[@name='title']"));
        Select title=new Select(titleBox);
        title.selectByValue("Mr.");

        WebElement firstName=driver.findElement(By.xpath("//input[@type='entry']"));

        firstName.sendKeys("Mehmet");
        WebElement mName=driver.findElement(By.xpath("//input[@name='mname']"));
        mName.sendKeys("Y");
        WebElement lName=driver.findElement(By.xpath("//input[@name='lname']"));
        lName.sendKeys("DXXXXXXX");
        WebElement sex=driver.findElement(By.xpath("//select[@name='sex']"));
        Select selectSex=new Select(sex);
        selectSex.selectByValue("Male");
        WebElement ReferralSource=driver.findElement(By.xpath("//select[@name='refsource']"));
        Select ReferralSelect=new Select(ReferralSource);
        ReferralSelect.selectByValue("Patient");
        WebElement birtDay=driver.findElement(By.xpath("//input[@name='DOB']"));
        birtDay.sendKeys("2021-08-07");
        WebElement patientNumber=driver.findElement(By.xpath("//input[@name='pubpid']"));
        patientNumber.sendKeys("123569");
        WebElement summit=driver.findElement(By.xpath("//input[@type='submit']"));
        summit.click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        WebElement search=driver.findElement(By.xpath("//input[@id='anySearchBox']"));
        search.sendKeys("Mehmet"+ Keys.ENTER);
        Thread.sleep(2000);
        driver.switchTo().frame("fin");
        WebElement searchId=driver.findElement(By.xpath("//a[contains(text(),'DXXXXXXX, Mehmet Y')]"));
        String actual=searchId.getText();
        String expected="DXXXXXXX, Mehmet Y";
        Assert.assertEquals(actual,expected);
        Thread.sleep(2000);
        WebElement dateB=driver.findElement(By.xpath("//tr[@id=\"pid_33\"]//td[contains(text(),'2021-08-07')]"));
        String actualDate=dateB.getText();
        String expectedDate="2021-08-07";
        Assert.assertEquals(actualDate,expectedDate);
        Thread.sleep(2000);
        WebElement idValidate=driver.findElement(By.xpath("//td[contains(text(),'123569')]"));
        String actualId=idValidate.getText();
        String expectedId="123569";
        Assert.assertEquals(actualId,expectedId);
        searchId.click();
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        driver.switchTo().frame("pat");
        WebElement clickEdit=driver.findElement(By.xpath("//a[@class='btn btn-primary btn-sm' and @href='pnotes_full.php?form_active=1']//span[.='Edit']"));
        clickEdit.click();
        WebElement addClick=driver.findElement(By.xpath("//a[@href='pnotes_full_add.php?docid=0&orderid=0']"));
        addClick.click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.switchTo().frame("modalframe");
        WebElement type=driver.findElement(By.xpath("//select[@name='form_note_type']"));
        Select typeSelect=new Select(type);
        typeSelect.selectByValue("Lab Results");
        WebElement toClick=driver.findElement(By.xpath("//select[@name='assigned_to']"));
        Select toSelect=new Select(toClick);
        toSelect.selectByValue("zhportal");
        WebElement noteClick=driver.findElement(By.xpath("//textarea[@name='note']"));
        noteClick.sendKeys("This is for testing");
        WebElement saveMessage=driver.findElement(By.xpath("//a[@class='btn btn-primary btn-save']"));
        saveMessage.click();












    }
}
