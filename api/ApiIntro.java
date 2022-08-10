package api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ApiIntro {
    /*
1.Specify the valid URL for given API
2.Define headers,params if needed
3.Specify the http method
4.Send a request
     */
@Test
    public  void firstApiTest(){
    RestAssured.given().header("Accept","application/json")
            .when().get("https://petstore.swagger.io/v2/pet/1")
            .then().statusCode(200).and().log().all();//validate part
}
@Test
    public void secondApiTest(){
   // https://itunes.apple.com/search?term=michael+jackson
    RestAssured.given().header("Accept","application/json")
            .param("term","michael+jackson")
            .when().get("https://itunes.apple.com/search")
            .then().statusCode(200);
}
@Test
    public  void thirtApiTest(){
    RestAssured.given().header("Accept","application/json")
            .when().get("https://thronesapi.com/api/v2/Characters")
            .then().statusCode(200).and().log().all();
}
@Test
    public void  fourthApiTest(){
    RestAssured.given().header("Accept","application/json")
            .param("term","Opie & Anthony")
            .param("limit","10")
            .when().get("https://itunes.apple.com/search")
            .then().statusCode(200).and().log().all();
}

}
