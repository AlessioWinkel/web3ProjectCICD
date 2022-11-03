package ui.view;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class UserOverviewPage extends Page {

    @FindBy(id="pasAanKnop")
    private WebElement pasAanButton;

    public UserOverviewPage(WebDriver driver) {
        super(driver);
        this.driver.get(getPath()+"Groep3_1_war_exploded/Controller?command=userOverview");
    }

    public void pasAan() {
        pasAanButton.click();
    }

    public boolean containsUserWithEmail(String name) {
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(name)) {
                found=true;
            }
        }
        return found;
    }

    public boolean containsUserWithName(String name) {
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) this.driver.findElements(By.cssSelector("td"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains(name)) {
                found=true;
            }
        }
        return found;
    }
}
