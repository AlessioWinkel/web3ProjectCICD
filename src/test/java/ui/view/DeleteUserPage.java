package ui.view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class DeleteUserPage extends Page{
    @FindBy(id="verwijderConfirmatie")
    private WebElement deleteButton;


    public DeleteUserPage(WebDriver driver) {
        super(driver);
        this.driver.get(Config.BASE_URL+"Groep3_1_war_exploded/Controller?command=verwijderConfirmatie&id=55&firstName=testuser");

    }

    public void delete() {
        deleteButton.click();
    }


}
