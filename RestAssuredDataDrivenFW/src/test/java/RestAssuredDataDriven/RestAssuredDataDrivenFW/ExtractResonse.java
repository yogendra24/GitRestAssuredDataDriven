package RestAssuredDataDriven.RestAssuredDataDrivenFW;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ExtractResonse {
	static String baseURI=util.UtilClass.BASE_URI;
	  @BeforeClass
	    public static void init() {
	    	
			RestAssured.baseURI =baseURI;
	    }
	  @Test
	  public void getUser() {
		 // RestAssured.baseURI = "http://localhost:8080/GET/api/customer/show?id=250";
		Response response=  given().accept(ContentType.JSON).contentType(ContentType.JSON).
			get("/api/test/books/json").then().extract().response();
		System.out.println(response.asString());
		String country= response.path("books[1].country");
		System.out.println(country);
		Integer bookSize= response.path("books.size()");
		System.out.println(bookSize);
	  }
}
