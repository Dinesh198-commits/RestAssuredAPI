package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestWithParameter {
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://localhost:3000/";		
	    RequestSpecification request = RestAssured.given();
	    Response response = request.param("id","2").get("employees");
	    System.out.println(response.getBody().asString());
	    int response_code =response.getStatusCode();
	    Assert.assertEquals(200,response_code);
	    System.out.println(response.headers().toString());
	    String response_body = response.getBody().asString();
	    Assert.assertTrue(response_body.contains("David"));
	    
	    JsonPath jpath = response.jsonPath();
	    List<String> Names = jpath.get("name");
	    System.out.println("The name is " + Names.get(0)); 
	    Assert.assertEquals(Names.get(0),"David");
	    
	    
	    
	    
	}

}
