package api.put;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.File;

public class PutIntro {
    @Test
    public  void updatePetTest(){
        File jsonFile=new File("src/test/resources/Pet.json");
        RestAssured.given().header("Accept","application/json")
                .and().header("Content-Type","application/json")
                .and().body(jsonFile)
                .when().put("https://petstore.swagger.io/v2/pet")
                .then().statusCode(200).contentType("application/json");
    }
}
