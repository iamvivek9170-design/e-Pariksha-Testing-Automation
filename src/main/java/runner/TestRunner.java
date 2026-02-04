package runner;

import org.testng.TestNG;

import java.util.Collections;

public class TestRunner {

	public static void main(String[] args) {

		// Step 1: Create TestNG Object
		TestNG testng = new TestNG();

		// Step 2: Link Master Suite XML
		testng.setTestSuites(Collections.singletonList("testng.xml"));

		// Step 3: Execute Suite
		testng.run();

		System.out.println("Full Suite Execution Completed!");
	}
}
