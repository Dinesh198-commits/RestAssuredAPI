package restAPIBDD;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
	@Test
	public void test1() {
		Map<String,Object> Mapobj = new HashMap<String,Object>();
		Mapobj.put("name", "Raman");
		Mapobj.put("salary", "50000");
		RestAssured
		//part of given
		.given().baseUri("http://localhost:3000/")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(Mapobj)
		//part of when
		.when()
		.put("employees/create")
		//Part of then
		.then()
		.log()
		.all()
		.statusCode(200)
		.body("name",Matchers.equalTo("Raman"));}
		

}
