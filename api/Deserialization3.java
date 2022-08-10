package api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.jsoup.select.Evaluator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Deserialization3 {
    @Test
    public void test1() {
        RestAssured.baseURI = "https://api.got.show";
        RestAssured.basePath = "api/map/episodes";
        Response response = RestAssured.given().accept(Constants.APPLICATION_JSON)
                .when().get()
                .then().statusCode(200).contentType(Constants.APPLICATION_JSON).extract().response();

        JsonPath parsedResponse = response.jsonPath();
        String message = parsedResponse.getString("message");
        Assert.assertEquals(message, "Success");

        List<Map<String, Object>> dataList = parsedResponse.getList("data");
        Map<String, Object> stringObjectMap = dataList.get(0);
        System.out.println(stringObjectMap.get("characters"));
        Map<String, ?> map = parsedResponse.getMap("data[0]");///this one given you first value.
        System.out.println(map.get("characters"));

        List<String> charactersList = parsedResponse.getList("data[0].characters");
        System.out.println(charactersList);
    }

    @Test
    public void test2() {
        RestAssured.baseURI = "https://api.got.show";
        RestAssured.basePath = "api/map/episodes";
        RestAssured.given().accept(Constants.APPLICATION_JSON)
                .when().get()
                .then().statusCode(200).contentType(Constants.APPLICATION_JSON)
                .body("message", Matchers.equalTo("Success"))     ///other validation Matchers
                .and().body("data[0].name", Matchers.is("The Kingsroad"));
    }

    @Test
    public void test3() {
        RestAssured.baseURI = "https://api.got.show";
        RestAssured.basePath = "api/map/episodes";
        Response response = RestAssured.given().accept(Constants.APPLICATION_JSON)
                .when().get()
                .then().statusCode(200).contentType(Constants.APPLICATION_JSON).extract().response();
        JsonPath parsedPayload = response.jsonPath();
        List<Map<String, ?>> dataList = parsedPayload.getList("data");
        for (Map<String, ?> dataMap : dataList) {
            String successor = String.valueOf(dataMap.get("successor"));
            if (successor.equalsIgnoreCase("The Prince of Winterfell")) {
                List<String> charactersList = (List<String>) dataMap.get("characters");
                System.out.println(charactersList);
            }
        }

    }

    @Test
    public void test4() {//other way deserilization
        RestAssured.baseURI = "https://api.got.show";
        RestAssured.basePath = "api/map/episodes";
        RestAssured.given().accept(Constants.APPLICATION_JSON)
                .when().get()
                .then().statusCode(200).contentType(Constants.APPLICATION_JSON)
                .body("data.find{it.successor=='The Prince of Winterfell'}.characters",Matchers.hasItem("Jorah Mormont"));
    }
}