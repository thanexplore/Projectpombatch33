package tests;


import library.TestBase;
import org.testng.annotations.Test;
import pages.EducationPage;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MenuOptions;

public class EducationTests extends TestBase {
    @Test
    public void addNewEducation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        EducationPage educationPage = new EducationPage(driver);
        educationPage.saveNewEducation("Diploma");
        educationPage.saveNewEducation("Diploma456");
    }

    @Test
    public void editEducation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        EducationPage educationPage = new EducationPage(driver);
        educationPage.editEducation("Diploma");
    }

    @Test
    public void deleteEducation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        EducationPage educationPage = new EducationPage(driver);
        educationPage.deleteEducation("Diploma");
    }


    @Test
    public void deleteByCheckbox(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        EducationPage educationPage = new EducationPage(driver);
        educationPage.deleteByCheckbox("Diploma456");
    }
}

