package api.post;

import api.Constants;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class Slack {
    @Test
    public  void sendMessageTest(){
        RestAssured.baseURI="https://slack.com";
        RestAssured.basePath="api/chat.postMessage";
        String payload="{\n" +
                "    \"channel\":\"C02ELJAHS67\",\n" +
                "    \"text\":\"Mehmet:Message sent from Java\"\n" +
                "}";
     Response response= RestAssured.given().header("Accept", Constants.APPLICATION_JSON)
                .and().header("Content-Type",Constants.APPLICATION_JSON)
                .and().header("Authorization","Bearer xoxb-2033955659015-2481902332983-laN3n7f4XVEXKrlwgYOHX4Vf")
                .and().body(payload)
                .when().post().then().statusCode(200).extract().response();
        Map<String,Object> parsedResponse=response.as(new TypeRef<Map<String,Object>>() {
     });
        String okKey=String.valueOf(parsedResponse.get("ok"));
        Assert.assertTrue(Boolean.parseBoolean(okKey));
    }
}
