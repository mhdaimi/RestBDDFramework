package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Weather {
	
	RestAssured baseObj;
	RequestSpecification requestSpec;
	Response response;
	
	@Given("^There is a rest api$")
	public void i_want_to_check_weather_of_a_city() throws Throwable {
	  baseObj.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	  requestSpec = baseObj.given();
	}
	
	@When("^I provide a city name$")
	public void provide_city_name() throws Throwable {
	  response = requestSpec.request(Method.GET, "/Aurangabad");

	}
	
	@Then("^I get weather information$")
	public void get_weather_information() throws Throwable {
	  Assert.assertEquals(200, response.getStatusCode());
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

	}
	
}
