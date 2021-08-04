package TestCaseAssinments;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingFormData {
  @Test
  public void creatProjectusingFormData() {
	  Response resp = (Response) given()
		.formParam("createdBy", "Pradeep")	
		.formParam("projectName", "Bluewell203")
		.formParam("status", "Completed")
		.formParam("teamSize", 20)
		
		.contentType(ContentType.JSON)
		
			  .when()
			  .post("http://localhost:8084/addProject");
			  resp .then()
			  .assertThat().statusCode(201)
			  .assertThat().contentType(ContentType.JSON);
  }
}
