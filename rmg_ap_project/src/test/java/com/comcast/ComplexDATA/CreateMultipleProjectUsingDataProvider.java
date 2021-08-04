package com.comcast.ComplexDATA;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.POJOClass.Projectlibrery;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateMultipleProjectUsingDataProvider {
	@Test(dataProvider="getdata")
	public void createMultipleProject(String createdBy, String projectName, int teamSize) {
		baseURI="http://localhost";
		port=8084;
		Projectlibrery proj = new Projectlibrery(createdBy, projectName, "completed", teamSize);
		given()
		.contentType(ContentType.JSON)
		.body(proj)
		.when()
		.post("/addProject")
		.then()
		.log().all();
	}
	@DataProvider
	public Object [][] getdata(){
		Object[][] obj=new Object[5][3];
		obj[0][0]="Chaitara1";
		obj[0][1]="TestY22";
		obj[0][2]=14;

		obj[1][0]="Adarsh";
		obj[1][1]="TestY551";
		obj[1][2]=15;

		obj[2][0]="deepak2";
		obj[2][1]="TestY255";
		obj[2][2]=12;

		obj[3][0]="Ranbir";
		obj[3][1]="TestY388";
		obj[3][2]=16;

		obj[4][0]="kareena";
		obj[4][1]="TestY664";
		obj[4][2]=19;
		return obj;
	}

}
