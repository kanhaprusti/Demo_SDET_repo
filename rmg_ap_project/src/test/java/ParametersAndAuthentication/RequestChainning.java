package ParametersAndAuthentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class RequestChainning {
	@Test
	public void verifyRequestChainning() {
		baseURI="http://localhost";
		port=8084;
		//get all the projects
		Response resp = when()
				.get("/projects");
		//Capture project id
		String firstProjectId = resp.jsonPath().get("[0].projectId");
		System.out.println(firstProjectId);
		//Delete The project
		given()
		.pathParam("ProjectId", firstProjectId)
		.when()
		.delete("/projects/{ProjectId}")
		.then()
		.assertThat().statusCode(204)
		.log().all();


	}
}
