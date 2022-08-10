package selenium.test.sentrifugo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public  HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@title='Departments']")
    WebElement departmentsButton;
    @FindBy(xpath = "//a[@title='Gender']")
    WebElement genderButton;
    public  void clickDepartment(){
        departmentsButton.click();
    }
   public  void clickGenderButton(){
        genderButton.click();
   }
}
