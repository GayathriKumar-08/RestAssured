package com.ownapitesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;

public class Testing_DataDriven extends DataProviderParent{


	// @Test(dataProvider = "dataforpost")
     public void postEmployee(String empid,String empname)
     {
   	  JSONObject request=new JSONObject();
   	  request.put("empid", empid);
   	  request.put("empname", empname);
   	    	
     	  System.out.println(request);
   	  
   	   baseURI="http://localhost:3000/";
   	   
   	  given()
		    .header("Content-Type","application/JSON")
		    .contentType(ContentType.JSON).accept(ContentType.JSON)
	    	.body(request.toJSONString()).
   	    when().
   	      post("/employees").
   	    then().
   	    statusCode(201).log().all();
     }
	 

	// @Test(dataProvider = "delEmp")
	 public void deleteEmployee(int id) {
	  	   baseURI="http://localhost:3000/";
		  
	  	   when().
	  	      delete("/employees/"+id).
	  	    then().
	  	    statusCode(200).log().all();
		}
	 
	 @Parameters({"id"})
	 @Test
	 public void deleteEmployee1(int id) {
	  	   baseURI="http://localhost:3000/";
	  	   when().
	  	      delete("/employees/"+id).
	  	    then().
	  	    statusCode(200).log().all();
		}
}
