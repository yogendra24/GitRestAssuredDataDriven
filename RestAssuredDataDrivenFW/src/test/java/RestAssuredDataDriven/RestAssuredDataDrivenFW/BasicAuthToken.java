package RestAssuredDataDriven.RestAssuredDataDrivenFW;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BasicAuthToken {
	@BeforeClass
    public static void init() {
    	
		RestAssured.baseURI =util.UtilClass.BASE_URI;
    }

	  @Test
	  public void basicAuth() {
		  
			 Response respone= given().header("Authorization", "Basic YWRtaW46YWRtaW4=").
					get("/api/user/list").then().statusCode(200).extract().response();
			 respone.prettyPrint();
		//	System.out.println(response);
}
}
