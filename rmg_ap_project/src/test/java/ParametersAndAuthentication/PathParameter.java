package ParametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
  @Test
    public void verifyPathparameter() {
	  baseURI="http://localhost";
	  port=8084;
	  given()
	  .pathParam("projectId", "TY_PROJ_804")
	  .when()
	  .delete("/projects/{projectId}")
	  .then()
	  .assertThat().statusCode(204);
	  
  }
}
