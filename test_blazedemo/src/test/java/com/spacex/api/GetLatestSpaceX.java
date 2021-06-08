package com.spacex.api;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

public class GetLatestSpaceX 
{
	
	@Test
	public void getSpaceXLatest()
	{
		RestAssured.baseURI="https://api.spacexdata.com/";
		String response = 
				RestAssured.given().log().all()
		.when().get("v4/launches/latest")
		.then().log().all().assertThat().statusCode(200) //1. STATUS CODE VERIFICATION
		.body("id", equalTo("5fe3af6db3467846b3242160"))
		.body("links.youtube_id", equalTo("bgtDRR2F2wA"))  //2. youTube Id validation
		.header("Content-Type", "application/json; charset=utf-8")    //3. CONTENT-TYPE VERIFICATION
		.extract().response().asString();
		
		//4. Name validation
		JsonPath jpath = new JsonPath(response);
		String name = jpath.getString("name");
		
		Assert.assertEquals(name, "SXM-8");
		
	}
}
