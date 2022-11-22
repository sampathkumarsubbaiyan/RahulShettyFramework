package org.example.stepdefinitions;

import ResponsePayloadPOJO.AddPlaceResponse;
import UtilityFiles.CommonCode.RequestSpec;
import UtilityFiles.ResourcesPath.ApiPath;
import UtilityFiles.SetRequestGoogleApi.RequestBodyForGoogleApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.RequestPayloadPOJO.GoogleApis.AddPlaceRequest;
import org.example.RequestPayloadPOJO.GoogleApis.Location;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GoogleApiStepDefinitions extends RequestSpec {
    ResponseSpecification responseSpecification;
    RequestSpecification requestSpecification;
    JsonPath json;
    Response response;
    String path;
    RequestBodyForGoogleApi requestBodyForGoogleApi=new RequestBodyForGoogleApi();
    @Given("request payload is provided with {string} and {string}")
    public void request_payload_is_provided(String value1 , String value2) throws IOException {
        requestSpecification = given().spec(requestSpec()).body(requestBodyForGoogleApi.Serialization(value1,value2));
        responseSpecification=new ResponseSpecBuilder().expectStatusCode(200).build();
    }
    @Given("user calls {string} place api with {string} method")
    public void user_calls_add_place_api_with_post_method(String apiName,String httpMethod) throws IOException {
           ApiPath apiPath = ApiPath.valueOf(apiName);
           path=apiPath.getPath();
        System.out.println("ENUM"+path);
        if(httpMethod.equals("POST"))
        {
           response = requestSpecification.
                when().post(path).then().spec(responseSpecification).extract().response();
        System.out.println("RESPONSE IS"+response.asString());}

        else if(httpMethod.equals("GET"))
        {
            System.out.println("BUTTERFLY RUNING"+json.get("place_id"));
            response = requestSpecification.queryParam("place_id",json.get("place_id")).
                    when().get(path).then().spec(responseSpecification).extract().response();
        }
        json = new JsonPath(response.asString());
    }
    @Then("api call got success code with {int}")
    public void api_call_got_success_code_with(int successCode) {

        Assert.assertEquals(response.getStatusCode(),successCode);
    }
    @Then("validate the {string} and {string}")
    public void validate_the_and(String string, String string2) {
        Assert.assertEquals(json.get(string),string2);
        String response1  =requestSpecification.queryParam("place_id",json.get("place_id")).
                when().get(path).then().extract().response().asString();
        json = new JsonPath(response1);
        System.out.println("RAMU VEX"+json.getString("Scope"));
    }

    @Then("user validates the {string}")
    public void user_validates_the_name(String name){
        Assert.assertEquals("To check the name",json.get("name"),name);
    }

}
