package RmgApi_BDD;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateTheProject {
	@Test
	public void UpdateProject() {
		JSONObject  Objec=new JSONObject();
		Objec.put("createdBy", "Hema1");
		Objec.put("projectName", "1st_SDET");
		Objec.put("status", "Completed");
		Objec.put("teamSize", 20);
		given()
		.contentType(ContentType.JSON)
		.body(Objec)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_804")
		.then()
		.log().all()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON);
	}
}
