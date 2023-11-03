package APIday1;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Day4 {
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
    public void getUsers() {
		//curl -i -H "Accept:application/json" -H "Content-Type:application/json" -H "Authorization: Bearer e31575095f22f0095710e90fffb1b2d650e3c623a62213c3ed4b13b12e71f7ee" -XGET "https://gorest.co.in/public/v2/users"
        RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
        Response response=RestAssured
        		.given() 
        		.header("Accept","application/json")
        		.header("Content-Type","application/json")
        		.header("Authentication",token)
        		.when()
        		.get();
        response.then().statusCode(200);
        //
	}
	@Test
	public void createUser() {
		String email = getSaltString()+"@gmail.com";
		String requestBody = "{\"name\":\"Tenali Ramakrishna\", \"gender\":\"male\", \"email\":\"" + email + "\", \"status\":\"active\"}";
		RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
		Response response = RestAssured
				.given()
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", token)
				.body(requestBody).when().post();
		
		
		
		response.then().log().all();
		response.then().statusCode(201);
		
	}
	@Test
	public void updateUser() {
		String email = getSaltString()+"@gmail.com";
		String requestBody = "{\"name\":\"Tenali Ramakrishna\", \"gender\":\"male\", \"email\":\"" + email + "\", \"status\":\"active\"}";
		RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
		Response response = RestAssured
				.given()
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", token)
				.body(requestBody).when().patch("/ 5626762");
		
		
		
		response.then().log().all();
		response.then().statusCode(200);
	
}
	@Test
	public void DeleteUser() {
	RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
	Response response = RestAssured
			.given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization", token)
			.when().delete("/ 5626762");
	 response.then().log().all();
	 response.then().statusCode(204);
	
	
	
}
}

