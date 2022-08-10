package selenium.test.orangehrm.tests;

import selenium.test.TestBase;
import selenium.test.orangehrm.pages.AdminPage;
import selenium.test.orangehrm.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTest extends TestBase {

@DataProvider(name="searchValue")
public Object[][] searchData(){
    return  new Object[][]{
            {"Admin"},
            {"ESS"}
    };
}

    @Test(dataProvider = "searchValue")
    public void searchByRoleAdmin(String data) {
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();
        loginPage.login("Admin", "admin123");
        adminPage.clickAdminButton();
        adminPage.selectRole(data);
        adminPage.clickSearchButton();
        adminPage.validateUserRoles(data);
        //instantiate
        //validate
        //quit


    }
}
