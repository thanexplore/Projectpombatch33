package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class loginorangehrm {
	
public WebDriver driver;
public WebDriverWait wait;
//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	By Uname =By.xpath("//input[@name='username']");//expectedconditions used to speed up the execution 
	
	By pwd =By.xpath("//input[@name='password']");
	By login=By.xpath("//button[@type='submit']");
	//By registerLink=By.linkText("REGISTER");
	
	
	public loginorangehrm(WebDriver driver,WebDriverWait wait) 
	{
		this.driver=driver;
		this.wait=wait;
		
	}
    
	public void enterUsername(String unam)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(Uname)).sendKeys(unam);
	}
	
	public void enterPassword(String paswrd)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(pwd)).sendKeys(paswrd);
	}
	public void clicklogin()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(login)).click();
	}
	//public void clickOnRegister()
	//{
	//	driver.findElement(registerLink).click();
	//}
	
	
	

}
