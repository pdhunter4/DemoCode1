package jsondriven.DataDriven;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import excelDriven.DataDriven.DataProviders;
import pojobuilder.RegistrationData;

public class RegistrationTest {
	

	@Test(dataProviderClass = DataProviders.class,dataProvider="getRegistrationDataFromJSON",priority=1)
	public void jsonRegistrationTest(RegistrationData registrationData) throws FileNotFoundException {
		System.out.println(registrationData);
	}


}
