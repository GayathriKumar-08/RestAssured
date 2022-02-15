package com.apitesting1;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Testing_POST {

	@Test
	public void postTesting()
	{
//		Map<String,Object> map=new HashMap<String,Object>();
//		
//		map.put("name","gayu");
//		map.put("job", "programmer-trainee");
//		System.out.println(map);
		
		JSONObject json=new JSONObject();
		json.put("name","gayu");
		json.put("job", "programmer-trainee");

		System.out.println(json);
		System.out.println(json.toJSONString());
		
		given()
		    .header("Content-Type","application/JSON")
		    .contentType(ContentType.JSON).accept(ContentType.JSON)
	    	.body(json.toJSONString())
		.when()
		   .post("https://reqres.in/api/users")
		.then()
		   .statusCode(201)
		   .log().all();
	}
	
	
}
