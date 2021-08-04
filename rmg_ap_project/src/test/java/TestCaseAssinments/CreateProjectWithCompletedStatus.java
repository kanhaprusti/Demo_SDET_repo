package TestCaseAssinments;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class CreateProjectWithCompletedStatus {
  @Test
  public void projectWithCompletedStatus() {
	  baseURI="http://localhost";
	  port=8084;
	  JSONObject obect=new JSONObject();
		obect.put("createdBy", "Roji");
		obect.put("projectName", "Bluebell");
		obect.put("status", "Completed");
		obect.put("teamSize", 20);
		given()
		.contentType(ContentType.JSON)
		.body(obect)
		.when()
		.post("/addProject")
		.then()
		.log().all()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
		
  }
}
