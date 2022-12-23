package ui.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class WorkOrderOverviewPage extends Page{

    @FindBy(id="email")
    private WebElement emailInput;
    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(id="logIn")
    private WebElement logInButton;

    @FindBy(id="workOrderPageButton")
    private WebElement workOrderPageButton;

    @FindBy(id="sortWorkOrders")
    private WebElement sortButton;

    public WorkOrderOverviewPage(WebDriver driver) {
        super(driver);
        this.driver.get(Config.BASE_URL+"Groep3_1_war_exploded/Controller?command=workOrderOverviewPage");
    }

    public void sort() {
        sortButton.click();
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

    public void goToWorkOrderPage() {
        workOrderPageButton.click();
    }

    public boolean containsWorkOrderWithName(String name) {
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) this.driver.findElements(By.cssSelector("p"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(name)) {
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
