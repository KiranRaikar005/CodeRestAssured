package StepDefinationFile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;


public class Scenario5 

{
	String response;
	
	@Given("Pass URI data")
	public void pass_uri_data() 
	
	{
		
		RestAssured.baseURI="https://api.escuelajs.co";
	   
	}

	@When("retrieve the response with invalid resource")
	public void retrieve_the_response() 
	
	{
		 response=given().header("Content-Type","application/json")
		.when().get("api/v1/product1")
		.then().extract().response().asString();
	
	 
	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer statuscode) 
	
	{
		 given().header("Content-Type","application/json")
					.when().get("api/v1/product1")
					.then().assertThat().statusCode(statuscode);
		 System.out.println("Status code throwing 404");
	}

	@Then("use method post instead of get method status code should be {int}")
	public void use_method_post_instead_of_get_method_status_code_should_be(Integer statuscode1) 
	
	{
		 given().header("Content-Type","application/json")
			.when().post("api/v1/product1")
			.then().assertThat().statusCode(statuscode1);
System.out.println("Status code throwing 404 when method is POST");
	   
	}

}
