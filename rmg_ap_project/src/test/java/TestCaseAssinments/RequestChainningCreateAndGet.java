package TestCaseAssinments;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChainningCreateAndGet {
	@Test
	public void requestChainningForPostAndDelete() {
		baseURI="http://localhost";
		port=8084;
		//Create Body
		HashMap<Object, Object> map=new HashMap<Object, Object>();
		map.put("designation", "Automation QA");
		map.put("dob", 12/07/1999);
		map.put("email", "krusti743@gmail.com");
		map.put("empName", "Rabert");
		map.put("experience", 6);
		map.put("mobileNo", "6362413499");
		map.put("project", "Medusa7");
		map.put("role", "automating");
		map.put("username", "AnkitaKummari12");
		//Create Project
		Response response = given()
				.contentType(ContentType.JSON)
				.body(map)
				.when()
				.post("/employees");
		response.then().log().all();
		//Take JSON path
		String path = response.jsonPath().get("employeeId");
		System.out.println(path);
		//Get the Employee
		given()
		.pathParam("Emp_Id", path)
		.when()
		.get("/employees/{Emp_Id}")
		.then()
		.log().all()
		.assertThat().statusCode(200);
	}
}

