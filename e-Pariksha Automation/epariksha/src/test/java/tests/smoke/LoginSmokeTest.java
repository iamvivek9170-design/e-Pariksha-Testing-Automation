package tests.smoke;

import org.testng.annotations.Test;
import org.testng.Assert;


public class LoginSmokeTest {

	@Test
    public void verifyFrameworkSetup() {

        System.out.println("Framework Setup Successful ✅");

        // Dummy assertion to confirm TestNG execution
        Assert.assertTrue(true);
    }
}
