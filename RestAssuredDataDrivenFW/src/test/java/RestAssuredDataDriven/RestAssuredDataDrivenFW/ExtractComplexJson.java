package RestAssuredDataDriven.RestAssuredDataDrivenFW;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.path.json.JsonPath.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ExtractComplexJson {
	static String baseURI=util.UtilClass.BASE_URI;
	  @BeforeClass
	    public static void init() {
	    	
			RestAssured.baseURI =baseURI;
	    }
	  @Test
	  public void getUser() {
		  
			Response response=  given().accept(ContentType.JSON).contentType(ContentType.JSON).
					get("/api/test/medications/json").then().extract().response();
				System.out.println(response.prettyPrint());
				String strength= response.path("medications[0].betaBlocker[0].strength");
				System.out.println(strength);
			
				List<String> loc= from(response.asString()).get("labs.location");
				for(String location:loc) {
					System.out.println(location);
				}
				}
	  

}
	