package RestAssuredDataDriven.RestAssuredDataDrivenFW;



import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class AppTest {
    static String baseURI=util.UtilClass.BASE_URI;
    
    @BeforeClass
    public static void init() {
    	RestAssured.baseURI =baseURI;
    }
  @Test
  public void getUser() {
	 // RestAssured.baseURI = "http://localhost:8080/GET/api/customer/show?id=250";
	  given().accept(ContentType.JSON).contentType(ContentType.JSON).queryParam("id","481").
		get("/api/customer/show").then().statusCode(HttpStatus.SC_OK).body("firstName", equalTo("Deonna"));
  }
  @Test
  public void createUser() {
	 // RestAssured.baseURI = "http://localhost:8080/GET/api/customer/show?id=250";
	Response response=  given().accept(ContentType.JSON).contentType(ContentType.JSON).body("{\r\n"
	  		+ "    \"firstName\": \"Yog\",\r\n"
	  		+ "    \"lastName\": \"Londge\",\r\n"
	  		+ "    \"city\": \"Southfield\",\r\n"
	  		+ "    \"county\": \"Oakland\",\r\n"
	  		+ "    \"state\": \"MI\",\r\n"
	  		+ "    \"zip\": \"48075\",\r\n"
	  		+ "    \"phone1\": \"123-456-789\",\r\n"
	  		+ "    \"phone2\": \"123-456-789\",\r\n"
	  		+ "    \"email\": \"DeonnaKippley@smartbytes.com\",\r\n"
	  		+ "    \"web\": \"http://v-logics.com\",\r\n"
	  		+ "    \"id\": 554\r\n"
	  		+ "}").
		post("/api/customer/add").then().statusCode(HttpStatus.SC_CREATED).extract().response();
	String coockie=response.getCookie("new_customer_id");
	System.out.println("customer id:"+ coockie);
  }
}
