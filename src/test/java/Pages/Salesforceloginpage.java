package Pages;

import java.util.Hashtable;

import org.testng.Assert;
import com.salesforce_Test_base.salesforce_login_testbase;
import commonMethods.Commonmethods;

public class Salesforceloginpage extends salesforce_login_testbase  {
       
	public static void createAnAccount(Hashtable<String, String> Testdata) throws Exception {
		String Actual_title = driver.getTitle();

		Assert.assertEquals(Actual_title, "Professional Edition Free 30-Day Trial - Salesforce UK - Salesforce UK");
		
		passLogStatus("User has been redirected to the " + Actual_title + " Application.");
		
	Commonmethods.sendkeys("xFist_name", Testdata.get("First_Name"), "First Name");
	Commonmethods.sendkeys("xLast_name", Testdata.get("Last_Name"), "Last Name");
	Commonmethods.sendkeys("xTitle", Testdata.get("Tittle"), " Tittle name");
	Commonmethods.sendkeys("xEmail", Testdata.get("Email_ID"), "Email ID");
	Commonmethods.sendkeys("xphone", Testdata.get("Phone_numb"), "Phone NO");	
	
	
}
	
}