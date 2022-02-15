package com.apitesting1;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matcher.*;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.response.Response;

public class Gettesting {
	@Test
	public void test_01()
	{
		given().
		header("Content-Type","application/json").
		when().
		queryParam("page", 2).
		get("https://reqres.in/api/user").
		then().
		assertThat().
		body("page",equalTo(2)).
		body("per_page",equalTo(6)).
		body("data.id[0]",equalTo(7)).
		body("data.name[0]",is("sand dollar")).
		statusCode(200).
		log().all();			            
	}

	@Test
	public void post_get_Test()
	{
		JSONObject json=new JSONObject();
		json.put("name","gayu");
		json.put("job", "programmer-trainee");

		System.out.println(json);
		System.out.println(json.toJSONString());

		//baseURI="https://reqres.in/api";
		Response resp=given().
				header("Content-type","application/json").
				when().
				post("https://reqres.in/api/users").
				then(). 
				assertThat().
				statusCode(201)
				//body("name",equalTo("gayu")).
				//and().
				//body("job",equalTo("programmer-trainee"))
				.extract()
				.response();
		System.out.println("Response got is:"+resp.asString());


		//get request
		String idtest=resp.jsonPath().getString("id");
		System.out.println("id is:"+idtest);
		Response res=given().
				header("Content-Type","application/json").
				when().
				get("https://reqres.in/api/users/"+idtest).
				then().
				assertThat().
				//statusCode(200).
				body("name",equalTo("gayu")).
				and().
				body("job",equalTo("programmer-trainee"))
				.extract()
				.response();
		
		System.out.println("Final response is:"+res);

	}
}
