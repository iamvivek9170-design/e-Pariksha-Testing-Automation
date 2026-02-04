package tests.regression;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AdminCoursesPage;
import pages.AdminDashboardPage;
import pages.AdminResultPage;
import pages.AdminUserManagementPage;
import pages.LoginPage;

public class AdminFunctionTest extends BaseTest {

	LoginPage login;
	AdminDashboardPage admindash;
	AdminUserManagementPage newUser;
	AdminCoursesPage courspa;
	AdminResultPage admrelt;
 
	@Test
	public void A_TS01_TC01_verfifyAdminLoginSuccessfully() {
		login = new LoginPage();

		login.adminlogin();
		login.verifyAdminDashboard();
		login.verifyAdminDashboard();

		assertEquals(login.verifyAdminDashboard(), true);
	}

//////User test 
	@Test
	public void A_TS04_TC01_verifyAddingNewUser() {
		login = new LoginPage();
		newUser = new AdminUserManagementPage();
		admindash = new AdminDashboardPage();

		login.adminlogin();
		admindash.users();
		newUser.addNewUser();

		assertEquals(newUser.verifyMessage(), true);
	}

	@Test
	public void A_TS04_TC011_verifyUpdatingDetailOfExstingUser() {
		login = new LoginPage();
		newUser = new AdminUserManagementPage();
		admindash = new AdminDashboardPage();

		login.adminlogin();
		admindash.users();

		newUser.editUserDeatil();

		assertEquals(newUser.verifyMessage(), true);

	}

//	@Test
//	public void A_TS04_TC23_verifyResetPasswordForExistingUser() {
//		login = new LoginPage();
//		admindash = new AdminDashboardPage();
//		newUser = new AdminUserManagementPage();
//
//		login.adminlogin();
//		admindash.users();
//
//		newUser.resetPasswordOfUser();
//		assertEquals(newUser.verifyresetPasswordOfUser(), true);
//	}

//////Course test 

	@Test
	public void A_TS05_TC01_verifyAddingNewCourse() {
		login = new LoginPage();
		admindash = new AdminDashboardPage();
		courspa = new AdminCoursesPage();

		login.adminlogin();
		admindash.courses();
		courspa.addnewCourse();
		assertEquals(courspa.verifyaddnewCourse(), true);

	}

	@Test
	public void A_TS05_TC12_verifyAddingNewModule() {
		login = new LoginPage();
		admindash = new AdminDashboardPage();
		courspa = new AdminCoursesPage();

		login.adminlogin();
		admindash.courses();
		courspa.addingModuleToExstingCourse();
		assertEquals(courspa.verfiynewModuleAdded(), true);

	}

	@Test
	public void A_TS05_TC10_verifyUpdatingOFCourse() {
		login = new LoginPage();
		admindash = new AdminDashboardPage();
		courspa = new AdminCoursesPage();

		login.adminlogin();
		admindash.courses();
		courspa.updateingDeatilOfCourse();
//		assertEquals(courspa.verfiynewModuleAdded(), true);

	}

	@Test
	public void A_TS04_TC21_verfiyAdminCanSwitcToCoordinaor() {
		login = new LoginPage();
		admindash = new AdminDashboardPage();

		login.adminlogin();
		admindash.home();
		admindash.switchToUser();
		assertEquals(login.verifyCoordinatorDashboard(), true);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// result visible

	@Test
	public void A_TS06_TC07_verfiyResultVisible() {
		login = new LoginPage();
		admindash = new AdminDashboardPage();
		admrelt = new AdminResultPage();

		login.adminlogin();
		admindash.results();
		admrelt.showResultOfStudent();
		assertEquals(admrelt.verifyResultVisibleToAdmin(), true);

	}

}
