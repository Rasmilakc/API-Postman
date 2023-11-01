package APIday1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Day3 {
	@Test
	public void APIchaining() {
		RestAssured.baseURI="https://reqres.in/api";
	        Response response = RestAssured.given()
	                .param("page", 2)
	                .when()
	                .get("/users")
	                .then()
	                .extract()
	                .response();
	        int id=response.jsonPath().getInt("data[0].id");
	        int id2=response.jsonPath().getInt("total");
	        
//			String firstName = response.jsonPath().getString("data[5].first_name");
//			String text = response.jsonPath().getString("support.text");
	        
	        //assertion
	        
	        Response res=given()
	        		.pathParam("userId", id)
	        		.when()
	        		.get("users/{userId}");
	        res.then().statusCode(200);
	        res.then().assertThat()
	        .body("data.id", equalTo(id))
	        .body("data.email", equalTo("michael.lawson@reqres.in"))
			.body("data.first_name", equalTo("Michael"))
			.body("data.last_name", equalTo("Lawson"));
			response.then().log().all();
	        
	        
	}

    }
 


