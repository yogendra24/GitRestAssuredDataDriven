package logs;

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

public class ReadEmployee {
	private static final Logger logger =LogManager.getLogger(ReadEmployee.class);
	RequestSpecification reqSpec= UtilClass.reqSpec;
	 ResponseSpecification respSpec= new ResponseSpecBuilder().build().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON);
	@BeforeClass
    public static void init() {
    	logger.info("Processof initialization");
		RestAssured.baseURI =util.UtilClass.BASE_URI;
    }

	  @Test
	  public void readEmp() {
		  
			 given().spec(reqSpec).
					get("/api/employee/list").then().spec(respSpec);
			 logger.info("read EMp method");
			// respone.prettyPrint();
		//	System.out.println(response);
}
	  
	  @Test
	  public void readEmp_withId() {
		  
			  given().spec(reqSpec).
					get("/api/employee/show/1").then().spec(respSpec);
			  logger.info("read EMp with method");
			// respone.prettyPrint();
		//	System.out.println(response);
}
}