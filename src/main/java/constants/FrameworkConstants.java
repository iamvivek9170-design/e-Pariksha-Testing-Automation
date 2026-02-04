package constants;

public final class FrameworkConstants {
	

	// User Management Test Data (Admin Role)

	public static final String EXISTING_USER_NAME = "Vivek";
	public static final String UPDATED_LAST_NAME = "[1058] Vivek tiwari";

	public static final String NEW_USER_FIRST_NAME = "Vivek";
	public static final String NEW_USER_LAST_NAME = "Tiwari";
	public static final String NEW_USER_EMAIL = "vivek123@gmail.com";
	public static final String NEW_USER_CONTACT = "1234567891";

	// Course & Module Management Constants

	public static final String NEW_COURSE_NAME = "Automation Framework 2";
	public static final String NEW_COURSE_ABBREVATION = "AF2";
	public static final String NEW_MODULE_NAME = "module1";

	public static final String DEFAULT_EXAM_MODULE = "Module1";

	// Exam Configuration Constants

	public static final String TOTAL_QUESTIONS = "3";
	public static final String EXAM_DURATION = "2";
	public static final String PASSING_MARKS = "1";

	// Authorization Testing URLs (Role Based)

	public static final String ADMIN_DASHBOARD_URL = "http://ccst-testvm.pune.cdac.in:8080/epAdmin/AdminHome.jsp";

	public static final String COORDINATOR_DASHBOARD_URL = "http://ccst-testvm.pune.cdac.in:8080/epAdmin/ExaminerHome.jsp";

	public static final String STUDENT_DASHBOARD_URL = "http://ccst-testvm.pune.cdac.in:8080/epAdmin/StudentHome.jsp";

	public static final String STUDENT_DATA_INVALID_FILE = System.getProperty("user.dir")
			+ "/src/test/resources/testdata/Student_Login_Data.xls";

	public static final String STUDENT_DATA_VALID_FILE = System.getProperty("user.dir")
			+ "/src/test/resources/testdata/Student_Login_Data (1).xls";

	public static final String QUESTION_BULK_FILE = System.getProperty("user.dir") + "/src/test/resources/testdata/Bulk_Question_Upload.zip";


}
