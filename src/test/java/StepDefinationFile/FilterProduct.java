package StepDefinationFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
public class FilterProduct 

{
	@Given("Endpoint url is given")
	public void endpoint_url_is_given() 
	
	{
	  
		RestAssured.baseURI="https://api.escuelajs.co";
	}

	@When("the user filters products within {int} random prices between {int} and {int}")
	public void the_user_filters_products_within_random_prices_between_and(int RandomPrice, int Maximum, int Minimum) 
	
	{
		
	    String response=given().queryParam("price_min", Minimum).queryParam("price_max", Maximum)
	    .when().get("api/v1/products").then().assertThat().statusCode(200).extract().response().asString();
	    System.out.println(response);
	}
//checking products
	@Then("the returned products should fall between {int} and {int}")
	public void the_returned_products_should_fall_between_and(int Maximum, int Minimum) 
	
	{
		given().queryParam("price_min", Minimum).queryParam("price_max", Maximum)
	    .when().get("api/v1/products").then().assertThat().statusCode(200)
	    .body("price", greaterThanOrEqualTo(Minimum)).body("price", lessThanOrEqualTo(Maximum));
	   
	}

}
