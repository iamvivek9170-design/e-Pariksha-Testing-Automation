package tests.regression;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTest;
import constants.FrameworkConstants;
import pages.AdminDashboardPage;
import pages.LoginPage;

public class AuthorizationRegressionTest extends BaseTest {

	LoginPage login;
	AdminDashboardPage admidash;
 
	@Test
	public void S_TS01_TC14_verifyStudentCannotAccessAdminDashboard() {

		login = new LoginPage();
		admidash = new AdminDashboardPage();

		login.studentlogin();
		
		login.openUrl(FrameworkConstants.ADMIN_DASHBOARD_URL);
		assertFalse(login.verifyAdminDashboard(),"BUG: Student can view Admin Dashboard details!");	
		}
 
	@Test
	public void S_TS01_TC15_verifyStudentCannotAccessCoordinatorDashboard() {

		login = new LoginPage();
		login.studentlogin();
		login.openUrl(FrameworkConstants.COORDINATOR_DASHBOARD_URL);
		assertTrue(login.verifyLoginPage(), "Student should not access Coordinator Dashboard!");
	}
 
	@Test
	public void C_TS08_TC017_verifyCoordinatorCantnotAccessAdminDashboard() {
 
		login = new LoginPage();
		login.coordinatorlogin();
		login.openUrl(FrameworkConstants.ADMIN_DASHBOARD_URL);
		assertFalse(login.verifyAdminDashboard(),"BUG: Coordinator can view Admin Dashboard details!");	}

	@Test
	public void A_TS01_TC17_verifyAdminCannotAccessCoordinatorDashboardByUrl() {

		login = new LoginPage();
		login.adminlogin();
		login.openUrl(FrameworkConstants.COORDINATOR_DASHBOARD_URL);
		assertFalse(login.verifyCoordinatorDashboard(), "Admin should not access Corrdinator Dashboard by Url!");
	}
 
	@Test   
	public void A_TS04_TC21_verifyAdminCanAccessCoordinatorDashboardBySwitch() {

		login = new LoginPage();
		admidash = new AdminDashboardPage();
		login.adminlogin();
		admidash.home();
		admidash.switchToUser();
		assertTrue(login.verifyCoordinatorDashboard(), "Admin should redirect to Corrdinator Dashboard by Switch!");
	}

}
