package util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadDataFromExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String userDirectory = System.getProperty("user.dir");
		String excelFilePath = userDirectory+"\\src\\test\\java\\util\\SmartBytes_API_TestData.xlsx";
		String sheetName="Products";
		List<List<String>>	excelData= ExcelUtility.readExcelData(excelFilePath, sheetName);
		
		for (List<String> rowData : excelData) {
			//for(String cellData: rowData) {
				System.out.println(rowData.get(0)+"\t");
	//}
		}
	}
}

