package tests;


import library.TestBase;
import org.testng.annotations.Test;
import pages.EducationPage;
import pages.HeaderPage;
import pages.LoginPage;
import pages.MenuOptions;

import java.util.UUID;

public class EducationTests extends TestBase {
    @Test
    public void addNewEducation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        EducationPage educationPage = new EducationPage(driver);
        educationPage.saveNewEducation("High School");
        String uuid = UUID.randomUUID().toString();
        educationPage.saveNewEducation("level1" + uuid);
    }

    @Test
    public void deleteEducation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        EducationPage educationPage = new EducationPage(driver);
        educationPage.deleteEducation("College Undergraduate");
    }
    @Test
    public void editEducation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        EducationPage educationPage = new EducationPage(driver);
        educationPage.editEducation("Bachelor's Degree");
    }

    @Test
    public void deleteByCheckbox(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        EducationPage educationPage = new EducationPage(driver);
        educationPage.deleteByCheckbox("High School Diploma");
    }
}

