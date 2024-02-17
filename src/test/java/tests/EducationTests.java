package tests;


import library.TestBase;
import org.testng.Assert;
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
        educationPage.saveNewEducation("Diploma");
        educationPage.saveNewEducation("Diploma456");
//        String uuid = UUID.randomUUID().toString();
//        educationPage.saveNewEducation("Diploma" + uuid);
    }

    @Test(priority = 1)
    public void editEducation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        EducationPage educationPage = new EducationPage(driver);
        boolean edit = educationPage.editEducation("Diploma");
        Assert.assertTrue(edit,"Education has not been successfully edited");
    }

    @Test(priority = 2)
    public void deleteEducation() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        EducationPage educationPage = new EducationPage(driver);
        boolean delete = educationPage.deleteEducation("Under Graduate");
        Assert.assertTrue(delete,"Education has not been deleted");
    }


    @Test(priority = 3)
    public void deleteByCheckbox(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.EDUCATION);
        EducationPage educationPage = new EducationPage(driver);
        boolean delete = educationPage.deleteByCheckbox("Diploma456");
        Assert.assertTrue(delete,"Education has not been deleted");
    }
}

