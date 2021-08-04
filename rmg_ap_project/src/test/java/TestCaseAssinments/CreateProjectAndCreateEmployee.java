package TestCaseAssinments;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectAndCreateEmployee {
	@Test
	public void requestChainingForCreateProjectAndCreatEmployee() {
		baseURI="http://localhost";
		port=8084;
		//Create body
		HashMap<Object, Object> map=new HashMap<Object, Object>();

		map.put("createdBy", "Suriya");
		map.put("projectName", "Rabert498");
		map.put("status", "Completed");
		map.put("teamSize", 15);
		Response respon = given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("/addProject");
		respon.then()
		.log().all();
		String jpath = respon.jsonPath().get("projectName");
		  given()
		  .pathParam("pName", jpath);
		//Creat1 employee
		HashMap<Object, Object> map1=new HashMap<Object, Object>();
		map1.put("designation", "Automation QA");
		map1.put("dob", 12/07/1999);
		map1.put("email", "krusti743@gmail.com");
		map1.put("empName", "Rabert");
		map1.put("experience", 6);
		map1.put("mobileNo", "6362413499");
		map1.put("project", "{pName}");
		map1.put("role", "automating");
		map1.put("username", "Abhijitkumar");
		given()
		.contentType(ContentType.JSON)
		.body(map1)
		.when()
		.post("/employees")
		.then()
		.log().all()
		.assertThat().statusCode(201);
	}
}
