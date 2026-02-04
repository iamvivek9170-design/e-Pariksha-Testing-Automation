package tests.sanity;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class SanitySuiteTest extends BaseTest {

	LoginPage login;

	@Test
	public void verifyAdminSanity() {

		login = new LoginPage();

		login.adminlogin();
		assertTrue(login.verifyAdminDashboard(), "Admin Sanity Failed: Dashboard not visible");

		login.logoutMethod();
		assertTrue(login.verifyLoginPage(), "Admin Sanity Failed: Logout not successful");
	}

	@Test
	public void verifyCoordinatorSanity() {

		login = new LoginPage();

		login.coordinatorlogin();

		assertTrue(login.verifyCoordinatorDashboard(), "Coordinator Sanity Failed: Dashboard not visible");

		login.logoutMethod();

		assertTrue(login.verifyLoginPage(), "Coordinator Sanity Failed: Logout not successful");
	}

	@Test
	public void verifyStudentSanity() {

		login = new LoginPage();

		login.studentlogin();

		assertTrue(login.verifyStudentDashboard(), "Student Sanity Failed: Dashboard not visible");

		login.logoutMethod();

		assertTrue(login.verifyLoginPage(), "Student Sanity Failed: Logout not successful");
	}
}
