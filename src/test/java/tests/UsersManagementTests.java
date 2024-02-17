package tests;

import library.TestBase;
import org.testng.annotations.Test;
import pages.*;

public class UsersManagementTests extends TestBase {
    @Test
    public void addUser () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.USERS);
        pages.UsersManagementPage user = new pages.UsersManagementPage(driver);
        user.addUser();
    }


}

