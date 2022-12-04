package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {
	@Test
	public void test1() {
		Map<String,Object> Mapobj = new HashMap<String,Object>();
		Mapobj.put("name", "Rohit");
		Mapobj.put("salary", "50000");
		RestAssured.baseURI = "http://localhost:3000/";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(Mapobj).put("employees/2");
		System.out.println(response.getBody().asString());
		int response_code = response.getStatusCode();
		Assert.assertEquals(200, response_code);}

}
