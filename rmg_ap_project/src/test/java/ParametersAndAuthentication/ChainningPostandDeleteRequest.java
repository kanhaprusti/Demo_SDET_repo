package ParametersAndAuthentication;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ChainningPostandDeleteRequest {
	@Test
	public void requestChainningForPostAndDelete() {
		baseURI="http://localhost";
		port=8084;
		//Create Body
		HashMap<Object, Object> map=new HashMap<Object, Object>();
		map.put("createdBy", "Suriya");
		map.put("projectName", "JellyFish434");
		map.put("status", "Completed");
		map.put("teamSize", 15);
		//Create Project
		Response response = given()
				.contentType(ContentType.JSON)
				.body(map)
				.when()
				.post("/addProject");
		response.then().log().all();
		//Take JSON path
		String path = response.jsonPath().get("projectId");
		System.out.println(path);
		//delete the Project
		given()
		.pathParam("project", path)
		.when()
		.delete("/projects/{project}")
		.then()
		.log().all()
		.assertThat().statusCode(204);
	}
}