package api.post;

import api.pojo.PetPojo;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class PostIntro {
    ResponseSpecification responseSpecification;
    RequestSpecification requestSpecification;

    {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "v2/pet";
        requestSpecification = new RequestSpecBuilder().setAccept("application/json")
                .setContentType("application/json").build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200).
                expectContentType("application/json").build();
    }

    @Test
    public void createPetTest() {

        String requestBody = "{\n" +
                "  \"id\": 7751,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"hatiko\"\n" +
                "  },\n" +
                "  \"name\": \"hatiko\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"https://s3.amazon.com\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"sdet doggie\"\n" +
                "}";

        Response postResponse = RestAssured.given().spec(requestSpecification)
                .body(requestBody)
                .when().post()
                .then().spec(responseSpecification).extract().response();

        PetPojo parsePetResponse = postResponse.as(PetPojo.class);

        Assert.assertEquals(parsePetResponse.getId(), 7751);
        Assert.assertEquals(parsePetResponse.getName(), "hatiko");
        Assert.assertEquals(parsePetResponse.getStatus(), "sdet doggie");


        Response getResponse = RestAssured.given().accept("application/json")
                .when().get("7751")
                .then().spec(responseSpecification).extract().response();

        PetPojo parsedGetResponse = getResponse.as(PetPojo.class);

        Assert.assertEquals(parsedGetResponse.getId(), 7751);
        Assert.assertEquals(parsedGetResponse.getName(), "hatiko");
        Assert.assertEquals(parsedGetResponse.getStatus(), "sdet doggie");


    }


    @Test
    public void createPetTest2() {

        File petJsonFile = new File("src/test/resources/Pet.json");
        RestAssured.given().spec(requestSpecification)
                .body(petJsonFile).when().post().then().spec(responseSpecification);


    }

    @Test
    public void createPetTest3() {

        PetPojo pet = new PetPojo();
        pet.setName("Hatiko from code");
        pet.setId(7780);
        pet.setStatus("Pet created from code");

        /**
         * {
         *  "name":"Hatiko from code",
         *  "id": 7780,
         *  "status": "Pet created from code"
         * }
         */

        RestAssured.given().spec(requestSpecification).body(pet)
                .when().post()
                .then().spec(responseSpecification).log().all();


    }
}
