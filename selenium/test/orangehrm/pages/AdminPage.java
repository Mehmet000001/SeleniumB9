package selenium.test.orangehrm.pages;

import selenium.Utils.BrowserUtils;
import selenium.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class AdminPage {
    public AdminPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="menu_admin_viewAdminModule")
    WebElement adminButton;
    @FindBy(id="searchSystemUser_userType")
    WebElement userRole;
    @FindBy(id="searchBtn")
    WebElement searchButton;
    @FindBy(xpath = "//table//tbody//tr//td[3]")
    List<WebElement>userRoles;

    public  void  clickAdminButton(){
        adminButton.click();
    }
    //when we try to create reusable methods for our project we create the method under the browser
    public void  selectRole(String visibleText){
        BrowserUtils.selectByVisibleText(userRole,visibleText);

    }
    public  void clickSearchButton(){
        searchButton.click();
    }
    public  void validateUserRoles(String expectedValue){
        for (WebElement userRole:userRoles){
            Assert.assertEquals(BrowserUtils.getText(userRole),expectedValue);
        }
    }

}
