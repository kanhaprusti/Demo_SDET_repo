package RmgApi_BDD;


import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class Creatproject1 {
	@Test
	public void CreatProject() {
		//Create the body
		JSONObject obect=new JSONObject();
		obect.put("createdBy", "Roji");
		obect.put("projectName", "1st_SDET444");
		obect.put("status", "Completed");
		obect.put("teamSize", 20);
		//Pre Condition
		given()
		.contentType(ContentType.JSON)
		.body(obect)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);

	}
}
