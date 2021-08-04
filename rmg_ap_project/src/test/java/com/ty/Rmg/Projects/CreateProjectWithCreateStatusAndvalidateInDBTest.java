package com.ty.Rmg.Projects;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.POJOClass.Projectlibrery;
import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class CreateProjectWithCreateStatusAndvalidateInDBTest {
   @Test
   public void createProjectWithCreateStatusAndvalidateInDBTest() throws SQLException {
	   //Create Project Using 
	   Random veriabl = new Random();
	   int ran = veriabl.nextInt(200);
	   baseURI="http://localhost";
	   port=8084;
	Projectlibrery prolibrery = new Projectlibrery("IronMan", "Casino"+ran, "Completed", 20);
	   Response response = given()
			   .contentType(ContentType.JSON)
			   .body(prolibrery)
			   .when()
			   .post("addProject");
	   //Capture The Project Id
	   String firstProjectId = response.jsonPath().get("projectId");
	   System.out.println(firstProjectId);
	   //Verify the project id in the data base
	   //1step Register to data base
	      Driver driver = new Driver();
	      DriverManager.deregisterDriver(driver);
	    //Get Connection with the data base
	      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	      //Issue the Statment
	      Statement stat = conn.createStatement();
	      //Execute Query
	      ResultSet result = stat.executeQuery("select * from project");
	      String expdata = null;
	      while(result.next()) {
	    	  if(result.getString(1).equals(firstProjectId)) {
	    		  expdata=result.getString(1);
	    		  System.out.println("project id is succsessfully verified in database");
	    		  break;
	    	  }
	      }
	      Assert.assertEquals(firstProjectId, expdata);
	      //close the connection
	      
	      
	      
   }
   
   
}
