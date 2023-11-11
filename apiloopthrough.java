package APIday1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DAy7 {
//	{
//
//    "page": 2,
//    "per_page": 6,
//    "total": 12,
//    "total_pages": 2,
//    "data": [
//        {
//            "id": 7,
//            "email": "michael.lawson@reqres.in",
//            "first_name": "Michael",
//            "last_name": "Lawson",
//            "avatar": "https://reqres.in/img/faces/7-image.jpg"
//        },
//        {
//            "id": 8,
//            "email": "lindsay.ferguson@reqres.in",
//            "first_name": "Lindsay",
//            "last_name": "Ferguson",
//            "avatar": "https://reqres.in/img/faces/8-image.jpg"
//        },
//        {
//            "id": 9,
//            "email": "tobias.funke@reqres.in",
//            "first_name": "Tobias",
//            "last_name": "Funke",
//            "avatar": "https://reqres.in/img/faces/9-image.jpg"
//        },
//        {
//            "id": 10,
//            "email": "byron.fields@reqres.in",
//            "first_name": "Byron",
//            "last_name": "Fields",
//            "avatar": "https://reqres.in/img/faces/10-image.jpg"
//        },
//        {
//            "id": 11,
//            "email": "george.edwards@reqres.in",
//            "first_name": "George",
//            "last_name": "Edwards",
//            "avatar": "https://reqres.in/img/faces/11-image.jpg"
//        },
//        {
//            "id": 12,
//            "email": "rachel.howell@reqres.in",
//            "first_name": "Rachel",
//            "last_name": "Howell",
//            "avatar": "https://reqres.in/img/faces/12-image.jpg"
//        }
//    ],
//    "support": {
//        "url": "https://reqres.in/#support-heading",
//        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
//    }
	

	
	@Test
	   public void Testcase() {
		   
		   //PartA
	   
			RestAssured.baseURI = "https://reqres.in/api";
			given()
			.when()
			.get("users/2")
			.then().
			statusCode(200)
			.header("Content-Type", "application/json; charset=utf-8")
			.body("data[0].email", equalTo("michael.lawson@reqres.in"));
			
			
			//PartB
			
			RestAssured.baseURI = "https://reqres.in/api";
			Response response=
					given()
					.when()
					.get("users/2");
			Assert.assertEquals(response.getStatusCode(), 200);
			Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
			String email = response.jsonPath().get("data[0].email").toString();
			Assert.assertEquals(email,"michael.lawson@reqres.in");
			
			
			
			
			
		   
	   }

			
		   
	   

	   @Test
	   public void Testcaset2() {
		//LOOP Through
		   RestAssured.baseURI = "https://reqres.in/api";
		   
		   boolean found=false;
		   Response response = given().when().get("/users?page=2");

		   JSONObject res = new JSONObject(response.asString());
		   JSONArray users = res.getJSONArray("data");

		   for (int i = 0; i < users.length(); i++) {
		       JSONObject user = users.getJSONObject(i);
		       String firstName = user.getString("first_name");
		       System.out.println(firstName);
		   
		   if(firstName.equals("George")) {
			   found=true;
			   break;
		   }
		   }
		   Assert.assertTrue(found);
		   }

	   }
			


	   

