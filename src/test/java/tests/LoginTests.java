package tests;


import library.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends TestBase {

    @Test
    public void loginTestWithValidCredentials()  {
        LoginPage loginPage = new LoginPage(driver);
        boolean validCredentials = true;
        boolean result = loginPage.login("Admin", "admin123",true,null);

        if(validCredentials) {
            Assert.assertTrue(result);
        } else {
            Assert.assertFalse(result);
        }
    }

    @Test
    public void loginTestWithInValidCredentials()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("sumo", "blahblah", false,"Invalid credentials");
    }

    @Test
    public void loginTestWithSpaces(){
        LoginPage loginPage = new LoginPage(driver);
        //loginPage.login();

    }
}
