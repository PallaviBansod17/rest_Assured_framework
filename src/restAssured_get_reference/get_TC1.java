package restAssured_get_reference;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

public class get_TC1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declare base URI
		RestAssured.baseURI="https://reqres.in/";
		
		//Configure the request body and resource
		String getresponsebody =given().header("Content-Type","application/json").when().get("api/users?page=2").
				then().extract().response().asString();
		System.out.println(getresponsebody);
		
		//create json path object
		JsonPath obj=new JsonPath(getresponsebody);
		//find length of array
		int count=obj.getInt("data.size()");
		System.out.println("length of array:" +count);
		//extract responsebody parameter
		int id[]= {7,8,9,10,11,12};
		String email[]= {"michael.lawson@reqres.in","lindsay.ferguson@reqres.in","tobias.funke@reqres.in","byron.fields@reqres.in","george.edwards@reqres.in","rachel.howell@reqres.in"};
		String first_name[]={"Michael","Lindsay","Tobias","Byron","George","Rachel"};
		String last_name[]= {"Lawson","Ferguson","Funke", "Fields","Edwards","Howell"};
		String avatar[]= {"https://reqres.in/img/faces/7-image.jpg","https://reqres.in/img/faces/8-image.jpg","https://reqres.in/img/faces/9-image.jpg","https://reqres.in/img/faces/10-image.jpg","https://reqres.in/img/faces/11-image.jpg", "https://reqres.in/img/faces/12-image.jpg"};
		for(int i = 0; i<count; i++) {
		//extract response body parameter
		int re_id=id[i];
		String re_email=email[i];
		String re_fname=first_name[i];
		String re_lname=last_name[i];
		String re_avatar=avatar[i];
		int res_id=obj.getInt("data["+i+"].id");
		System.out.println(res_id);
		String res_email=obj.getString("data["+i+"].email");
		System.out.println(res_email);
		String res_Fname=obj.getString("data["+i+"].first_name");
		System.out.println(res_Fname);
		String res_Lname=obj.getString("data["+i+"].last_name");
		System.out.println(res_Lname);
		String res_Avatar=obj.getString("data["+i+"].avatar");
		System.out.println(res_Avatar);
		//validate response body parameters
		Assert.assertEquals(res_id, re_id);
		Assert.assertEquals(res_email, re_email);
		Assert.assertEquals(res_Fname, re_fname);
		Assert.assertEquals(res_Lname, re_lname);
		Assert.assertEquals(res_Avatar, re_avatar);
		
		}

	}

}
