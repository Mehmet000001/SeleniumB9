package selenium.test.sentrifugo.data;

import org.testng.annotations.DataProvider;

public class CredData {
    @DataProvider(name="credentials")
    public Object[][] getGred(){
        return new Object[][]{
                {"Mehmet","sentrifugo"},
                {"EM01","test"},
                {"test","test"}

        };
    }
    @DataProvider(name="positiveCred")
    public Object[][] getCred1(){
        return new Object[][]{
                {"EM01","sentrifugo"},
                {"EM02","sentrifugo"}

        };
    }

}
