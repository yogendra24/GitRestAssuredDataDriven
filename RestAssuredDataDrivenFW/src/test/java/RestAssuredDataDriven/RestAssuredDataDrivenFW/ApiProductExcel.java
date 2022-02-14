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

public class ApiProductExcel {
	RequestSpecification reqSpec= UtilClass.reqSpec;
	 ResponseSpecification respSpec= new ResponseSpecBuilder().build().statusCode(HttpStatus.SC_OK).contentType(ContentType.JSON);
	public static void  main(String[] args) {
	String userDirectory = System.getProperty("user.dir");
	String excelFilePath = userDirectory+"\\src\\test\\java\\util\\SmartBytes_API_TestData.xlsx";
	String sheetName="Products";
	List<List<String>>	excelData= ExcelUtility.readExcelData(excelFilePath, sheetName);
	
	String product="";
	String productID="";
	double price=0;
	for (List<String> rowData : excelData) {
		//for(String cellData: rowData) {
			System.out.println(rowData.get(0)+"\t");
			product=	rowData.get(0);
					productID=	rowData.get(1);
							price=Double.parseDouble(rowData.get(2));
							
						
					//	  logger.info("read EMp with method");
							 String bodyProduct="{\r\n"
							 		+ "  \"description\": \""+product+"\",\r\n"
							 		+ "  \"price\": "+price+",\r\n"
							 		+ "  \"productId\": \""+productID+"\"\r\n"
							 		+ "}";
							 
							 given().contentType(ContentType.JSON).body(bodyProduct).post("http://localhost:8080/api/product").then().extract().response().prettyPrint();			
//}
	}

}
}
