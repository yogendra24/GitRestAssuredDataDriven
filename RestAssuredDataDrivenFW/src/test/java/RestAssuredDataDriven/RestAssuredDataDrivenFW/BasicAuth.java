package RestAssuredDataDriven.RestAssuredDataDrivenFW;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BasicAuth {
	@BeforeClass
    public static void init() {
    	
		RestAssured.baseURI =util.UtilClass.BASE_URI;
    }

	  @Test
	  public void basicAuth() {
		  
			 Response respone= given().auth().preemptive().basic("admin","admin").contentType(ContentType.JSON).
					get("/api/user/list").then().statusCode(200).extract().response();
			 respone.prettyPrint();
		//	System.out.println(response);
}
	  @Test
	  public void basicAuthInvalidCred() {
		  
			 Response respone= given().auth().preemptive().basic("admin11","admin").contentType(ContentType.JSON).
					get("/api/user/list").then().statusCode(401).extract().response();
			
		//	System.out.println(response);
}
}
