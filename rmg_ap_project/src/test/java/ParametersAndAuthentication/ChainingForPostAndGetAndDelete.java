package ParametersAndAuthentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class ChainingForPostAndGetAndDelete {
	@Test
	public void   requestForpostAndGetAndDelete() {
		baseURI="http://localhost";
		port=8084;
		//Create project
		HashMap<Object, Object> map=new HashMap<Object, Object>();
		map.put("createdBy", "Suriya");
		map.put("projectName", "blackMamba13");
		map.put("status", "Completed");
		map.put("teamSize", 15);
		Response response =   given()
				.contentType(ContentType.JSON)
				.body(map)
				.when()
				.post("/addProject");
		response.then()
		.log().all();
		//Create JSON path
		String path = response.jsonPath().get("projectId");
		System.out.println(path);
		//Get the Project
		when()
		.get("http://localhost:8084/projects")
		.then()
		.log().all();
		//Delete the project
		given()
		.pathParam("project", path)
		.when()
		.delete("http://localhost:8084/projects/{project}")
		.then()
		.log().all()
		.assertThat().statusCode(204);

	}
}
