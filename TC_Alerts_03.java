package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.DataGenerators;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Alerts_03 extends BaseTest{
	
	public String planName="Plan"+ DataGenerators.getRandomString();
	public String writeAlertName=ExcelUtil.writeDataIntoExcel(EXCELPATH, "Alerts",15,1,planName);
	/**
	 * Description: edit/search/delete alert
	 * @author Vinay Singh
	 * @throws Throwable 
	 */
	@Test
	public synchronized void testAddAlert() throws Throwable {
	
		/*fetching data from excel */
		
		String alert=ExcelUtil.getCellData(EXCELPATH, "Alerts", 2, 2);
		
		String expectedPlanType=ExcelUtil.getCellData(EXCELPATH, "PlanType", 2, 1);
		String expectedCA=ExcelUtil.getCellData(EXCELPATH, "Alerts", 15, 2);
		String expectedPlan=planName;
		
		
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
	     
	     /*add plan */
	     pages.alertPage.addPlanAlert(alert, planName, expectedPlanType, expectedCA);
	     
	     /*validate plan*/
	     pages.alertPage.validatePlan(planName, expectedPlan);
	     
	     
	}

}
