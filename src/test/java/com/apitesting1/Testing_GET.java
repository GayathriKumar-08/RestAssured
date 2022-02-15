package com.apitesting1;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class Testing_GET {

	@Test
	public void getTest()
	{
		given().queryParam("page", "2")
		  .get("https://reqres.in/api/users")
		.then()
		  .statusCode(200)
		  .body("data.id[1]", equalTo(8))
		  .body("data.first_name", hasItems("Michael","Lindsay","Tobias"))
		  .body("data.last_name", hasItem("Edwards"))
		  .log().all();
	}
}
