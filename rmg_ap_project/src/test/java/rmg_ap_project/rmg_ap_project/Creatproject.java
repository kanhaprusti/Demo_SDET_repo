package rmg_ap_project.rmg_ap_project;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Creatproject {
	@Test
	public void CreatAProject() {
		JSONObject  Objec=new JSONObject();
		Objec.put("createdBy", "Hema");
		Objec.put("projectName", "1st_SDET");
		Objec.put("status", "Completed");
		Objec.put("teamSize", 20);

		RequestSpecification ReqSpes = RestAssured.given();

		ReqSpes.contentType(ContentType.JSON);
		ReqSpes.body(Objec);
		Response Resp = ReqSpes.post("http://localhost:8084/addProject");
		Resp.prettyPrint();
		Assert.assertEquals(Resp.statusCode(), 201);
	}
}
