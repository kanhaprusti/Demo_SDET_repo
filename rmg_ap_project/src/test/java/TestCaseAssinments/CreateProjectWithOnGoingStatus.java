package TestCaseAssinments;

import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectWithOnGoingStatus {
	 @Test
	  public void projectWithOnGoingdStatus() {
		  baseURI="http://localhost";
		  port=8084;
		  JSONObject obect=new JSONObject();
			obect.put("createdBy", "Roji");
			obect.put("projectName", "Bluebell333");
			obect.put("status", "On Going");
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
