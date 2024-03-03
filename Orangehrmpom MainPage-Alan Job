package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class ORANGEHRM {
	  public WebDriver driver;
	  public WebDriverWait wait;    // REFERENCE VARIABLES
	  public loginorangehrm loginobj;
	  public adminorangehrm adminobj;
	  public qualificationsorangehrm qualificationsobj;
	  public licensesorangehrm licensesobj;
	  public testcasesorangehrm testcasesobj;
 
  
  @BeforeTest
  public void beforeTest() {
	  

	    //System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver=new ChromeDriver(); 
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));//dont use webdriver here as this statement only runs as webdriver will get used as local variable here
		driver.manage().window().maximize(); //to maximize the window
		loginobj=new loginorangehrm(driver,wait);
		adminobj=new adminorangehrm(driver,wait);
		qualificationsobj=new qualificationsorangehrm(driver,wait);
		licensesobj=new licensesorangehrm(driver,wait);
		testcasesobj=new testcasesorangehrm(driver,wait); // INSTANTIATION OF EACH PAGES
		
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // to get the particular website 
		
	  
	  
	  //MAVEN FRAME WORK IS POM ,FASTLY READABLE,OBJECT REPOSETORY -UNIQUE IDENTIFICATION,TROBLESHOOTING IS EASY
  }
  
  @Test(priority=1)    // login details entered
  public void login() throws InterruptedException 
  
  {
	  loginobj.enterUsername("Admin");
	  loginobj.enterPassword("admin123"); //FUNCTION CALLING USING THE OBJECTS
	  loginobj.clicklogin();
	  Thread.sleep(2000);
	  
  }
  
  
  @Test(priority=2) // clicking the administrator option
  public void admin() throws InterruptedException
  {
	  adminobj.clickadminname();
	  Thread.sleep(2000);
  }
  
  
  @Test(priority=3) // clicking the qualification option
  public void qualifications() throws InterruptedException
  {
	  qualificationsobj.clickqualifications();
	  Thread.sleep(2000);
  }
  
@Test(priority=4) // clicking the license option
public void licenses() throws InterruptedException
{
	licensesobj.clicklicenses();
	Thread.sleep(2000);
}


                    // Test Case 1- To add two licenses using Data Provider
@Test(priority=5,dataProvider="dp") // clicking the add button to add two licenses simultaneously

public void testcases1(String Licences) throws InterruptedException
{
	Thread.sleep(2000);
	testcasesobj.clickaddlicenses();
	
	testcasesobj.selectaddtextbox(Licences);
	
	testcasesobj.submitlicenseadded();
	Thread.sleep(2000);
}

@DataProvider // entering two licenses details to add in to the database using dataprovider functionality
public Object[][] dp() {
return new Object[][] {
new Object[] {"Microsoft Technology Associate (MTA)-Phase qj1"},
new Object[] {"Building Infrastructure Management (BIM)-License 1k"},
};}


                    // Test Case 2- To edit a particular license

@Test(priority=6) // editing a particular license

public void testcases2() throws InterruptedException
{
	Thread.sleep(2000);
	testcasesobj.editlicenses();
	
    testcasesobj.textboxediting("Microsoft Technology Associate (MTA)-Phase 1 d7g67*kk");
    
    Thread.sleep(5000);
     
	testcasesobj.submiteditedlicense();
	Thread.sleep(2000);
}

                  // Test Case 3- To delete a particular license

@Test(priority=7) // deleting a particular license

public void testcases3() throws InterruptedException
{
	Thread.sleep(2000);
	testcasesobj.deletelicenses();
	Thread.sleep(5000);
	testcasesobj.trashselection();
	Thread.sleep(2000);
	testcasesobj.deleteconfirmation();
	Thread.sleep(2000);
}
                 // Test Case 4- To enable the checkboxes

@Test(priority=8) // enabling the checkboxes

public void testcases4() throws InterruptedException
{
	Thread.sleep(2000);
	testcasesobj.enabledcheckbox();
	Thread.sleep(5000);
	testcasesobj.selectioninarray();
	Thread.sleep(2000);
}
                 // Test Case 5- To display a message in console that the page cannot be saved without entering any license details

@Test(priority=9) // to display in console that the page cannot be saved without entering any details in name checkbox after clicking add button

public void testcases5() throws InterruptedException
{
	Thread.sleep(2000);
	testcasesobj.cannotsave();
	Thread.sleep(5000);
	testcasesobj.submitted();
	Thread.sleep(2000);
	testcasesobj.messagedisplayed("Page cannot be saved without entering the required data");
}

                // Test Case 6- To display already exists message in the console

@Test(priority=10)  //to display already exists message in console

public void testcases6() throws InterruptedException
{
	Thread.sleep(2000);
	testcasesobj.clickaddlicenses1();
	Thread.sleep(5000);
	testcasesobj.selectaddtextbox1("Cisco Certified Network Associate (CCNA)");
	Thread.sleep(2000);
	testcasesobj.submitaddedlicense1();
	Thread.sleep(2000);
	testcasesobj.messagedisplayed1("Already Exists");
}

             // Test Case 7- To display the number of licenses count in the console

@Test(priority=11)  //to display the number of licenses in the console

public void testcases7() throws InterruptedException
{
	Thread.sleep(2000);
	testcasesobj.licensescounted();
}
  @AfterTest
  public void afterTest() {
	//  driver.close();
  }

}
