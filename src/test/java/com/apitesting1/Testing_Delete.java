package com.apitesting1;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
public class Testing_Delete {

	@Test
	public void deleteTesting()
	{
		when()
		  .delete("https://reqres.in/api/users/2")
		.then()
		  .statusCode(204).log().all();
	}
}
