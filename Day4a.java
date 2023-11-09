package APIday1;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class APITest {
	private String accessToken="e31575095f22f0095710e90fffb1b2d650e3c623a62213c3ed4b13b12e71f7ee";
	APIUtilities utils= new APIUtilities(accessToken);
	@Test
	public void testGetRequest() {
        Response getResponse = utils.sendGetRequest("/users");
        getResponse.then().statusCode(200);
	}
	
	
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
	
	public void testPostRequest() {
		 String email = getSaltString()+"@gmail.com";
			//Program1 :Creating payload Using hashmap
			HashMap<String, Object> payload = new HashMap<>();
	
	        payload.put("name", "TenaLI Ramakrishna");
	        payload.put("gender", "male");
	        payload.put("email", email);
	        payload.put("status", "active");
			
		//String payload="'{\"name\":\"Tenali Ramakrishna\", \"gender\":\"male\", \"email\":\"tenali.ramakrishna@15ce.com\", \"status\":\"active\"}";
        Response postResponse = utils.sendPostRequest("/users",payload);
        postResponse.then().statusCode(201);
	}
	 
	 @Test
	 public void testPutRequest() {
	     String email = getSaltString() + "@gmail.com";
	     // Create a payload using a HashMap
	     HashMap<String, Object> payload = new HashMap<>();
	     payload.put("name", "Tenali Ramakrishna");
	     payload.put("gender", "male");
	     payload.put("email", email);
	     payload.put("status", "active");

	     Response putResponse = utils.sendPutRequest("/users/ 5704909", payload); 
	     putResponse.then().statusCode(200); 
	 }
	 
	 @Test
	  public void testDeleteRequest() {
	        Response deleteResponse = utils.sendDeleteRequest("/users/5704909");
	        deleteResponse.then().statusCode(204);
		}
	 
	 
}






