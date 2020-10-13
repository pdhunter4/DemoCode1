package excelDriven.DataDriven;

import org.testng.annotations.Test;

public class LoginTest {
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="getLoginDataFromExcel",priority=1)
	public void excelLoginTest(String username,String password) {
		System.out.println(username + " " + password);
	}
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="getLoginDataFromJSON",priority=2)
	public void jsonLoginTest(String username,String password) {
		System.out.println(username + " " + password);
	}
	
}
