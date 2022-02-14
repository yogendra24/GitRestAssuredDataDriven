package RestAssuredDataDriven.RestAssuredDataDrivenFW;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.apache.http.HttpStatus;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import util.ExcelUtility;
import util.UtilClass;

public class DataDrivenTest {
	RequestSpecification reqSpec= UtilClass.reqSpec;
	  static ResponseSpecification respSpec= new ResponseSpecBuilder().build().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON);
	public static void  main(String[] args) {
		String userDirectory = System.getProperty("user.dir");
		String excelFilePath = userDirectory+"\\src\\test\\java\\util\\SmartBytes_API_TestData.xlsx";
		String sheetName="CustomerAPI";
		List<List<String>>	excelData= ExcelUtility.readExcelData(excelFilePath, sheetName);
		
		String methodType="";
		String testCaseName="";
		String uri="";
		String contentType="";
		String ExpcontentType="";
		int respCode=0;
		String body="";
		double price=0;
		for (List<String> testData : excelData) {
			//for(String cellData: rowData) {
				System.out.println(testData.get(0)+"\t");
				 methodType=testData.get(0);
				 testCaseName=testData.get(1);
			      uri=testData.get(2);
				 contentType=testData.get(3);
				 body=testData.get(4);
				 ExpcontentType=testData.get(0);
				 ExpcontentType=testData.get(0);
				 respCode=(int)Double.parseDouble(testData.get(5));
				 if(methodType.equalsIgnoreCase("GET")) {					
					  given().
					  contentType(contentType).
					  get(uri).
					  then().extract().response().prettyPrint();
				}
				 if(methodType.equalsIgnoreCase("POST")) {					
					  given().
					  contentType(contentType).
					  body(body).
					  post(uri).
					  then().statusCode(respCode).extract().response().prettyPrint();
					  
				}

		}
		
}
}
