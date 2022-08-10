package api.step_defs;

import api.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import selenium.Utils.CommonUtils;

public class SlackStepDefs {
    String sendMessageAPIUrl;
    Response response;
    @Given("user has valid send message URL")
    public void user_has_valid_send_message_url() {
       sendMessageAPIUrl =CommonUtils.readProperty("slackApiUrl");
       if (sendMessageAPIUrl.equals(null)){
           Assert.fail();
       }
    }
    @When("user sends a message to {string} channel")
    public void user_sends_a_message_to_channel(String channelName) {
        String channel = CommonUtils.readProperty(channelName);
        String messagePayLoad = "{\"channel\":\""+channel+"\",\n" +
                "    \"text\" : \"Ahmet B : Respond him MR ZACK\"}";
      response=  RestAssured.given().accept(Constants.APPLICATION_JSON)
                .contentType(Constants.APPLICATION_JSON)
                .header("Authorization",CommonUtils.readProperty("slackApiToken"))
                .body(messagePayLoad)
                .when().post(sendMessageAPIUrl);
    }
    @Then("status code should be {int}")
    public void status_code_should_be(Integer statusCode) {
      Integer actualStatusCode=response.statusCode();
      Assert.assertEquals(statusCode,actualStatusCode);

    }
    @Then("ok key is true")
    public void ok_key_is_true() {
        response.then().body("ok", Matchers.is(true));
    }

}
