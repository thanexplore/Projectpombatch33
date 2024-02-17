package pages;

import library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

import static org.openqa.selenium.By.xpath;

public class UsersManagementPage extends PageBase {
    private final String addButton = "//button[text()=' Add ']";
    private final String userRole = "//div[@class='' and @data-v-957b4417='']//div[@class='oxd-select-text-input' and @tabindex='0' and text()='-- Select --']";
    private final String admin = "//div[@role='option' and @class='oxd-select-option'][span[text()='Admin']]";
    private final String employeeName = "//input[@placeholder='Type for hints...']";
    private final String value = "//div[@role='option' and @class='oxd-autocomplete-option' and @data-v-da59eaf4=''][span[text()='Peter Mac Anderson']]";
    private final String status = "//div[@class='oxd-select-text-input' and @tabindex='0' and text()='-- Select --']\n";
    private final String enabled = "//div[@role='option' and span[text()='Enabled']]";
    private final String userName = "//label[text()='Username']//following::input[1]";
    private final String passwordField = "//label[text()='Password']//following::input[1]";
    private final String confirmPassword = "//label[text()='Confirm Password']//following::input[1]";
    private final String save = "//button[text() = ' Save ']";
    private final String validate = "//*[text() = 'Successfully Saved']";
    WebDriver driver;

    public UsersManagementPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addUser() throws InterruptedException {
        click(By.xpath(addButton));
        click(By.xpath(userRole));
        //Thread.sleep(2000);
        click(By.xpath(admin));
        click(By.xpath(employeeName));
        setText(xpath(employeeName), "P");
        Thread.sleep(5000);
        click(By.xpath(value));
        click(By.xpath(status));
        click(By.xpath(enabled));
        click(xpath(userName));
        setText(By.xpath(userName), "James James");
        click(By.xpath(passwordField));
        setText(By.xpath(passwordField),"Petermac1");
        click(By.xpath(confirmPassword));
        setText(By.xpath(confirmPassword),"Petermac1");
        click(By.xpath(save));
        isElementVisible(By.xpath(validate));
        System.out.println("\n");
        System.out.println( " User is added successfully");


    }
}

