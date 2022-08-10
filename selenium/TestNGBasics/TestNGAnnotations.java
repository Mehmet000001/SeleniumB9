package selenium.TestNGBasics;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {
    @BeforeMethod
    public  void  beforeSuite(){
        System.out.println("Before Suite");
    }
    @BeforeMethod
    public  void  beforeTest(){
        System.out.println("Before Test");
    }
    @BeforeMethod
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @BeforeMethod
    public  void  beforeMethod(){
        System.out.println("Before Method");
    }
    @Test
    public  void  test1(){
        System.out.println("Test 1");
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
    @AfterMethod
    public  void  afterClass(){
        System.out.println("After Class");
    }
    @AfterMethod
    public void  afterTest(){
        System.out.println("After Test ");
    }
    @AfterMethod
    public  void afterSuite(){
        System.out.println("After Suite");
    }

}
