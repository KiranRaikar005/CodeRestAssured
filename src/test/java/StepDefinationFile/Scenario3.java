package StepDefinationFile;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.Payload;
import Pojo.Products;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Scenario3 

{
	
	String FinalResponse;
	io.restassured.response.Response res1;
	RequestSpecification req1;
	
	@Given("EndPoint is provided")
	public void end_point_is_provided() throws JsonMappingException, JsonProcessingException 
	{
		RestAssured.baseURI="https://api.escuelajs.co";
		
	
	}

	@When("Retrieve products with offset {int} and limit {int}")
	public void retrieve_products_with_offset_and_limit(Integer offset, Integer limit) 
	{
		 req1=given().queryParam("offset", offset).queryParam("limit", limit);
		 res1=req1.when().get("api/v1/products").then()
				                   .extract().response();
		 
		 FinalResponse=res1.asString();
				 

	    
	}

	@Then("The number of  products should be {int}")
	public void the_number_of_products_should_be(int ExpectedCount) throws JsonMappingException, JsonProcessingException 
	{
		JsonPath js=new JsonPath(FinalResponse);
		List<Integer> Price=js.getList("price");
		int ActualPrice=Price.size();
		Assert.assertEquals(ExpectedCount, ActualPrice);
		System.out.println("Price count is matching");
		
	
	}

	}

