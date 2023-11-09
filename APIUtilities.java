package APIday1;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIUtilities {
	private String accessToken;
	public APIUtilities(String accessToken) {
		this.accessToken=accessToken;
		RestAssured.baseURI = "https://gorest.co.in/public/v2";
			
	}
	
	
	//Get
	public Response sendGetRequest(String endpoint) {
	    return RestAssured
	            .given()
	            .header("Accept", "application/json")
	            .header("Content-type", "application/json")
	            .header("Authorization", "Bearer " + accessToken)
	            .when()
	            .get(endpoint);
	}
	
	//Post
	public Response sendPostRequest(String endpoint,HashMap<String, Object> payload) {
	    return RestAssured
	            .given()
	            .header("Accept", "application/json")
	            .header("Content-type", "application/json")
	            .header("Authorization", "Bearer " + accessToken)
	            .body(payload)
	            .when()
	            .post(endpoint);
	}
	
	//Put
	public Response sendPutRequest(String endpoint,HashMap<String, Object> payload) {
	    return RestAssured
	            .given()
	            .header("Accept", "application/json")
	            .header("Content-type", "application/json")
	            .header("Authorization", "Bearer " + accessToken)
	            .body(payload)
	            .when()
	            .put(endpoint);
	}
	
	//Delete
	public Response sendDeleteRequest(String endpoint) {
	    return RestAssured
	            .given()
	            .header("Accept", "application/json")
	            .header("Content-type", "application/json")
	            .header("Authorization", "Bearer " + accessToken)
	            .when()
	            .delete(endpoint);
	}
	
	

}