package ui.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterUserPage extends Page{

    @FindBy(id="firstName")
    private WebElement firstNameField;

    @FindBy(id="lastName")
    private WebElement lastNameField;

    @FindBy(id="email")
    private WebElement emailField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(id="signUp")
    private WebElement submitButton;


    public RegisterUserPage(WebDriver driver) {
        super(driver);
        this.driver.get(Config.BASE_URL+"Groep3_1_war_exploded/Controller?command=registerPage");
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

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void add() {
        submitButton.click();
    }


    public boolean hasErrorMessage (String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
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
    public boolean hasEmptyPassword () {
        return passwordField.getAttribute("value").isEmpty();
    }
}
