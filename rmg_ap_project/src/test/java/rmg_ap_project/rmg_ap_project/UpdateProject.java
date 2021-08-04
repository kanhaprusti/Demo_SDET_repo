package rmg_ap_project.rmg_ap_project;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	@Test
	public void Updateproject() {
		JSONObject  Objec=new JSONObject();
		Objec.put("createdBy", "Hema1");
		Objec.put("projectName", "1st_SDET");
		Objec.put("status", "Completed");
		Objec.put("teamSize", 20);
		RequestSpecification ResSpe = RestAssured.given();
		ResSpe.contentType(ContentType.JSON);
		ResSpe.body(Objec);
		Response resp = ResSpe.put("http://localhost:8084/projects/TY_PROJ_205	");
		resp.prettyPrint();
		Assert.assertEquals(resp.getStatusCode(), 200);
	}
}
