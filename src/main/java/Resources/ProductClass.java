package Resources;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo.Payload;
import Pojo.Products;

public class ProductClass 

{
	
	public static void ProductPayload() throws JsonParseException, JsonMappingException, IOException 
	
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
