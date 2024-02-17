package pages;


import library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

public class EducationPage extends PageBase {
    WebDriver driver;
    private final String idEduAddButton = ".oxd-button--secondary";
    private final String idEduTextLevel = "div[class='oxd-form-row'] input[class*='oxd-input']";
    private final String idEduSaveButton = "//button[@type='submit']";
    private final String lblAlreadyExistsMessage = "//div[@class='oxd-form-row'] /div";
    private final String getIdEduCancelButton = "//div[@class='oxd-form-actions'] /button[1]";
    private final String tblEducation = ".oxd-table-body";
    private final String educations = "//div[@class='oxd-table-body'] /div[@class='oxd-table-card']";
    private final String delButton = "//div[text() = \"%s\"]//following::div[2]//descendant::button[1]";
    private final String confirmDelButton = ".orangehrm-modal-footer button:nth-child(2)";
    private final String deleteToast = "//*[text() = 'Successfully Deleted']";
    private final String editButton = "//div[text() = \"%s\"]//following::div[2]//descendant::button[2]";
    private final String editToast = "//*[text() = 'Successfully Updated']";
    private final String checkBoxBtn = "//*[text() = \"%s\"]//parent::div//parent::div//descendant::span";
    private final String deleteBtn = "//Button[text() = ' Delete Selected ']";
    @FindBy(xpath = educations)
    private List<WebElement> listEducations;

    public EducationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void saveNewEducation(String educationName) {
        click(By.cssSelector(idEduAddButton));
        setText(By.cssSelector(idEduTextLevel), educationName);
        if (getText(By.xpath(lblAlreadyExistsMessage)).contains("Already exists")) {
            click(By.xpath(getIdEduCancelButton));
        } else {
            click(By.xpath(idEduSaveButton));
        }
        isElementVisible(By.cssSelector(tblEducation));

        for (WebElement Education : listEducations) {
            String txtEducation = Education.getText();
            System.out.println(txtEducation);

        }
        Boolean match = listEducations.stream().map(s -> s.getText()).anyMatch(s -> s.equalsIgnoreCase(educationName));
        Assert.assertTrue(match);
        System.out.println("\n");
        System.out.println(educationName + " is added successfully");
        System.out.println("\n");
    }

    public boolean deleteEducation(String educationName) {
        boolean delete = false;
        click(By.xpath(delButton.replace("%s", educationName)));
        click(By.cssSelector(confirmDelButton));
        if(isElementVisible(By.xpath(deleteToast))){
            delete = true;
        }
        return delete;
    }

    public boolean editEducation(String editName){
        boolean edit = false;
        sleep(2000);
        click(By.xpath(editButton.replace("%s",editName)));
        String editText = editName + "123";
        setText(By.cssSelector(idEduTextLevel),editText);
        if (getText(By.xpath(lblAlreadyExistsMessage)).contains("Already exists")) {
            click(By.xpath(getIdEduCancelButton));
        } else {
            click(By.xpath(idEduSaveButton));
        }
        if(isElementVisible(By.xpath(editToast))) {
            edit = true;
        }
        return edit;
    }

    public boolean deleteByCheckbox(String educationName){
        boolean delete = false;
        sleep(2000);
        click(By.xpath(checkBoxBtn.replace("%s",educationName)));
        click(By.xpath(deleteBtn));
        click(By.cssSelector(confirmDelButton));
        if(isElementVisible(By.xpath(deleteToast))){
            delete = true;
        }
        return delete;
    }
}
