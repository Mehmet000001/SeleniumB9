package selenium.TestNGBasics;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
    @DataProvider(name="names")
    //new Object[4][3]
    public Object[][] getName(){
        return new Object[][]{
                {"David","Hunt","David Hunt"},
                {"Kushal","Puri","Kushal Puri"},
                {"Priyanka","Gopal","Priyanka Gopal"},
                {"Sameer","Parlapati","Sameer Parlapati"}
                };
    }

    @Test(dataProvider = "names")
    public void test1(String firstName,String lastName,String expectedName){
        String fName=firstName;
        String lName=lastName;
        String fullName=fName+" "+lName;
        Assert.assertEquals(fullName,expectedName);
    }

}
