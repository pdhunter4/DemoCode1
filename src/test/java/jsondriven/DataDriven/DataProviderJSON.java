package jsondriven.DataDriven;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

public class DataProviderJSON {
	
	
	@DataProvider
	public Object[] getJSONData() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\testdata\\LoginData.json");
		JSONObject jsonObject = (JSONObject)jsonParser.parse(reader);
		JSONArray jsonArray = (JSONArray)jsonObject.get("loginData");
		Object[] data = new Object[jsonArray.size()];
		Integer index = 0;
		for(Object obj : jsonArray.toArray()) {
			JSONObject userLogin = (JSONObject)obj;
			data[index++] = (String)userLogin.get("username") + "," + userLogin.get("password");
		}
		return data;
	}

}
