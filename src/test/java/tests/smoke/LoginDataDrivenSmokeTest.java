package tests.smoke;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelReader;
import utils.User;

public class LoginDataDrivenSmokeTest extends BaseTest {

	LoginPage login;

	//////////////////////////
	// ******* Admin *******//
	/////////////////////////
@DataProvider(name = "adminExcelData")
	public Object[][] adminData() {

	    Object adminDetail[][] = new Object[1][2];
	    User user = ExcelReader.getUserByRoleAndIndex("Admin", 1);

	    adminDetail[0][0] = user.getUsername();
	    adminDetail[0][1] = user.getPassword();

	    return adminDetail;
	}


	@Test(dataProvider = "adminExcelData")
	public void verifyAdminLoginWithMultipleUsers(String userid, String pass) {
		login = new LoginPage();
		login.loginMethod(userid, pass);
		assertEquals(login.verifyAdminDashboard(), true);
		login.logoutMethod();

		
//		if (login.verifyAdminDashboard()) {
//			assertEquals(login.verifyAdminDashboard(), true);
//			login.logoutMethod();
//		} else {
//			assertEquals(login.verifyLoginFailer(), true);
//		}
	}

	////////////////////////////////
	// ******* Coordinator *******//
	///////////////////////////////

	@DataProvider(name = "coordinatorExcelData")
	public Object[][] coordinatorData() {
		Object coordinaterdetail[][] = new Object[2][2];
		for (int i = 0; i < 2; i++) {
			User user = ExcelReader.getUserByRoleAndIndex("Coordinator", i + 1);
			coordinaterdetail[i][0] = user.getUsername();
			coordinaterdetail[i][1] = user.getPassword();
		}
		return coordinaterdetail;
	}

	@Test(dataProvider = "coordinatorExcelData")
	public void verifyCoordinatorLoginWithMultipleUsers(String userId, String pass) {
		login = new LoginPage();
		login.loginMethod(userId, pass);
		assertEquals(login.verifyCoordinatorDashboard(), true);
		login.logoutMethod();

		
//		if (login.verifyCoordinatorDashboard()) {
//			assertEquals(login.verifyCoordinatorDashboard(), true);
//			login.logoutMethod();
//		} else {
//			assertEquals(login.verifyLoginFailer(), true);
//		}
	}

	////////////////////////////
	// ******* Student *******//
	///////////////////////////

	@DataProvider(name = "studenExcelData")
	public Object[][] studentData() {
		Object studentDetail[][] = new Object[7][2];
		for (int i = 0; i < 7; i++) {
			User user = ExcelReader.getUserByRoleAndIndex("Student", i + 1);
			studentDetail[i][0] = user.getUsername();
			studentDetail[i][1] = user.getPassword();
		}
		return studentDetail;
	}

	@Test(dataProvider = "studenExcelData")
	public void verifyStudentLoginWithMultipleUsers(String userId, String pass) {
		login = new LoginPage();
		login.loginMethod(userId, pass);
		assertEquals(login.verifyStudentDashboard(), true);
		login.logoutMethod();

//		if (login.verifyStudentDashboard()) {
//			assertEquals(login.verifyStudentDashboard(), true);
//			login.logoutMethod();
//		} else {
//			assertEquals(login.verifyLoginFailer(), true);
//		}
	}

}
