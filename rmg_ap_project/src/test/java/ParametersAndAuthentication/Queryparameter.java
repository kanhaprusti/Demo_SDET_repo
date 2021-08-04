package ParametersAndAuthentication;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Queryparameter {
@Test
  public void verifyQueryparameter() {
	baseURI="https://reqres.in";
	given()
	.queryParam("page", 3)
	.when()
	.get("api/users")
	.then()
      .assertThat().statusCode(200)
      .assertThat().time(Matchers.lessThan(2L), TimeUnit.SECONDS)
      .log().all()
	   .assertThat().time(Matchers.lessThan(1900L), TimeUnit.MILLISECONDS);
	
}
}
