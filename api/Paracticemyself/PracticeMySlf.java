package api.Paracticemyself;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PracticeMySlf {
    @Test
    public  void  validateCharacterName(){
        RestAssured.baseURI="https://pokeapi.co";
        RestAssured.basePath="api/v2/pokemon";
        Response response=RestAssured.given().accept("application/json")
                .when().get()
                .then().statusCode(200).extract().response();
        Map<String,Object>deserialization=response.as(new TypeRef<Map<String, Object>>() {
        });
        double count=(Double)deserialization.get("count");
        Assert.assertEquals(count,1118);
        List<Map<String,String>>listOfNameResult=(List<Map<String,String>>)deserialization.get("results");
        List<String>justName= new ArrayList<>();
        List<String>pokemonName= Arrays.asList("bulbasaur"," ivysaur"," venusaur", "charmander", "charmeleon"," charizard"," squirtle", "wartortle",
                " blastoise"," caterpie"," metapod", "butterfree", "weedle", "kakuna", "beedrill"," pidgey", "pidgeotto", "pidgeot"," rattata", "raticate");
        for (int i=0;i<listOfNameResult.size();i++){
           Map<String,String> singlePokemonInfo=listOfNameResult.get(i);
           String pokemon=singlePokemonInfo.get("name");
           justName.add(pokemon);
           Assert.assertEquals(justName.get(i).trim(),pokemonName.get(i).trim());

        }
        System.out.println(justName);
    }
}
