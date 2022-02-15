package com.ownapitesting;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;


public class Testing_Deleteemp {
 @Test
	public void deleteEmployee() {
  	   baseURI="http://localhost:3000/";
	  
  	   when().
  	      delete("/employees/3").
  	    then().
  	    statusCode(200).log().all();
	}
}
