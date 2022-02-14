package RestAssuredDataDriven.RestAssuredDataDrivenFW;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;

import java.util.List;
import static io.restassured.path.xml.XmlPath.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ExtractComplexSXML {
	static String baseURI=util.UtilClass.BASE_URI;
	 
	  @Test
	  public void getUser() {
		  
			Response response=  get("http://localhost:8080/api/customer/list/xml");
				response.prettyPrint();
			Integer  count=	with(response.asString()).get("ArrayList.item.size()");
			System.out.println(count);
				/*
				 * String strength= response.path("medications[0].betaBlocker[0].strength");
				 * System.out.println(strength);
				 * 
				 * List<String> loc= from(response.asString()).get("labs.location"); for(String
				 * location:loc) { System.out.println(location); }
				 */
				}
	  


	

}
