package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	@Test
	public void test1() {

		// define base URL
		RestAssured.baseURI = "http://localhost:3000/";

		// Initialize request Object
		RequestSpecification request = RestAssured.given();
		// response collect and print
		Response response = request.get("employees");

		System.out.println(response.getBody().asString());
		
		//name and salary
		JsonPath jpath = response.jsonPath();
	    List<String> Names = jpath.get("name");
	    List<String> Salary = jpath.get("salary");
	    
	    for(int i =0;i<Names.size();i++) {
	    	System.out.println(Names.get(i) + " " + Salary.get(i));
	    }

	}
}
