package api.Paracticemyself;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DeserializationPojo {
    @Test
    public  void Test(){
        RestAssured.baseURI="https://pokeapi.co";
        RestAssured.basePath="api/v2/pokemon";
        Response response=RestAssured.given().accept("application/json")
                .when().get()
                .then().statusCode(200).extract().response();
        PokemonPojo pokemonResponse=response.as(PokemonPojo.class);
        int count=pokemonResponse.getCount();
        String next=pokemonResponse.getNext();
        String previous=pokemonResponse.getPrevious();

        Assert.assertEquals(count,1118);
        System.out.println(count);
        Assert.assertEquals(next,"https://pokeapi.co/api/v2/pokemon?offset=20&limit=20");
        Assert.assertEquals(previous,null);

        List<String>expectedPokemonNames= Arrays.asList("bulbasaur"," ivysaur"," venusaur", "charmander", "charmeleon"," charizard"," squirtle", "wartortle",
                " blastoise"," caterpie"," metapod", "butterfree", "weedle", "kakuna", "beedrill"," pidgey", "pidgeotto", "pidgeot"," rattata", "raticate");
        List<Map<String,String>>allPokemons=pokemonResponse.getResults();
        for (int i=0;i<allPokemons.size();i++){
            Map<String,String>Pokemons=allPokemons.get(i);
            String nameofPokemon=Pokemons.get("name");
            Assert.assertEquals(nameofPokemon.trim(),expectedPokemonNames.get(i));
        }

    }
}
