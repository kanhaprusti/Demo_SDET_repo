import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateTheProjectUsingJsonFile {
@Test
public void updateProjectUsing() {
	File file=new File("./sample.json");
	
	given()
	.contentType(ContentType.JSON)
	.body(file)
	.when()
	.put("http://localhost:8084/projects/TY_PROJ_1003")
	.then()
	.log().all()
	.assertThat().contentType(ContentType.JSON)
	.assertThat().statusCode(200);
}
}
