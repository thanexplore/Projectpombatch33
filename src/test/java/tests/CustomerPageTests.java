package tests;

import library.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.*;

import java.sql.Time;
import java.util.UUID;

public class CustomerPageTests extends TestBase {

   @Test
    public void AddnewCustomer() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.CUSTOMERS);
        Thread.sleep(10000);
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.setBtnAddCustomer("TestCompany1");
       // String uuid=UUID.randomUUID().toString();
        //customersPage.setBrnAddCustomer("TestCompany"+uuid);//

    }
}

@Test

public void deletecustomer(String deleteCustomer){

}