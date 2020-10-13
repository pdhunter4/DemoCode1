package excelDriven.DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import pojobuilder.RegistrationData;

public class DataProviders {
	
	
	@DataProvider
	public static Object[][] getLoginDataFromExcel() throws IOException {
		DataFormatter formatter = new DataFormatter();
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") +
									"\\src\\main\\java\\testdata\\RSATestData.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("LoginData");
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();
		
		Object[][] loginData = new Object[rowCount-1][columnCount];
		
		for(int i=0;i<rowCount-1;i++) {
			row = sheet.getRow(i+1);
			for(int j=0;j<columnCount;j++) {
				XSSFCell cell = row.getCell(j);
				loginData[i][j] = formatter.formatCellValue(cell);
			}
		}

		book.close();
		return loginData;
	}
	
	@DataProvider
	public static Object[][] getLoginDataFromJSON() throws FileNotFoundException, IOException, ParseException {
		int counter = 0;
		JSONParser jsonParse = new JSONParser();
		try(FileReader file = new FileReader(System.getProperty("user.dir") 
									+ "\\src\\main\\java\\testdata\\LoginData.json")){
			
			JSONObject object = (JSONObject)jsonParse.parse(file);
			JSONArray jsonArray = (JSONArray)object.get("loginData");
			Object[][] loginData = new Object[jsonArray.size()][2];
			for(Object loginObject : jsonArray.toArray()) {
				JSONObject login = (JSONObject)loginObject;
				loginData[counter][0] = login.get("username"); 
				loginData[counter][1] = login.get("password");
				counter++;
			}
			return loginData;
		}
	}
	
	
	@DataProvider
	public static Object[][] getRegistrationDataFromJSON() throws FileNotFoundException {
		
		JsonElement jsonData = JsonParser.parseReader((new FileReader(System.getProperty("user.dir") +
				"\\src\\main\\java\\testdata\\RegistrationData.json")));
        JsonElement dataSet = jsonData.getAsJsonObject().get("RegistrationData");
        List<RegistrationData> testData = new Gson().fromJson(dataSet, new TypeToken<List<RegistrationData>>() {}.getType());
        Object[][] returnValue = new Object[testData.size()][1];
        int index = 0;
        for (Object[] each : returnValue) {
            each[0] = testData.get(index++);
        }
        return returnValue;
	}
}
