package StepDefinationFile;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.Category;
import Pojo.Payload;
import Pojo.Payload2;
import Pojo.Products;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class CreationOfProduct 


{
	
	String FinalResponse;
	io.restassured.response.Response res1;
	RequestSpecification req1;
	int count=0;

	@Given("API Endpoint is  given")
	public void api_endpoint_is_given() 
	
	{
		RestAssured.baseURI="https://api.escuelajs.co";

	}

	@When("{string} is created")
	public void is_created(String Expected) throws JsonMappingException, JsonProcessingException 
	
	{
		//Deserialization being used
		 String str=Payload2.SamplePayload();
		  

		 ObjectMapper mapper = new ObjectMapper();
		 Products[] jsonObj = mapper.readValue(str, Products[].class);
		 for (Products itr : jsonObj)
		 {
			 //System.out.println(itr.getDescription());
			 //System.out.println(itr.getPrice());
			 String actual=itr.getTitle();
			 //System.out.println(actual);
			 if(actual.matches(Expected))
			 {
				 System.out.println("Product is created");
			 }
			
			 
			 
		 }
	 
	}

	@Then("verify name of the product is {string}")
	public void verify_name_of_the_product_is(String ExpectedName) throws JsonMappingException, JsonProcessingException 
	
	{
		
		 String str=Payload2.SamplePayload();
		  

		 ObjectMapper mapper = new ObjectMapper();
		 Products[] jsonObj = mapper.readValue(str, Products[].class);
		 for (Products itr : jsonObj)
		 {
			Category Name= itr.getCategory();
			String ActualName= Name.getName();
			
		}
		 if(count>0)
		 {
				System.out.println("ProductName is created");

		 }
	}

	@Then("status code shoud be {int}")
	public void status_code_shoud_be(int statuscode) 
	
	{
		 
		 given().header("Content-Type", "application/json")
		 .when().get("api/v1/products").then().assertThat().statusCode(statuscode);
		 
		 System.out.println("Status code matching");
		 
		
	   
	}




}
