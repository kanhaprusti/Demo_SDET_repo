package com.comcast.ComplexDATA;

import static io.restassured.RestAssured.*;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class ValidateDynamicResponseUsingReqRes {
	@Test
	public void dynamicResponseUsingReqRes() {
		String expecteData="cerulean";
		String actualData=null;
		Response resp = when()
				.get("https://reqres.in/api/unknown");
		resp.then().statusCode(200).log().all();

		List<String>	set=resp.jsonPath().get("data.name");
		boolean flag=false;
		for(String data:set) {
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
