package rmg_ap_project.rmg_ap_project;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTheProject {
	@Test
	public void getAllProject() {
		Response Resp = RestAssured.get("http://localhost:8084/projects");
		System.out.println(Resp);
		//Verify Status code
		int ActualStatus = Resp.statusCode();
		System.out.println(ActualStatus);
		Assert.assertEquals(ActualStatus, 200);
		//Verify Content type
		String ActualContentType = Resp.contentType();
		Assert.assertEquals(ActualContentType, "application/json");
		Resp.prettyPrint();
	}
}
