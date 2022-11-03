package ui.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProjectPage extends Page{

    @FindBy(id="projectNaam")
    private WebElement projectNaamField;

    @FindBy(id="start")
    private WebElement startField;

    @FindBy(id="einde")
    private WebElement eindeField;

    @FindBy(id="signUp")
    private WebElement submitButton;


    public AddProjectPage(WebDriver driver) {
        super(driver);
        this.driver.get(Config.BASE_URL+"Groep3_1_war_exploded/Controller?command=addProjectPage");
    }

    public void setProjectNaam(String projectNaam) {
        projectNaamField.clear();
        projectNaamField.sendKeys(projectNaam);
    }

    public void setStart(String start) {
        startField.clear();
        startField.sendKeys(start);
    }

    public void setEinde(String einde) {
        eindeField.clear();
        eindeField.sendKeys(einde);
    }

    public void add() {
        submitButton.click();
    }

    public boolean hasErrorMessage (String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
    }

    public boolean hasEmptyProjectNaam () {
        return projectNaamField.getAttribute("value").isEmpty();
    }
    public boolean hasEmptyStart () {
        return startField.getAttribute("value").isEmpty();
    }
    public boolean hasEmptyEinde () {
        return eindeField.getAttribute("value").isEmpty();
    }
}
