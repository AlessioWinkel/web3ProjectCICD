package ui.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditUserPage extends Page{


    @FindBy(id="firstNameInput")
    private WebElement firstNameField;

    @FindBy(id="lastNameInput")
    private WebElement lastNameField;

    @FindBy(id="emailInput")
    private WebElement emailField;

    @FindBy(id="teamInput")
    private WebElement teamField;

    @FindBy(id="roleInput")
    private WebElement roleField;

    @FindBy(id="update")
    private WebElement updateButton;



    public EditUserPage(WebDriver driver) {
        super(driver);
        this.driver.get(Config.BASE_URL+"Groep3_1_war_exploded/Controller?command=editPage&id=29&lastName=winkel&firstName=alessio&email=test@gmail.com");
    }


    public void setFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void setEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void setTeam(String team) {
        teamField.clear();
        teamField.sendKeys(team);
    }

    public void setRole(String role) {
        roleField.clear();
        roleField.sendKeys(role);
    }


    public boolean hasErrorMessage (String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
    }

    public void edit() {
        updateButton.click();
    }

    public boolean hasEmptyFirstName () {
        return firstNameField.getAttribute("value").isEmpty();
    }
    public boolean hasEmptyLastName () {
        return lastNameField.getAttribute("value").isEmpty();
    }
    public boolean hasEmptyEmail () {
        return emailField.getAttribute("value").isEmpty();
    }

}
