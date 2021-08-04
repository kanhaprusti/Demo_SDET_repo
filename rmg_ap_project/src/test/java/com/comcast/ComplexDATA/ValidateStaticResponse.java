package com.comcast.ComplexDATA;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ValidateStaticResponse {
@Test
public void validateStaticResponse() {
	 String expectedData="Dolphin";
	 Response res = when()
	    .get("http://localhost:8084/projects");
	    res.then().statusCode(200).log().all();
	    String actualData = res.jsonPath().get("[0].projectName");
	    System.out.println("Expeected data is  : "+expectedData);
	    System.out.println("Actual data is  : "+actualData);
	   Assert.assertEquals(actualData, expectedData);
			
}
}
