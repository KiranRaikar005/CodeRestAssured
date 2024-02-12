package StepDefinationFile;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.hamcrest.Matcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.Matchers.*;


import Pojo.Payload;
import Pojo.Products;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import static org.hamcrest.Matchers.*;

public class scenario2 

{
	
	String FinalResponse;
	io.restassured.response.Response res1;
	RequestSpecification req1;
	Integer count=0;
	
	@Given("Endpoints are given")
	public void endpoints_are_given() throws JsonMappingException, JsonProcessingException
	{
	 
		RestAssured.baseURI="https://api.escuelajs.co";
		 req1=given().header("Content-Type","application/json");
		
				
			 
			 
		 }
	

	@When("Retrieve all product details")
	public void retrieve_all_product_details() 
	
	{
		 res1=req1.when().get("api/v1/products").then()
                 .extract().response();
           FinalResponse=res1.asString();
         System.out.println(FinalResponse);
		
	}

	@Then("price must be greater than {int}")
	public void price_must_be_greater_than(int PriceValue) 
	
	{
		 RestAssured.baseURI = "https://api.escuelajs.co/api/v1/products";

	        // Send a GET request to retrieve all products
	        RestAssured.given()
	                .when()
	                .get()
	                .then()
	                .statusCode(200)
	                .body("price",notNullValue());
	        System.out.println("Price is greater than 0");
	
	
       

		
	
	
		
	
		
		
		//List<Integer>s1=js.getList("price");
		
		 
		/*
		 * for(Integer prices:s1) { if(prices>0) { count++; }
		 * 
		 * 
		 * } if(count>0) { System.out.println("Price is greater than zero"); }
		 * 
		 * else { System.out.println("Price is lesser than zero"); }
		 */
		
		
         
	
            
           
		
	}


}
