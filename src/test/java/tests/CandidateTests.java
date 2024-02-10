package tests;

import library.TestBase;
import org.testng.annotations.Test;
import pages.CandidatePage;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MenuOptions;

public class CandidateTests extends TestBase {

    @Test(priority = 1)
    public void search() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.CANDIDATES);
        CandidatePage candidatePage = new CandidatePage(driver);
        candidatePage.search();
    }

    @Test
    public void add() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.CANDIDATES);
        CandidatePage candidatePage = new CandidatePage(driver);
        candidatePage.add();
    }

    @Test(priority = 2)
    public void edit() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.CANDIDATES);
        CandidatePage candidatePage = new CandidatePage(driver);
        candidatePage.edit();
    }

    @Test(priority = 3)
    public void delete(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.CANDIDATES);
        CandidatePage candidatePage = new CandidatePage(driver);
        candidatePage.delete();
    }
}