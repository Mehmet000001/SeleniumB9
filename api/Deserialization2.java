package api;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Deserialization2 {
    @Test
    public  void  PokemonTest(){
        RestAssured.baseURI="https://pokeapi.co";
        RestAssured.basePath="api/v2/pokemon";
        Response response=RestAssured.given().accept("application/json")
                .when().get()
                .then().statusCode(200).log().all().extract().response();
        //deserialization
        Map<String,Object>deserialization=response.as(new TypeRef<Map<String, Object>>() {
        });
        double count=(Double) deserialization.get("count");
        Assert.assertEquals(count,1118);

       List<Map<String,String>> resultList = (List<Map<String, String>>) deserialization.get("results");
       List<String>urlList=new ArrayList<>();
       for (int i=0;i< resultList.size();i++){
           Map<String,String>resultMap=resultList.get(i);
          String url= resultMap.get("url");
          if (url.equals(null)){
              continue;
          }
          urlList.add(url);
       }
        System.out.println("url list is:"+urlList);
       Assert.assertEquals(urlList.size(),20);

    }

}
