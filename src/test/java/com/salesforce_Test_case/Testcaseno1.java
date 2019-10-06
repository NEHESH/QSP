package com.salesforce_Test_case;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.salesforce_Test_base.salesforce_login_testbase;

import Pages.Salesforceloginpage;

public class Testcaseno1 extends salesforce_login_testbase{
	
	@Test(dataProvider="Data_Collections")
	public static void login(Hashtable<String, String> Testdata) throws Exception {
	
		Salesforceloginpage.createAnAccount(Testdata);
	}
}
