package RmgApi_BDD;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class getProject {
	@Test
	public void creatAppProject() {
		given()
		.get("http://localhost:8084/projects")
		.then()
		.log().all()
		.and()
		.assertThat().statusCode(200)
		.and()
		.assertThat().contentType(ContentType.JSON);

	}
}
