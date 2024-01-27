package pages;


import library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

public class EducationPage extends PageBase {
    WebDriver driver;
    private final String idEduAddBtn = ".oxd-button--secondary";
    private final String idEduTxtLevel = "div[class='oxd-form-row'] input[class*='oxd-input']";
    private final String idEduSaveBtn = "//button[@type='submit']";
    private final String lblAlreadyExistsMessage = "//div[@class='oxd-form-row'] /div";
    private final String getIdEduCancelBtn = "//div[@class='oxd-form-actions'] /button[1]";
    private final String tblEducation = ".oxd-table-body";
    private final String educations = "//div[@class='oxd-table-body'] /div[@class='oxd-table-card']";
    @FindBy(xpath = educations)
    private List<WebElement> listEducations;

    public EducationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void saveNewEducation(String educationName) {
        click(By.cssSelector(idEduAddBtn));
        setText(By.cssSelector(idEduTxtLevel), educationName);
        if (getText(By.xpath(lblAlreadyExistsMessage)).contains("Already exists")) {
            click(By.xpath(getIdEduCancelBtn));
        } else {
            click(By.xpath(idEduSaveBtn));
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

    public void deleteEducation(String deleteName) {
        sleep(2000);
        WebElement EducationName = driver.findElement(By.xpath("//div[text() = \"" + deleteName +"\"]/following::div[1]/descendant::button[1]"));
        EducationName.click();
        WebElement deleteBtn = driver.findElement(By.xpath("//button[@class = 'oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']"));
        deleteBtn.click();
    }

    public void editEducation(String editName){
        sleep(2000);
        WebElement EducationName = driver.findElement(By.xpath("//div[text() = \""+editName+"\"/following::div[2]/descendant::button[2]"));
        EducationName.click();
        sleep(2000);
        WebElement editTxt = driver.findElement(By.cssSelector(idEduTxtLevel));
        editTxt.clear();
        String uuid = UUID.randomUUID().toString();
        editTxt.sendKeys(editName + uuid);
        if (getText(By.xpath(lblAlreadyExistsMessage)).contains("Already exists")) {
            click(By.xpath(getIdEduCancelBtn));
        } else {
            click(By.xpath(idEduSaveBtn));
        }
    }

    public void deleteByCheckbox(String delCheckbox){
        sleep(2000);
        WebElement checkBoxBtn = driver.findElement(By.xpath("//div[text() = \""+delCheckbox+"\"]//preceding::span[1]"));
        checkBoxBtn.click();
        WebElement deleteBtn = driver.findElement(By.xpath("//Button[text() = ' Delete Selected ']"));
        deleteBtn.click();
        WebElement confirmBtn = driver.findElement(By.xpath("//Button[text() = ' Yes, Delete ']"));
        confirmBtn.click();
    }
}
