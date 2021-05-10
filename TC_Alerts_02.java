package com.cropin.testscripts;

import org.testng.annotations.Test;

import com.cropin.baseutil.BaseTest;
import com.cropin.baseutil.InitializePages;
import com.cropin.commonutils.ExcelUtil;

public class TC_Alerts_02 extends BaseTest {
	/**
	 * Description: edit/search/delete alert
	 * @author Vinay Singh
	 * @throws Throwable 
	 */
	@Test
	public synchronized void testAddAlert() throws Throwable {
	
		/*fetching data from excel */
		
		String alert=ExcelUtil.getCellData(EXCELPATH, "Alerts", 2, 2);
		String advice=ExcelUtil.getCellData(EXCELPATH, "Alerts", 9, 1);
		String expectedEditAlert=ExcelUtil.getCellData(EXCELPATH, "Alerts", 9, 2);
		String expectedAlert=ExcelUtil.getCellData(EXCELPATH, "Alerts", 2, 2);
	    
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
	     
	     /*edit alert*/
	     pages.alertPage.editAlert(alert, advice);
	     
	     /*validate edit */
	     pages.alertPage.validateEditAlert(alert, expectedEditAlert);
	     
	     /*delete and search */
	     pages.alertPage.delete_And_Search(alert, alert);
	     
	     /*validate delete and search */
	     pages.alertPage.validateDelete(alert, expectedAlert);
	     
	}
}
