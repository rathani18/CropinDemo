package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.DataGenerators;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Alerts_01 extends BaseTest{
	
	/*Data generators*/
	public String alertName="Alert"+ DataGenerators.getRandomString();
	public String writeAlertName=ExcelUtil.writeDataIntoExcel(EXCELPATH, "Alerts",2,2,alertName);
	
	public static String[] alertType={"Compliance","Disease","Accidents","Natural Calamity","Other"};
	public static String expectedAlertType=DataGenerators.getRandom(alertType);
	
	public static String[] radio={"Email","APP","BOTH"};
	public static String expectedradio=DataGenerators.getRandom(radio);
	
	/**
	 * Descriptio: add alert
	 * @author Vinay Singh
	 */
	
	@Test
	public synchronized void testAddAlert() throws Throwable {
	
		/*fetching data from excel */
		String cropScroll=ExcelUtil.getCellData(EXCELPATH, "Crop", 2, 2);
		String child=ExcelUtil.getCellData(EXCELPATH, "Crop", 2, 2);
		String sub_child=ExcelUtil.getCellData(EXCELPATH, "Crop", 2, 3);
		
		String expectedURL=ExcelUtil.getCellData(EXCELPATH, "Alerts", 2,1);
		String alert=alertName;
		String expectedAlertName=alertName;
		String advice = "Advice for this alert "+alertName;
		
	    
	    /*creating object of Initialize Pages */
	    InitializePages pages = new InitializePages(driver, WebActionUtil, ETO);
	
         /* navigate to login page  */
	    pages.companyDomainPage.continueToApplication(companyDomain);
			
	    /*navigate to home page  */
	    pages.loginPage.signToApplication(userName, password);
	    
	    Thread.sleep(6000);
			
	     /*  navigate to Configuration page */                                  
	     pages.homePage.navigateToConfiguration();
	     
	     /*navigate to alert page*/
	     pages.configPage.navigateToAlerts();
	     
	     /*add alert*/
	     pages.alertPage.addAlert(alertName, expectedAlertType,cropScroll, child,sub_child, expectedradio, advice);
	      
	     /*validate URL*/
	     pages.alertPage.validateAlertURL(expectedURL);
	     
	     /*validate Alert is created or not */
	     pages.alertPage.validateAlert(alert, expectedAlertName);
	   
	     
	}

}
