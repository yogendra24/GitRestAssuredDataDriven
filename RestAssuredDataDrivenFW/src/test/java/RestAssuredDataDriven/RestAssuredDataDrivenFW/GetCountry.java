package RestAssuredDataDriven.RestAssuredDataDrivenFW;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import logs.TestLog4J;
import util.UtilClass;
import static org.hamcrest.Matchers.*;

public class GetCountry {
	
	RequestSpecification reqSpec= UtilClass.reqSpec;
	 ResponseSpecification respSpec= new ResponseSpecBuilder().build().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON);
	@BeforeClass
    public static void init() {
    	
		RestAssured.baseURI =util.UtilClass.BASE_URI;
    }

	  @Test
	  public void readEmp() {
		  
			 given().pathParams("id", "IN").
					get("/api/country/get/iso2code/{id}").then().spec(respSpec).body("RestResponse.result.name", equalTo("India1"));
			
			// respone.prettyPrint();
		//	System.out.println(response);
}
}