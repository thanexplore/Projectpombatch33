package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class adminorangehrm {
	public WebDriver driver;
	public WebDriverWait wait;
	By admin=By.xpath("//a[@class='oxd-main-menu-item']");
  
	public adminorangehrm(WebDriver driver,WebDriverWait wait) 
	{
		this.driver=driver;
		this.wait=wait;
		
	}
  public void clickadminname()
	{
	  wait.until(ExpectedConditions.presenceOfElementLocated(admin)).click();
	}
}
