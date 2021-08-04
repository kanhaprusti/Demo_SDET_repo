package ProjectUsingPojoClass;

import org.testng.annotations.Test;

import com.comcast.POJOClass.Projectlibrery;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatProjectUsingPojoClass {
    @Test
   public void createProjectUsingPojoclass(){
    	Projectlibrery proj = new Projectlibrery("TestYantra", "medusa2.0", "Completed", 15);
    	given()
    	.contentType(ContentType.JSON)
    	.body(proj)
    	.when()
    	.post("http://localhost:8084/addProject")
    	.then()
    	.log().all()
    	.assertThat().contentType(ContentType.JSON)
    	.assertThat().statusCode(201);
    	
    }
}
