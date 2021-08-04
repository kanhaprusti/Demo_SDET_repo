package ParametersAndAuthentication;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class kghidd {
@Test
public void jsgjjgd() {
	//create body of project
			HashMap<Object, Object> map = new HashMap<Object, Object>();
			map.put("createdBy", "Abhi");
			map.put("projectName", "Relience");
			map.put("status", "completed");
			map.put("teamSize", 8);

			baseURI="http://localhost";
			port=8084;
			// create project
			Response response = given()
					.contentType(ContentType.JSON)
					.body(map)
					.when()
					.post("/addProject");
			response.then().assertThat().statusCode(201);

			//capture project id of the project
			String jPath=response.jsonPath().get("projectId");

			//get all the projects
			Response resp = when()
					.get("/projects");
			resp.then().assertThat().statusCode(200);
			resp.then().log().all();

			//compare and capture project id  from all the projects
			String path=null;
			List<String> list = resp.jsonPath().get("projectId");
			String expData=jPath;
			for(String data:list)
			{
				if(data.equals(expData))
				{
					path=data;
				}
			}

			//create path parameter for the project id
			given()
			.pathParam("proId", path)

			//delete the created project using project id
			.when()
			.delete("/projects/{proId}")
			.then()
			.log().all()
			.assertThat().statusCode(204);
		}
	

}
