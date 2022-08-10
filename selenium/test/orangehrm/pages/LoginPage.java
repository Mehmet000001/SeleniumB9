package selenium.test.orangehrm.pages;

import selenium.Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="txtUsername")
    WebElement username;
    @FindBy(id="txtPassword")
    WebElement password;
    @FindBy(id="btnLogin")
    WebElement loginButton;

    public  void login(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }
}
