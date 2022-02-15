package com.apitesting1;


import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Test01_Get {

	 @Test
	 public void Test01()
	{
		Response res=get("https://reqres.in/api/users?page=2");
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asString());
		
		int statuscode=res.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}

	 @Test
     public void Test02(){
		 given()
		 .get("https://reqres.in/api/users?page=2")
		 .then()
		 .statusCode(200)
		 .body("data.id[0]",equalTo(7));
		}
}