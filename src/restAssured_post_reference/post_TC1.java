package restAssured_post_reference;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.time.LocalDate;

import org.testng.Assert;

public class post_TC1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declare base URI
		RestAssured.baseURI="https://reqres.in/";
		
		//Configure the request body and resource
		String postresponsebody =given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").when().post("/api/users").then().extract().response().asString();
		System.out.println(postresponsebody);
		
		//create json path object to extract response body parameters
				JsonPath jsp = new JsonPath(postresponsebody);
		
		//extract response body parameters
		String res_name=jsp.getString("name");
		System.out.println(res_name);
		String res_job=jsp.getString("job");
		System.out.println(res_job);
		String res_createdAt=jsp.getString("createdAt");
		String res_date=res_createdAt.substring(0,10);
		System.out.println(res_date);
		
		//current date
		String current_date = LocalDate.now().toString();
		System.out.println(current_date);
		
		//validate response body parameters
		Assert.assertEquals(res_name,"morpheus");
		Assert.assertEquals(res_job,"leader");
		Assert.assertEquals(res_date,current_date);
		
	}

}
