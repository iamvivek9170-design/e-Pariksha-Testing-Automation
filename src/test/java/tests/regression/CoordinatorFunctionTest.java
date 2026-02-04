package tests.regression;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ExaminerDashboardPage;
import pages.ExaminerExamSchdulePage;
import pages.ExaminerManageStudents;
import pages.ExaminerModulesInformationPage;
import pages.ExaminerResultPage;
import pages.LoginPage;

public class CoordinatorFunctionTest extends BaseTest {

	LoginPage login;
	ExaminerDashboardPage coDash;
	ExaminerExamSchdulePage examSch;
	ExaminerManageStudents mngStud;
	ExaminerResultPage examresult;
	ExaminerModulesInformationPage moduQuestio;

	@Test
	public void C_TS09_TC06_verifyExamScheduleBycoordinator() {
		login = new LoginPage();
		coDash = new ExaminerDashboardPage();
		examSch = new ExaminerExamSchdulePage();

		login.coordinatorlogin();
		coDash.exam();
		examSch.schduleExamStausYesShowResultYes();
		assertEquals(examSch.verifyExamScheduleessage(), true);
	}

	@Test
	public void C_TS12_TC10_verifyManageStudentDataValidFilelUpload() {
		login = new LoginPage();
		coDash = new ExaminerDashboardPage();
		mngStud = new ExaminerManageStudents();

		login.coordinatorlogin();
		coDash.manageStud();
		mngStud.uploadStudentData();
		assertEquals(mngStud.verifyfileuploadMessage(), true);
	}

	@Test
	public void C_TS12_TC04_verifyManageStudentDataInvalidFilelUpload() {
		login = new LoginPage();
		coDash = new ExaminerDashboardPage();
		mngStud = new ExaminerManageStudents();

		login.coordinatorlogin();
		coDash.manageStud();
		mngStud.uploadStudentinvalidData();
		assertEquals(mngStud.verifyfileuploadMessage(), true);
	}

	@Test
	public void C_TS12_TC27_manageStudentEditStuduentBlock() {
		login = new LoginPage();
		coDash = new ExaminerDashboardPage();
		mngStud = new ExaminerManageStudents();

		login.coordinatorlogin();
		coDash.manageStud();
		mngStud.blockStudent();
		assertEquals(mngStud.verifyblockUnblockmessage(), true);
		mngStud.cancel();
	}

	@Test(dependsOnMethods = "C_TS12_TC27_manageStudentEditStuduentBlock")
	public void C_TS12_TC28_manageStudentEditStuduentUnBlock() {
		login = new LoginPage();
		coDash = new ExaminerDashboardPage();
		mngStud = new ExaminerManageStudents();

		login.coordinatorlogin();
		coDash.manageStud();
		mngStud.unBlockStudent();
		assertEquals(mngStud.verifyblockUnblockmessage(), true);
		mngStud.cancel();

	}

	@Test
	public void C_TS10_TC09_verifyResultVisibilityToCoordinator() {
		login = new LoginPage();
		coDash = new ExaminerDashboardPage();
		examresult = new ExaminerResultPage();

		login.coordinatorlogin();
		coDash.Result();
		examresult.seeResultOfStudent();
		assertEquals(examresult.verifyResultVisible(), true);

	}

	public void CoordinatorWorkflow() {
		login = new LoginPage();
		coDash = new ExaminerDashboardPage();
		examresult = new ExaminerResultPage();
		moduQuestio = new ExaminerModulesInformationPage();
		
		
		login.verifyLoginPage();
		login.coordinatorlogin();
		login.verifyCoordinatorDashboard();
		coDash.moduleAndQuestion();

		moduQuestio.questionUpload();

		coDash.home();
		coDash.manageStud();
		mngStud.uploadStudentData();

		System.out.println(mngStud.verifyfileuploadMessage());

		coDash.home();

		coDash.exam();

		examSch.schduleExamStausYesShowResultYes();

		coDash.home();

		coDash.manageStud();

		mngStud.blockStudent();
		mngStud.unBlockStudent();

		coDash.home(); 

		login.logoutMethod();
		login.verifyLoginPage();
		
		
		

	}

}
