package ParametersAndAuthentication;

import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

import java.util.HashMap;

public class BearerToken {
  @Test
  public void verifyBearerTokenAuthentiction() {
	  HashMap<Object, Object> map=new HashMap<Object, Object>();
	  map.put("name", "Demo_SDET_repo");
	  given()
	  .auth()
	  .oauth2("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")
	  .body(map)
	  .when()
	  .post("https://api.github.com/user/repos")
	  .then()
	  .log().all();
  }
}
