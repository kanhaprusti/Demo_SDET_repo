package rmg_ap_project.rmg_ap_project;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	@Test
	public void DelectPr() {
		Response Resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_204"); 
		Resp.prettyPrint();
		int AtualStatus = Resp.statusCode();
		Assert.assertEquals(AtualStatus, 204);
		Object ActualContype=Resp.contentType();
		Assert.assertEquals(ActualContype, "application/json");
	}
}
