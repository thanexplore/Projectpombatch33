package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class licensesorangehrm {
	public WebDriver driver;
	public WebDriverWait wait;
	By licenses=By.xpath("//a[text()='Licenses']");
  
	public licensesorangehrm(WebDriver driver,WebDriverWait wait) 
	{
		this.driver=driver;
		this.wait=wait;
		
	}
  public void clicklicenses()
	{
	  wait.until(ExpectedConditions.presenceOfElementLocated(licenses)).click();
	}
}