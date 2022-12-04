package restAPI;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchRequest {
	@Test
	public void test1() {
		File datafile = new File("data1.json");
		RestAssured.baseURI = "http://localhost:3000/";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(datafile).patch("employees/15");
		System.out.println(response.getBody().asString());}
		

}
