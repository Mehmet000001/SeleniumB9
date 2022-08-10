package api;

import api.pojo.ItunesPojo;
import api.pojo.PetPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeserializationPojo {
    //https://petstore.swagger.io/v2/pet/100001
    @Test
    public  void  pojoTest1(){
        RestAssured.baseURI="https://petstore.swagger.io";
        RestAssured.basePath="v2/pet/100001";
        Response response=RestAssured.given().accept("application/json")
                .when().get()
                .then().statusCode(200).extract().response();
        PetPojo deserialization=response.as(PetPojo.class);
        int id=deserialization.getId();
        System.out.println("Pet id is:"+id);
        Assert.assertEquals(id,100001);
        String name=deserialization.getName();
    }
    @Test
    public  void  test2(){
        //https://itunes.apple.com/search?term=michael+jackson&limit=1
        RestAssured.baseURI="https://itunes.apple.com";
    Response response   = RestAssured.given().accept("application/json")

                .param("term","michael+jackson")
                .param("limit",1)
                .when().get("search")
                .then().statusCode(200).contentType("application/json").extract().response();
        ItunesPojo parsedResponse=response.as(ItunesPojo.class);
        Assert.assertEquals(parsedResponse.getResultCount(),1);
    }
}
