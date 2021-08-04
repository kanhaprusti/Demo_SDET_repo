package RmgApi_BDD;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class DeleteProject {
	@Test
	public void deleteproject() {
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_204")
		.then()
		.log().all()
		.assertThat().statusCode(200);

	}
}
