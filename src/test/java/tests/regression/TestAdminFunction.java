package tests.regression;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AdminDashboardPage;
import pages.AdminUserManagementPage;
import pages.LoginPage;

public class TestAdminFunction extends BaseTest {
	LoginPage login;
	AdminDashboardPage admindash;
	AdminUserManagementPage newUser;

	@Test
	public void verfifyAdminLoginSuccessfully() {
		login = new LoginPage();

		login.adminlogin();
		login.verifyAdminDashboard();
//		call verify method for assertion 

	}

	@Test
	public void verifyAddingNewUser() {
		login = new LoginPage();
		newUser = new AdminUserManagementPage();
		admindash = new AdminDashboardPage();

		login.adminlogin();
		admindash.users();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newUser.addNewUser();
		

//	call verify method for assertion 

	}

	
	@Test // need update 
	public void verifyUpdatingDetailOfExstingUser() {
		login = new LoginPage();
		newUser = new AdminUserManagementPage();
		admindash = new AdminDashboardPage();

		login.adminlogin();
		admindash.users();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newUser.editUserDeatil();
		
//		call verify method for assertion 
	
	}
	
	@Test // need update can select user
	public void verifyResetPasswordForExistingUser() {
		login = new LoginPage();
		newUser = new AdminUserManagementPage();
		admindash = new AdminDashboardPage();

		login.adminlogin();
		admindash.users();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newUser.resetPasswordOfUser();

//	call verify method for assertion 
	}

	
}
