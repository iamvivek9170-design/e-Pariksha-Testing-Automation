package tests.regression;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.StudentDashboardPage;

public class StudentFunctionTest extends BaseTest {

    LoginPage login;
    StudentDashboardPage stuDash;

    @Test
    public void verifyStudenLogin() {

        login = new LoginPage();
        stuDash = new StudentDashboardPage();

        login.studentlogin();

        assertTrue(login.verifyStudentDashboard(),
                "Student dashboard is not visible after login");
        login.logoutMethod();
    }

    @Test
    public void verifyStudentExamstart() {

        login = new LoginPage();
        stuDash = new StudentDashboardPage();

        login.studentlogin();

        boolean examStarted = stuDash.stratExam();

        if (examStarted) {

            assertEquals(examStarted, true);
            System.out.println("Exam Scheduled → Started Successfully");

        } else {

            assertEquals(stuDash.verifyExamNotScheduledMessage(), true);
//            System.out.println("No exam is scheduled today. Please contact examiner");
        }
    }

}
