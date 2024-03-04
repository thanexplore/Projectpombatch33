package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class qualificationsorangehrm {
	public WebDriver driver;
	public WebDriverWait wait;
	By qualifications=By.xpath("//span[text()='Qualifications ']");
  
	public qualificationsorangehrm(WebDriver driver,WebDriverWait wait) 
	{
		this.driver=driver;
		this.wait=wait;
		
	}
  public void clickqualifications()
	{
	  wait.until(ExpectedConditions.presenceOfElementLocated(qualifications)).click();
	}
}