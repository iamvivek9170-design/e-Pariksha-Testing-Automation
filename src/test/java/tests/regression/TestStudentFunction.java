package tests.regression;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.StudentDashboardPage;

public class TestStudentFunction extends BaseTest {

	LoginPage login;
	StudentDashboardPage stuDash;

	@Test
	public void studenExamFlow() {
		login = new LoginPage();
		stuDash = new StudentDashboardPage();

		login.studentlogin();
		stuDash.stratExam(); // please exam is schedule for this Student and Module1

	}

	@Test
	public void studentExamstart() {
		login = new LoginPage();
		stuDash = new StudentDashboardPage();

		login.studentlogin();
		stuDash.stratExam(); // please exam is schedule for this Student and Module1
	}

	@Test
	public void examResultVisibleToStudnet() {
		login = new LoginPage();
		stuDash = new StudentDashboardPage();

		login.studentlogin();
		stuDash.stratExam(); // please exam is schedule for this Student and Module1

		try {
		stuDash.verifyStudentResult(); // make sure during exam show result is visible

		} catch (Exception e) {
			throw new RuntimeException("Your result is not Visible to you "+ e.getMessage());
		}

	}

}
