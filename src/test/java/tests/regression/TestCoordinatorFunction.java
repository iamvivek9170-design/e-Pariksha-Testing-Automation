package tests.regression;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ExaminerDashboardPage;
import pages.ExaminerExamSchdulePage;
import pages.ExaminerManageStudents;
import pages.LoginPage;

public class TestCoordinatorFunction extends BaseTest{
	LoginPage login;
	ExaminerDashboardPage coDash;
	ExaminerExamSchdulePage examSch;
	ExaminerManageStudents mngStud;
	
	
	
	
	@Test
	public void examScheduleBycoordinator() {
		login = new LoginPage();
		coDash = new ExaminerDashboardPage();
		examSch = new ExaminerExamSchdulePage(); 
		
		login.coordinatorlogin();
		coDash.exam();
		examSch.schduleExamStausYesShowResultYes(); 
		// assertion 

	}
	
	@Test
	public void manageStudentDataFinelUpload() {
		login = new LoginPage();
		coDash = new ExaminerDashboardPage();
		mngStud = new ExaminerManageStudents();
		
 
		
		login.coordinatorlogin();
		coDash.manageStud();
		mngStud.uploadStudentData();
		
		// assertion 
	}
	 
	@Test 
	public void manageStudentEditStuduentBlock() {
		login = new LoginPage();
		coDash = new ExaminerDashboardPage();
		mngStud = new ExaminerManageStudents();
		
		login.coordinatorlogin();
		coDash.manageStud();
		mngStud.editStudent();
		
	}
	  
	
//	public void manageStudentEditStuduentUnBlock() {
//	
//		
//		
//	}
	
	
}
