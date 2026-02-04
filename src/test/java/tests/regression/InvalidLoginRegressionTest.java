package tests.regression;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class InvalidLoginRegressionTest extends BaseTest {

    LoginPage login; 

    @Test
    public void verifyLoginFailsWithWrongPassword() {

        login = new LoginPage();
        login.loginMethod("1002", "wrongPassword");
        assertEquals(login.verifyLoginFailer(), true);
    }

    @Test
    public void verifyLoginFailsWithWrongUserId() {

        login = new LoginPage();

        login.loginMethod("9999", "cdac1234");

        assertEquals(login.verifyLoginFailer(), true);
    }

    @Test
    public void verifyLoginFailsWithEmptyCredentials() {

        login = new LoginPage();

        login.loginMethod("", "");

        assertEquals(login.verifyLoginFailer(), true);
    }
}
