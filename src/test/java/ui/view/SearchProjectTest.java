package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchProjectTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverHelper.getDriver();
    }

    @After
    public void clean() {
    }

    @Test
    public void given_allFieldsFilledInCorrectly_search_project() {
        SearchProjectPage searchProjectPage = PageFactory.initElements(driver, SearchProjectPage.class);
        searchProjectPage.setEmailInput("director@ucll.be");
        searchProjectPage.setPasswordInput("t");
        searchProjectPage.logIn();

        searchProjectPage.setProjectIdInput("17");

        searchProjectPage.search();


        assertTrue(searchProjectPage.containsProjectWithId("17"));
    }

    @Test
    public void login_failed_so_cant_search_project() {
        SearchProjectPage searchProjectPage = PageFactory.initElements(driver, SearchProjectPage.class);
        searchProjectPage.setEmailInput("director2123213@ucll.be");
        searchProjectPage.setPasswordInput("t");
        searchProjectPage.logIn();


        assertTrue(searchProjectPage.containsError("No valid email/password"));
    }

}
