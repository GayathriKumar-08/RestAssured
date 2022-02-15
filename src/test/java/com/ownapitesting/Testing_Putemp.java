package com.ownapitesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Testing_Putemp {

	@Test
	public void updateEmployee()
	{
		 JSONObject request=new JSONObject();
   	  request.put("empid", "A104");
   	  request.put("empname", "keerthi priya");
   	    	
     	  System.out.println(request);
   	  
   	   baseURI="http://localhost:3000/";
   	   
   	  given()
		    .header("Content-Type","application/JSON")
		    .contentType(ContentType.JSON).accept(ContentType.JSON)
	    	.body(request.toJSONString()).
   	    when().
   	      put("/employees/4").
   	    then().
   	    statusCode(200).log().all();
	}
}
