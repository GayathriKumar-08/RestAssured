package com.ownapitesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class Testing_Postemp {

	 @Test
      public void postEmployee()
      {
    	  JSONObject request=new JSONObject();
    	  request.put("empid", "A105");
    	  request.put("empname", "priya");
    	    	
      	  System.out.println(request);
    	  
    	   baseURI="http://localhost:3000/";
    	   
    	  given()//inputs
		    .header("Content-Type","application/JSON")
		    .contentType(ContentType.JSON).accept(ContentType.JSON)
	    	.body(request.toJSONString()).
    	    when().//http call
    	      post("/employees").
    	    then().
    	    statusCode(201).log().all();
      }
}
