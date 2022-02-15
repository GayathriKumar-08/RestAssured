package com.apitesting1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Testing_Put {

	@Test
	public void putTesting()
	{
		JSONObject json=new JSONObject();
		json.put("name", "keerthi");
		json.put("job", "hr");
		
		System.out.println(json.toJSONString());
		
		given()
		 .header("Content-Type","Application/JSON")
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(json.toJSONString())
		 .when()
		   .put("https://reqres.in/api/users/2")
		  .then()
		  .statusCode(200).log().all();
	}
	
	@Test
	public void patchTesting()
	{
		JSONObject json=new JSONObject();
		json.put("name", "keerthi");
		json.put("job", "hr");
		
		System.out.println(json.toJSONString());
		
		given()
		 .header("Content-Type","Application/JSON")
		 .contentType(ContentType.JSON)
		 .accept(ContentType.JSON)
		 .body(json.toJSONString())
		 .when()
		   .patch("https://reqres.in/api/users/2")
		  .then()
		  .statusCode(200).log().all();
	}
}
