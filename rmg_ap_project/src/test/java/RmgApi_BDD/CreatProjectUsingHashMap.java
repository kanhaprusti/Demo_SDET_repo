package RmgApi_BDD;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreatProjectUsingHashMap {
	@Test
	public void creatproject() {
		HashMap<Object, Object> map=new HashMap<Object, Object>();
		map.put("createdBy", "Roji");
		map.put("projectName", "Dolphin");
		map.put("status", "Completed");
		map.put("teamSize", 20);
		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON);
	}
}
