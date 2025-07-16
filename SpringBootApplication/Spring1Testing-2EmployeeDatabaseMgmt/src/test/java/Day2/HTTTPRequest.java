package Day2;

import org.springframework.http.HttpStatusCode;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

public class HTTTPRequest {
	
	int empid=3;
	
	@Test(priority=1)
	public void getUser()
	{
		given()
		
		.when()
			.get("http://localhost:8080/Employees")
		.then()
			.statusCode(200)
			.log().all();
	}
	@Test(priority=2)
	public void createUser()
	{
		HashMap empData = new HashMap();
		empData.put("empName", "Shri");
		empData.put("empAge", 42);
		// empid =
				 given()
				.contentType("application/json")
				.body(empData)
			.when()
				.post("http://localhost:8080/Employees/addEmployee")
				//.jsonPath().getInt("empId");
			.then()
				.statusCode(200)
				.log().all();
		
		System.out.print("\n Response \n");
		getUser();
		
	}
	
	@Test(priority=3)
	public void updateUser()
	{
		HashMap empData = new HashMap();
		empData.put("empName", "Tulsi");
		empData.put("empAge", 35);
		
		given()
			.contentType("application/json")
			.body(empData)
		.when()
			.put("http://localhost:8080/Employees/updateEmployee/"+empid)
		.then()
		//	.statusCode(200)
			.log().all();
		
		
	}
	
	@Test(priority=4)
	public void deleteUser()
	{
		given()
		.when()
			.delete("http://localhost:8080/Employees/deleteEmployee/"+7)
		.then()
			.statusCode(200)
			.log().all();
		
		
	}
	
	

}
