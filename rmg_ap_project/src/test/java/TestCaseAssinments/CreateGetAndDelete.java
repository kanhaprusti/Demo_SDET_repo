package TestCaseAssinments;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import  static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;

public class CreateGetAndDelete {
	@Test
	public void creatAndgetAndDelete() {
		baseURI="http://localhost";
		port=8084;
		//Create the Body
		HashMap<Object, Object> map=new HashMap<Object, Object>();
		map.put("createdBy", "Suriya");
		map.put("projectName", "blackMamb4397");
		map.put("status", "Completed");
		map.put("teamSize", 15);
		Response resp = given()
				.contentType(ContentType.JSON)
				.body(map)
				.when()
				.post("/addProject");
		resp.then()
		.statusCode(201);
		//Create A JSON path
		String jpath = resp.jsonPath().get("projectId");
		System.out.println(jpath);
		//Get All The Project
		Response response = when()
		.get("/projects");
		response.then().log().all();
		
		//Compare the project
		String path=null;
		List<String> list = response.jsonPath().get("projectId");
		String expectedpath=jpath;
		for(String data:list) {
			if(data.equals(expectedpath)) {
				path=data;
			}
		}
		//Create path parameter for projectId
		given()
		.pathParam("pathprd", path)
		//Delete the project with the help of projectId 
		.when()
		.delete("/projects/{pathprd}")
		.then()
		.assertThat().statusCode(204);
	}
}
