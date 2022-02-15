package com.ownapitesting;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class Testing_Getemp {
	
	@Test
	public void getDesignation()
	{
		baseURI="http://localhost:3000/";
		
		given().
		   param("desig", "HR").
		   get("/empdesig").
		 then()
		   .statusCode(200)
		   .log().all();
	}
	
	@Test
	public void getAllEmployee()
	{
		baseURI="http://localhost:3000/";
		given().
		  header("Content-Type","application/json").
		  contentType(ContentType.JSON).
		   accept(ContentType.JSON).
		   get("employees").
		 then()
		   .statusCode(200)
		   .log().all();
	}

}
