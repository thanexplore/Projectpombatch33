package pages;

import library.PageBase;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class HeaderPage extends PageBase {

    WebDriver driver;
    private String lblWelcome = "//*[@id='welcome']";
    private String menuItem = "//*[@id='app']//descendant::*[text()='XXX']";
    private String menuClassName = "oxd-main-menu-item";

    public HeaderPage(WebDriver driver) {

        super(driver);
        this.driver=driver;
    }

    public void assertWelcomeMessage(){
        Assert.assertTrue(isElementVisible(By.xpath(lblWelcome)),"Login not successful");
    }
    public void selectMenu(String menu){//Admin|Job|Job Title
        List<String> menuItems = Arrays.asList(menu.split("\\|"));
        Dimension dimension = driver.manage().window().getSize();
        log.debug("Window size height :{}, width :{}", dimension.height,dimension.width);
        int menuLevel=0;
        for (String item:menuItems){
            if(menuItems.size() > 1) {
                menuLevel++;
            }
            By byMenu = By.xpath(menuItem.replace("XXX",item));
            Rectangle rectangle = getRect(byMenu);
            log.debug("Menu item coordinates- X1:{}, Y1:{}, X2 :{}, Y2 :{}", rectangle.getX(),rectangle.getY(),
                    rectangle.getX()+rectangle.getWidth(), rectangle.getY()+rectangle.getHeight());

            mouseHover(byMenu);
            sleep(MENU_SELECTION_DELAY);
            click(byMenu);
            sleep(2000);
            if(menuLevel==1) {
                int yOffset = rectangle.getY() + rectangle.height+10;
                if(yOffset>dimension.height){
                    yOffset = dimension.height-1;
                }
                mouseMove(rectangle.getX(), yOffset);
            }
        }

    }
    public boolean isMenuVisible(){
        return isElementVisible(By.className(menuClassName));
    }

}
