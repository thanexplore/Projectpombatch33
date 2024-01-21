package tests;

import org.testng.annotations.DataProvider;

public class ParameterizationTestData {
    @DataProvider(name = "LoginInfo")
    public Object[][] getUserInfo(){
        return new Object[][]{
                {"admin","admin123"},
                {"joe", "joe123"},
                {"Hary", "Password"}
        };
    }
}
