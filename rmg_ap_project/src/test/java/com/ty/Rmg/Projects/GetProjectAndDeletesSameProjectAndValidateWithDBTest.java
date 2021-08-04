package com.ty.Rmg.Projects;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GetProjectAndDeletesSameProjectAndValidateWithDBTest {
	@Test
	public void getProjectAndDeletesSameProjectAndValidateWithDBTest() throws SQLException {
		baseURI="http://localhost";
		port=8084;

		//get all the projects
		Response resp = when()
				.get("/projects");
		//Capture the ProjectId
		// String actualId = null;
		String expproId= resp.jsonPath().get("[0].projectId");

		//Register with Data base
		Driver driver = new Driver();
		DriverManager.deregisterDriver(driver);
		//Connect to data base
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		//issue statement
		Statement stat = conn.createStatement();
		//Execute Query
		ResultSet result = stat.executeQuery("select * from project");
		String exprojectId=null;
		while(result.next()) {
			if(result.getString(1).equals(expproId)) {
				exprojectId=result.getString(1);
				System.out.println("project is present in data base");
				break;
			}
		}
		Assert.assertEquals(expproId, exprojectId);
		//Delete the project
		given()
		.pathParam("DproId", exprojectId)
		.when()
		.delete("/projects/{DproId}");
		boolean flag = false;
		while(result.next()) {
			exprojectId=result.getString(1);
			if(!(expproId.equals(exprojectId))) {
				flag=true;
				System.out.println("project is succsessfully  deleted");
				break;
			}

		}

	}
}
