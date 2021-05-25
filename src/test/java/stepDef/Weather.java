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
	
	@Given("^There is a rest api to check crypto price$")
	public void i_want_to_check_weather_of_a_city() throws Throwable {
	  baseObj.baseURI = "https://api.coinbase.com/v2";
	  requestSpec = baseObj.given();
	}
	
	@When("^I provide Bitcoin$")
	public void provide_city_name() throws Throwable {
	  response = requestSpec.request(Method.GET, "/exchange-rates?currency=BTC");

	}
	
	@Then("^I get price information$")
	public void get_weather_information() throws Throwable {
	  Assert.assertEquals(200, response.getStatusCode());
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

	}
	
}
