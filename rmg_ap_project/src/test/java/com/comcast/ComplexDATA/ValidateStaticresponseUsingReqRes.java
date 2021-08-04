package com.comcast.ComplexDATA;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ValidateStaticresponseUsingReqRes {
@Test
   public void validateStaticresponseUsingReqRes() {
	String expectedData="Michael";
	 Response res = when()
	    .get("https://reqres.in/api/users?page=2");
	    res.then().statusCode(200).log().all();
	    String actualData = res.jsonPath().get("data[0].first_name");
	    System.out.println("Expeected data is  : "+expectedData);
	    System.out.println("Actual data is  : "+actualData);
	   Assert.assertEquals(actualData, expectedData);
}
}
