package pages;

import library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CandidatePage extends PageBase {
    WebDriver driver;
    private final String dropDown = "//label[text()='%s']//following::div[3]";
    private final String textField = "//label[text()='%s']//following::input[1]";
    private final String nameTextField = "//div[@class = 'oxd-autocomplete-option']//descendant::span[text() = '%s']";
    private final String searchButton = "//button[text() = ' Search ']";
    private final String resetButton = "//button[text() = ' Reset ']";
    private final String addButton = "//button[text() = ' Add ']";
    private final String firstFieldName = "firstName";
    private final String lastFieldname = "lastName";
    private final String addDropDown = "//label[text()='Vacancy']//following::div[5]";
    private final String addTextField = "//label[text()='%s']//following::input";
    private final String browseFile = ".oxd-file-input";
    private final String saveButton = "//button[text() = ' Save ']";
    private final String checkBoxButton = "div[class='oxd-checkbox-wrapper'] span[class*='oxd-checkbox-input']";
    private final String shortlistButton = ".oxd-button--success";
    private final String rejectButton = "//button[text() = ' Reject ']";
    private final String textBox = "//*[@placeholder=\"Type here\"]";
    private final String scheduleButton = "//button[text() = ' Schedule Interview ']";
    private final String interviewTextBox = "//label[text() = '%s']//following::input[1]";
    private final String interviewerFailedButton = "//button[text() = ' Mark Interview Failed ']";
    private final String editActionButton = "//div[text() = '%s']//following::div[9]//descendant::button[1]";
    private final String editClick = "span[class = 'oxd-switch-input oxd-switch-input--active --label-left']";
    private final String deleteButton = "//div[text() = '%s']//following::div[9]//descendant::button[2]";
    private final String confirmDelete = "//button[text() = ' Yes, Delete ']";
    public CandidatePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void search(){
        clickSelectButton(By.xpath(dropDown.replace("%s","Vacancy")), 1);
        selectOptionButton("Vacancy", "Associate IT Manager",1);
        clickSelectButton(By.xpath(dropDown.replace("%s","Hiring Manager")), 1);
        selectOptionButton("Hiring Manager", "Odis Adalwin",1);
        clickSelectButton(By.xpath(dropDown.replace("%s","Status")), 1);
        selectOptionButton("Status", "Job Offered",1);
        setText(By.xpath(textField.replace("%s","Candidate Name")),"b",1);
        clickSelectButton(By.xpath(nameTextField.replace("%s","Bhavya sree Dachu")),1);
        setText(By.xpath(textField.replace("%s", "Date of Application")),"2024-06-02");
        setText(By.xpath("//*[@placeholder=\"To\"]"),"2024-10-02");
        clickSelectButton(By.xpath(dropDown.replace("%s","Method of Application")), 1);
        selectOptionButton("Method of Application", "Online", 1);
        click(By.xpath(searchButton));
        sleep(2000);
        click(By.xpath(resetButton));
        Assert.assertTrue(true);
    }

    public void add(){
        click(By.xpath(addButton));
        setText(By.name(firstFieldName),"Deniel");
        setText(By.name(lastFieldname),"Jackson");
        clickSelectButton(By.xpath(addDropDown.replace("%s","Vacancy")), 1);
        selectOptionButton("Vacancy", "Java Developer", 1);
        setText(By.xpath(addTextField.replace("%s","Email")),"jackson@icloud.com", 1);
        setText(By.xpath(addTextField.replace("%s","Contact Number")),"2261234765", 1);
        sleep(2000);
        fileUpload(By.cssSelector(browseFile),"/Users/damanaujla/Desktop/dummy.pdf",1);
        sleep(2000);
        click(By.cssSelector(checkBoxButton));
        click(By.xpath(saveButton));
        sleep(2000);
        click(By.cssSelector(shortlistButton));
        setText(By.xpath(textBox),"Candidate is shortlisted");
        click(By.xpath(saveButton));
        sleep(2000);
        click(By.xpath(scheduleButton));
        setText(By.xpath(interviewTextBox.replace("%s","Interview Title")),"Interview for Java Developer",1);
        setText(By.xpath(textField.replace("%s","Interviewer")),"o",1);
        clickSelectButton(By.xpath(nameTextField.replace("%s","Odis  Adalwin")),1);
        setText(By.xpath(textField.replace("%s", "Date")),"2024-07-02");
        sleep(2000);
        click(By.xpath(saveButton));
        click(By.xpath(interviewerFailedButton));
        setText(By.xpath(textBox),"Interview did not pass");
        sleep(2000);
        click(By.xpath(saveButton));
        click(By.xpath(rejectButton));
        setText(By.xpath(textBox),"Candidate rejected");
        click(By.xpath(saveButton));
        Assert.assertTrue(true);
    }

    public void edit(){
        click(By.xpath(editActionButton.replace("%s","Senior QA Lead")));
        click(By.cssSelector(editClick));
        sleep(2000);
        String editText = "xiang@icloud.com";
        setText(By.xpath(addTextField.replace("%s","Email")),editText,1);
        sleep(2000);
        click(By.xpath(saveButton));
        Assert.assertTrue(true);
    }

    public void delete(){
        click(By.xpath(deleteButton.replace("%s","Java Developer")));
        click(By.xpath(confirmDelete));
        Assert.assertTrue(true);
    }
}