package APIday1;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Day6 {
	@Test
	public void TestQueryAndPathParameters() {
		//https://reqres.in/api/users?page=2
		Response response = RestAssured.given()
		.pathParam("mypath","users")
		.queryParam("page",2)
		.when().get("https://reqres.in/api/{mypath}");
		response.then().log().all();
		response.then().statusCode(200);
		response.then().log().headers();
		response.then().header("Content-Type", Matchers.equalTo("application/json; charset=utf-8"));
		response.then()
        .header("Server", Matchers.equalTo("cloudflare"))
        .header("Content-Encoding", Matchers.equalTo("gzip")) // Replace with the expected encoding value
        .header("Connection", Matchers.equalTo("keep-alive")) // Replace with the expected connection type
        .header("Cache-Control", Matchers.containsString("max-age=14400")) // Replace with the expected Cache-Control value
        .header("Vary", Matchers.containsString("Accept-Encoding")) // Replace with the expected Vary value
        .header("Cf-Cache-Status", Matchers.equalTo("HIT"));

			
	
	}

	}


