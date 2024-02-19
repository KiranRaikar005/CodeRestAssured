package StepDefinationFile;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import Pojo.Payload;
import Pojo.Products;
import Resources.ProductClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class PagerAPI 

{
	//Defining Global Variable
	String FinalResponse;
	io.restassured.response.Response res1;
	RequestSpecification req1;
	

	@Given("Pager API Endpoints are given")
	public void pager_api_endpoints_are_given() throws JsonParseException, JsonMappingException, IOException 
	
	{
		RestAssured.baseURI="https://api.escuelajs.co";
	    
	}
	@Then("I retrieve the products with offset {int} and limit {int}")
	public void i_retrieve_the_products_with_offset_and_limit(Integer offset, Integer limit) 
	
	{
		
		/*
		 * RestAssured.baseURI="https://api.escuelajs.co";
		 * FinalResponse=given().queryParam("offset", offset).queryParam("limit", limit)
		 * .when().get("api/v1/products") .then().extract().response().asString();
		 * System.out.println(FinalResponse);
		 */
		
		//Request and response specification being used
		RestAssured.baseURI="https://api.escuelajs.co";
		 req1=given().queryParam("offset", offset).queryParam("limit", limit);
		 res1=req1.when().get("api/v1/products").then()
				                   .extract().response();
		 FinalResponse=res1.asString();
		 System.out.println(FinalResponse);
				
	  
	}
	@Then("Number of products count should be {int}")
	public void number_of_products_count_should_be(int ExpectedValue) 
	
	{
		
		JsonPath path=new JsonPath(FinalResponse);
		int ActualValue=path.getList("id").size();
		Assert.assertEquals(ExpectedValue, ActualValue);
		System.out.println("Counts are Matching");
   
		
		
	}
	@Then("response code should be {int}")
	public void response_code_should_be(int ExpectedStatusCode) 
	
	{
		int ActualStatusCode=req1.when().get("api/v1/products").then()
                .extract().response().statusCode();
		
	    Assert.assertEquals(ExpectedStatusCode, ActualStatusCode);
	    System.out.println("Status code returned as expected");
		
	}




				
	   
	}



