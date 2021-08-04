package com.comcast.ComplexDATA;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.List;

public class ValidateDynamicResponse {
	@Test
	public void dynamicResponse() {
		String expecteData="Roji";
		String actualData=null;
		Response resp = when()
				.get("http://localhost:8084/projects");
		resp.then().statusCode(200).log().all();

		List<String>	list=resp.jsonPath().get("createdBy");
		boolean flag=false;
		for(String data:list) {
			if(data.equals(expecteData)) {
				actualData=data;
				flag=true;
				break;
			}
		}
		Assert.assertEquals(flag, true);
		Assert.assertEquals(actualData, expecteData);
	} 
}
