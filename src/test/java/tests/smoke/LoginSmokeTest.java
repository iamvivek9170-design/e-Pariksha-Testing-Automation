package tests.smoke;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelReader;
import utils.User;

public class LoginSmokeTest extends BaseTest {

	LoginPage login;

	
    //////////////////////////
	// ******* Admin *******//
	///////////////////////// 

	@DataProvider(name = "adminExcelData")
	public Object[][] adminData() {

		Object adminDetail[][] = new Object[2][2];

		for (int i = 0; i < 2; i++) {
			User user = ExcelReader.getUserByRoleAndIndex("Admin", i + 1);

			adminDetail[i][0] = user.getUsername();
			adminDetail[i][1] = user.getPassword();
		}
		return adminDetail;
	}

	@Test(dataProvider = "adminExcelData")
	public void verifyAdminLogin(String userid, String pass) {
		login = new LoginPage();
		login.loginMethod(userid, pass);

		if (login.verifyAdminDashboard()) {

			assertEquals(login.verifyAdminDashboard(), true);
			login.logoutMethod();
		} else {
			assertEquals(login.verifyLoginFailer(), true);
		}
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
	public void verifyCoordinatorLogin(String userId, String pass) {
		login = new LoginPage();

		login.loginMethod(userId, pass);

		if (login.verifyCoordinatorDashboard()) {
			assertEquals(login.verifyCoordinatorDashboard(), true);
			login.logoutMethod();
		} else {

			assertEquals(login.verifyLoginFailer(), true);
		}

	}

	
	////////////////////////////
	// ******* Student *******//
	///////////////////////////

	@DataProvider(name = "studenExcelData")
	public Object[][] studentData() {

		Object studentDetail[][] = new Object[2][2];

		for (int i = 0; i < 2; i++) {
			User user = ExcelReader.getUserByRoleAndIndex("Student", i + 1);

			studentDetail[i][0] = user.getUsername();
			studentDetail[i][1] = user.getPassword();
		}
		return studentDetail;
	}

	@Test(dataProvider = "studenExcelData")
	public void verifyStudentLogin(String userId, String pass) {

		login = new LoginPage();
		login.loginMethod(userId, pass);

		if (login.verifyStudentDashboard()) {
			assertEquals(login.verifyStudentDashboard(), true);
			login.logoutMethod();
  
		} else {
			// if failed to login
			assertEquals(login.verifyLoginFailer(), true);

		}

	}

}
