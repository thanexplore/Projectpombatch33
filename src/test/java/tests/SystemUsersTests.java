package tests;

import library.TestBase;
import org.apache.hc.core5.reactor.Command;
import org.testng.annotations.Test;
import pages.*;

public class SystemUsersTests extends TestBase {
    @Test(priority = 1)
    public void searchUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.USERS);
        pages.SystemUsersPage systemUsersPage = new pages.SystemUsersPage(driver);
        systemUsersPage.search();
    }

    @Test(priority = 2)
    public void editUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.USERS);
        pages.SystemUsersPage systemUsersPage = new pages.SystemUsersPage(driver);
        systemUsersPage.edit();
    }

    @Test(priority = 3)
    public void deleteUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.USERS);
        pages.SystemUsersPage systemUsersPage = new pages.SystemUsersPage(driver);
        systemUsersPage.delete();
    }
}





