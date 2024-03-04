package testcases;

import java.util.ArrayList;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class testcasesorangehrm {
	public WebDriver driver;
	public WebDriverWait wait;
	
	// Test Case 1- To add two licenses 
	
	By clickadd=By.xpath("(//button[@type='button'])[3]");
	By textbox=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By submitlicense=By.xpath("//button[@type='submit']");   //OBJECT RPOSETRY CREATED USING BY VARIABLES
	
	// Test Case 2- To edit a particular license
	
	By editlicense=By.xpath("(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[6]");
	By textboxedit=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By submitedited=By.xpath("//button[@type='submit']");
	
	// Test Case 3- To delete a particular license
	
	By deletelicense=By.xpath("//div[text()='Microsoft Technology Associate (MTA)-Phase 1 d7g67*k']");
	By clicktrash=By.xpath("(//i[@class='oxd-icon bi-trash'])[6]");
	By confirmdelete=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");
	
	 // Test Case 4- To enable the checkboxes and print the message in the console
	
	By checkboxenable=By.xpath("(//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input'])[1]");
	By arraylist=By.xpath("//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']");
	
	// Test Case 5- To display a message in console that the page cannot be saved without entering any license details
	
	By clickadd1=By.xpath("(//button[@type='button'])[3]");
	By submit=By.xpath("//button[@type='submit']");
	By message=By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");
  
	// Test Case 6- To display already exists message in the console
	
	By clickadd2=By.xpath("(//button[@type='button'])[3]");
	By textbox1=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By submitlicense1=By.xpath("//button[@type='submit']");
	By message1=By.xpath("//span[text()='Already exists']");
	
	// Test Case 7- To display the number of licenses count in the console
	
	By licensescount=By.xpath("//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input']");
	

public testcasesorangehrm(WebDriver driver,WebDriverWait wait) 
	{
		this.driver=driver;
		this.wait=wait;
		
	}
	

//Test Case 1- To add two licenses 
	
  public void clickaddlicenses()   // CREATED AS FUNCTIONS REFERRED USING BY VARIABLES
	{
	  wait.until(ExpectedConditions.presenceOfElementLocated(clickadd)).click();  
	}
  public void selectaddtextbox(String licences)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(textbox)).sendKeys(licences);
	}
  public void submitlicenseadded()
  {
	  wait.until(ExpectedConditions.presenceOfElementLocated(submitlicense)).click();
  }

   
//Test Case 2- To edit a particular license
  
  public void editlicenses()
  {
	  wait.until(ExpectedConditions.presenceOfElementLocated(editlicense)).click();
  } 
  public void textboxediting(String tbedit) throws InterruptedException
  {   
	 WebElement cl=wait.until(ExpectedConditions.presenceOfElementLocated(textboxedit));
	 Thread.sleep(2000);
	 cl.sendKeys(Keys.CONTROL + "a");
     cl.sendKeys(Keys.DELETE);
	 cl.sendKeys(tbedit);
  }
  public void submiteditedlicense()
  {
	  wait.until(ExpectedConditions.presenceOfElementLocated(submitedited)).click();
  }
  
  
//Test Case 3- To delete a particular license
  
  
  public void deletelicenses()
  {
	  wait.until(ExpectedConditions.presenceOfElementLocated(deletelicense)).click();
  }
  public void trashselection()
  {
	  wait.until(ExpectedConditions.presenceOfElementLocated(clicktrash)).click();
  }
  public void deleteconfirmation()
  {
	  wait.until(ExpectedConditions.presenceOfElementLocated(confirmdelete)).click();
  }
  
  
//Test Case 4- To enable the checkboxes and print the message in the console
  
  public void enabledcheckbox()
  {
	  wait.until(ExpectedConditions.presenceOfElementLocated(checkboxenable)).click();
  }
  public void selectioninarray() throws InterruptedException
  {
		ArrayList<WebElement> chs=new ArrayList<WebElement>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(arraylist)));
		for(WebElement i:chs)////till the end of the table ,avoid hard coding
		{
		
			//WebElement ch=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input'])[i]")));
		    //i.click();
		    Thread.sleep(2000);
			//Object graphql;
			Assert.assertTrue(i.isEnabled());
		}
		System.out.println("All Elements are Enabled");
  }
  

//Test Case 5- To display a message in console that the page cannot be saved without entering any license details

public void cannotsave()
{
	wait.until(ExpectedConditions.presenceOfElementLocated(clickadd1)).click();	
}
public void submitted()
{
	wait.until(ExpectedConditions.presenceOfElementLocated(submit)).click();
}
public void messagedisplayed(String msg) throws InterruptedException
{
	  WebElement alll=wait.until(ExpectedConditions.presenceOfElementLocated(message));
	  Thread.sleep(2000);
	  Assert.assertTrue(alll.isDisplayed());
	  System.out.println(msg);
}

// Test Case 6- To display already exists message in the console

public void clickaddlicenses1()
{
	wait.until(ExpectedConditions.presenceOfElementLocated(clickadd2)).click();
}
public void selectaddtextbox1(String licenses1)
{
	wait.until(ExpectedConditions.presenceOfElementLocated(textbox1)).sendKeys(licenses1);
}
public void submitaddedlicense1()
{
	wait.until(ExpectedConditions.presenceOfElementLocated(submitlicense1)).click();
}
public void messagedisplayed1(String msg1)
{
	WebElement sa=wait.until(ExpectedConditions.presenceOfElementLocated(message1));
	Assert.assertTrue(sa.isDisplayed());
	System.out.println(msg1);
}

//Test Case 7- To display the number of licenses count in the console

public void licensescounted() throws InterruptedException
{
	  Thread.sleep(7000); 
	  ArrayList<WebElement> checkboxes=new ArrayList<WebElement>(driver.findElements(licensescount));
	  int size=checkboxes.size();
	  System.out.println("No.of entries " +(size-1));
}

}
