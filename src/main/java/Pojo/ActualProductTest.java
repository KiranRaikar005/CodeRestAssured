package Pojo;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class ActualProductTest {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException 
	
	{
		// TODO Auto-generated method stub
		
		
		//Passing payload
		 String str=Payload.payload();
		  

		 ObjectMapper mapper = new ObjectMapper();
		 Products[] jsonObj = mapper.readValue(str, Products[].class);
		 for (Products itr : jsonObj)
		 {
			 //System.out.println(itr.getDescription());
			 System.out.println(itr.getPrice());
		 }
		 
		
		 
		
	

	}

}
	

