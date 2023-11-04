package APIday1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Day5 {
	String token="Bearer e31575095f22f0095710e90fffb1b2d650e3c623a62213c3ed4b13b12e71f7ee";
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

}
	  @Test
	public void createUser() throws FileNotFoundException {
		String email = getSaltString()+"@gmail.com";
		//Program1 :Creating payload Using hashmap
//		HashMap<String, Object> payload = new HashMap<>();
//
//        payload.put("name", "TenaLI Ramakrishna");
//        payload.put("gender", "male");
//        payload.put("email", email);
//        payload.put("status", "active");
//		
	   
		   //Program 2:creating payload Using org.json
//		     JSONObject jsonpayload = new JSONObject();
//
//		   // Add key-value pairs to the JSON object
//		      jsonpayload.put("name", "TenaLI Ramakrishna");
//		      jsonpayload.put("gender", "male");
//		      jsonpayload.put("email", email);
//		      jsonpayload.put("status", "active");
//		       String jsonString = payload.toString();//converting the json object to the string 
//		     
		     //Program3:Using pojo class
		    //Students payload = new Students("Raman Roy","male",email,"active");
		
		
		
		
		
		// Create a FileReader to read the JSON file
        FileReader fileReader = new FileReader("C:\\JAVA\\restAssured2\\src\\test\\java\\APIday1\\obj.json");
        // Create a JSONTokener to parse the JSON data
        JSONTokener tokener = new JSONTokener(fileReader);
        // Create a JSONObject from the parsed data
        JSONObject jsonpayload = new JSONObject(tokener);
        String payload = jsonpayload.toString();
        
          
		 
		RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
		Response response = RestAssured.given().header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", token)
				.body(payload)
				.when().post();

		response.then().log().all();
		response.then().statusCode(201);
		
	
			
		
	}


		     
		
	}
		
	


	


