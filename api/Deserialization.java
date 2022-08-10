package api;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class Deserialization {
    @Test
    public void deserializationTest() {
        //https://petstore.swagger.io/v2/pet/100001
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet/100001";
        Response response = RestAssured.given().accept("application/json")
                .when().get()
                .then().statusCode(200).log().all().extract().response();
        Map<String, Object> deserializedResp = response.as(new TypeRef<Map<String, Object>>() {
        });
        String name = (String) deserializedResp.get("name");
        System.out.println("Pet name is:" + name);
        Assert.assertEquals(name, "Annetta");
        Map<String, Object> categoryMap = (Map<String, Object>) deserializedResp.get("category");
        double id = (Double) deserializedResp.get("id");
        System.out.println("Pet category is:" + categoryMap);
        Assert.assertEquals(id, 100001);

    }
}
