package util;

import org.apache.http.HttpStatus;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class UtilClass {

	
		// TODO Auto-generated method stub
		public static final String BASE_URI="http://localhost:8080/";

		public static final RequestSpecification reqSpec= new RequestSpecBuilder().build().auth().preemptive().basic("admin","admin");
		public final ResponseSpecification respSpec= new ResponseSpecBuilder().build().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON);
	

}
