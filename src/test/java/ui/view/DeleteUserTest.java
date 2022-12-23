package ui.view;

import domain.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteUserTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverHelper.getDriver();
    }

    @After
    public void clean() {
    }

    @Test
    public void delete_works() {
        SearchProjectPage searchProjectPage = PageFactory.initElements(driver, SearchProjectPage.class);
        searchProjectPage.setEmailInput("director@ucll.be");
        searchProjectPage.setPasswordInput("t");
        searchProjectPage.logIn();
        DeleteUserPage deleteUserPage = PageFactory.initElements(driver, DeleteUserPage.class);


        deleteUserPage.delete();
        UserOverviewPage userOverviewPage = PageFactory.initElements(driver, UserOverviewPage.class);
        assertTrue(userOverviewPage.doesNotContainUserWithName("testuser"));

    }

    @Test
    public void not_authorized_login_failed() {
        SearchProjectPage searchProjectPage = PageFactory.initElements(driver, SearchProjectPage.class);
        searchProjectPage.setEmailInput("directorééé@ucll.be");
        searchProjectPage.setPasswordInput("t");
        searchProjectPage.logIn();


        assertTrue(searchProjectPage.containsError("No valid email/password"));
    }
}

