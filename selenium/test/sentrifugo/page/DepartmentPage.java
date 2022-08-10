package selenium.test.sentrifugo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepartmentPage {
    public DepartmentPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@title='Add']")
    WebElement addButton;

    @FindBy(id="deptname")
    WebElement deptName;
    @FindBy(id="deptcode")
    WebElement deptCode;

    @FindBy(id="description")
    WebElement description;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement saveButton;
    @FindBy(className = "ml-alert-1-success")
    WebElement successMessage;


    public  void clickAddButton(){
        addButton.click();
    }
    public  void  sendDepartmentDescription(String deptName,String deptCode,String description){
        this.deptName.sendKeys(deptName);
        this.deptCode.sendKeys(deptCode);
        this.description.sendKeys(description);
        saveButton.click();
    }
    public WebElement getSaveButton(){
        return saveButton;
    }
    public  String getSuccessMessage(){
        return successMessage.getText().trim();
    }
}
