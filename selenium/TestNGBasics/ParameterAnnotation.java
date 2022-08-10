package selenium.TestNGBasics;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {
    @Parameters("school")
    @Test(priority = 1,invocationTimeOut = 1000)//invocationTimeOut  it will give time if more takes it will fail.
    public  void printIn(String sc) throws InterruptedException {//if use parameter you put parameter
        Thread.sleep(2000);//this method it will fail bc more than 1000 mill
        System.out.println(sc);
    }
    @Parameters({"city","state"})
    @Test(priority = 2,invocationCount = 4)//invocationCount count your more time
    public  void personalInfo(String city,String state){
        System.out.println();
        System.out.println();
    }
}
