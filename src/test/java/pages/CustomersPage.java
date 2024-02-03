package pages;

import library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CustomersPage extends PageBase {
    WebDriver driver;
    private final String btnAddCustomer = ".oxd-button--medium";
    private final String txtCustomerName = "div[class='oxd-form-row'] input[class*='oxd-input']";
    private final String txtCustomerDecription = "//*[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical' ]";
    private final String btnSubmit = "//button[@type='submit']";
    private final String lblAlreadyExistsMessage =  "//div[@class='oxd-form-row'] /div";
    private final String btnCancel = "//div[@class='oxd-form-actions']/button[@type='button']";
    private  final String tblCustRecords=".oxd-table-body";
    private final String customers="//*[@class='oxd-table-body']/div[@class='oxd-table-card']";
    private final String deleteCustomer="";

    //"//*[text()='Already exists']";//
    @FindBy(xpath = customers)
    private List<WebElement> listCustomers;   ////*[text()='Project Info ']

    public CustomersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void setBtnAddCustomer(String customerName)  {
        click(By.cssSelector(btnAddCustomer));
       // Thread.sleep(5000);
        setText(By.cssSelector(txtCustomerName), customerName);
        if (getText(By.xpath(lblAlreadyExistsMessage)).contains("Already exists")) {
            click(By.xpath(btnCancel));
        } else {
            click(By.xpath(btnSubmit));
        }
        isElementVisible(By.cssSelector(tblCustRecords));
        for(WebElement CustomerList: listCustomers){
            String txtCutsomerName=CustomerList.getText();
            System.out.println(txtCutsomerName);
        }
        Boolean match =listCustomers.stream().map(s -> s.getText()).anyMatch(s ->s.equalsIgnoreCase(customerName));
        Assert.assertTrue(match);
        System.out.println("\n");
        System.out.println(customerName+"Added Successfully");
        System.out.println("\n");


    }
}

    /* "//button[@type='button']/i[@class='oxd-icon bi-plus oxd-button-icon']" */




