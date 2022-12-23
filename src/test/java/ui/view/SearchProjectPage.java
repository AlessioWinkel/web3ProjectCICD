package ui.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class SearchProjectPage extends Page{

    @FindBy(id="email")
    private WebElement emailInput;
    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(id="logIn")
    private WebElement logInButton;

    @FindBy(id="projectIdInput")
    private WebElement projectIdInput;
    @FindBy(id="searchProject")
    private WebElement searchButton;

    public SearchProjectPage(WebDriver driver) {
        super(driver);
        this.driver.get(Config.BASE_URL+"Groep3_1_war_exploded/Controller?command=Home");
    }

    public void setProjectIdInput(String id) {
        projectIdInput.clear();
        projectIdInput.sendKeys(id);
    }

    public void setEmailInput(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void setPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void logIn() {
        logInButton.click();
    }

    public void search() {
        searchButton.click();
    }

    public boolean containsProjectWithId(String id) {
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(id)) {
                found=true;
            }
        }
        return found;
    }

    public boolean containsError(String error) {
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) this.driver.findElements(By.cssSelector("li"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(error)) {
                found=true;
            }
        }
        return found;
    }

}
