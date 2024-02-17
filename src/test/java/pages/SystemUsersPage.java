package pages;

import library.PageBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.Arrays;

import static org.openqa.selenium.By.xpath;

public class SystemUsersPage extends PageBase {
    private final String userName = "//label[text()='Username']//following::input[1]";
    private final String userRole = "//div[@class='' and @data-v-957b4417='']//div[@class='oxd-select-text-input' and @tabindex='0' and text()='-- Select --']";
    private final String admin = "//div[@role='option' and contains(span/text(), 'Admin')]";
    private final String employeeName = "//input[@placeholder='Type for hints...']";
    private final String value = "//div[@role='option' and @class='oxd-autocomplete-option' and @data-v-da59eaf4=''][span[text()='Peter Mac Anderson']]";
    private final String status = "//div[@class='oxd-select-text-input' and @tabindex='0' and text()='-- Select --']";
    private final String enabled = "//div[@role='option' and span[text()='Enabled']]";
    private final String search = "//button[text()=' Search ']";
    private final String recordFound = "//*[text() = 'Record Found']";
    //EDIT
    private final String edit = "//div[text()='%s']//following::div[8]//descendant::button[2]"; //*[@class= 'oxd-icon bi-pencil-fill']
    private final String userRoleEdit = "//div[@class='oxd-select-text-input' and text()='Admin']";
    private final String Ess = "//div[@role='option' and @class='oxd-select-option' and @data-v-d130bb63='' and @data-v-13cf171c='']/span[text()='ESS']";
    private final String statusEdit = "//div[@class='oxd-select-text-input' and @tabindex='0' and text()='Enabled']";
    private final String disabled = "//div[@role='option' and @class='oxd-select-option' and @data-v-d130bb63='' and @data-v-13cf171c='']//span[text()='Disabled']";
    private final String save = "//button[text()=' Save ']";
    private final String updated = "//*[text() = 'Successfully Updated']";
    //DELETE
    private final String deleteButton = "//div[text()='%s']//following::div[8]//descendant::button[1]";
    private final String confirmDelete = "//button[text() =' Yes, Delete ']";
    private final String validation = "//*[text() ='Successfully Deleted']";


    public SystemUsersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void search() throws InterruptedException {
        setText(xpath(userName),"James James");
        click(xpath(userRole));
        click(xpath(admin));
        click(xpath(employeeName));
        setText(xpath(employeeName), "P");
        Thread.sleep(5000);
        for (String s : Arrays.asList(value, status, enabled, search)) {
            click(xpath(s));
        }
        Thread.sleep(2000);
        isElementVisible(By.xpath(recordFound));
        System.out.println("\n");
        System.out.println( " User Found ");

    }
    public void edit () throws InterruptedException {
        click(xpath(edit.replace("%s", "James James")));
        click(xpath(userRoleEdit));
        click(xpath(Ess));
        click(By.xpath(statusEdit));
        click(xpath(disabled));
        click(xpath(save));
        Thread.sleep(3000);
        isElementVisible(By.xpath(updated));
        System.out.println("\n");
        System.out.println( " Values are updated successfully");
    }


    public void delete ()  {
        click(By.xpath(deleteButton.replace("%s","James James")));
        click(By.xpath(confirmDelete));
        isElementVisible(By.xpath(validation));
        System.out.println("\n");
        System.out.println( "Record Deleted");

    }
}
