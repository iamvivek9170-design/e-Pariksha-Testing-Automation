package endtoend;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AdminCoursesPage;
import pages.AdminDashboardPage;
import pages.AdminResultPage;
import pages.AdminUserManagementPage;
import pages.ExaminerDashboardPage;
import pages.ExaminerExamSchdulePage;
import pages.ExaminerManageStudents;
import pages.ExaminerModulesInformationPage;
import pages.ExaminerResultPage;
import pages.LoginPage;
import pages.StudentDashboardPage;

public class EndToEndTest extends BaseTest {

	LoginPage login;
	ExaminerDashboardPage coDash;
	ExaminerExamSchdulePage examSch;
	ExaminerManageStudents mngStud;
	ExaminerResultPage examresult;
	ExaminerModulesInformationPage moduQuestio;
	StudentDashboardPage studash;

	AdminCoursesPage admcourpage;

	AdminDashboardPage admdashpage;

	AdminResultPage admrepage;

	AdminUserManagementPage admnUserpage;

	@Test
	public void CoordinatorWorkFlow() throws InterruptedException {
		login = new LoginPage();
		coDash = new ExaminerDashboardPage();
		examSch = new ExaminerExamSchdulePage();
		mngStud = new ExaminerManageStudents();
		moduQuestio = new ExaminerModulesInformationPage();
		examresult = new ExaminerResultPage();
		studash = new StudentDashboardPage();
		admcourpage = new AdminCoursesPage();
		admdashpage = new AdminDashboardPage();
		admrepage = new AdminResultPage();
		admnUserpage = new AdminUserManagementPage();

		login.adminlogin();
		Thread.sleep(1000);

		admdashpage.users();
		Thread.sleep(1000);

		admnUserpage.addNewUser();

		Thread.sleep(3000);

		admdashpage.courses();
		Thread.sleep(1000);

		admcourpage.addnewCourse();
		admcourpage.cancel();
		Thread.sleep(1000);

		admcourpage.addingModuleToExstingCourse();
		Thread.sleep(1000);

		admcourpage.cancel();

		Thread.sleep(5000);
		admcourpage.assignUserToCourse();

		admdashpage.home();
		admdashpage.switchToUser();

		login.verifyCoordinatorDashboard();
		Thread.sleep(1000);

		coDash.moduleAndQuestion();
		Thread.sleep(1000);

		moduQuestio.questionUpload();
		Thread.sleep(1000);

		coDash.home();
		coDash.manageStud();
		Thread.sleep(1000);

		mngStud.uploadStudentData();
		Thread.sleep(1000);

		System.out.println(mngStud.verifyfileuploadMessage());

		coDash.home();

		coDash.exam();

		examSch.schduleExamStausYesShowResultYes();
		Thread.sleep(1000);

		coDash.home();

		coDash.manageStud();

		mngStud.blockStudent();
		Thread.sleep(1000);

		mngStud.unBlockStudent();
		Thread.sleep(1000);

		coDash.home();

		login.logoutMethod();
		Thread.sleep(1000);

		login.studentlogin();
		Thread.sleep(1000);

		login.verifyStudentDashboard();
		Thread.sleep(1000);

		studash.stratExam();

		Thread.sleep(1000);
		login.logoutMethod();
		Thread.sleep(1000);

		login.loginMethod("1138", "cdac1234");
		Thread.sleep(1000);

		login.verifyCoordinatorDashboard();
		Thread.sleep(1000);

		coDash.Result();

		examresult.seeResultOfStudent();
		Thread.sleep(1000);

		examresult.verifyResultVisible();

		login.logoutMethod();
	}

}
