package ParametersAndAuthentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Ouath21Authentication {
	@Test
    public void ouathAthentication() {
		 //Provide the Client Id and Client secret to generate token
		  Response resp =  given()
				  .formParam("client_id", "Medusa")
				  .formParam("client_secret", "afd98e8a9e28ad6fca2060c83f271642")
				  .formParam("grant_type", "client_credentials")
				  .formParam("redirect_uri", "http://demo.com")
				  //Generate token
				  .when()
				  .post("http://coop.apps.symfonycasts.com/token");
				  System.out.println(resp.prettyPrint());
		         String Token = resp.jsonPath().get("access_token");
		      System.out.println(Token);
		      //Use the token
		      given()
		      .auth()
		      .oauth2(Token)
		      .pathParam("USER_ID", "2125")
		      .when()
		      .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		      .then()
		      .log().all();
    }
}
