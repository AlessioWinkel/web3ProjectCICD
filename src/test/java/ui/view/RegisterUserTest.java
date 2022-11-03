package ui.view;

import domain.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterUserTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverHelper.getDriver();
    }

    @After
    public void clean() {
    }

    @Test
    public void given_allFieldsFilledInCorrectly_when_userRegister_then_userIsAdded() {
        RegisterUserPage registerUserPage = PageFactory.initElements(driver, RegisterUserPage.class);
        registerUserPage.setFirstName("alessio");
        registerUserPage.setLastName("winkel");
        registerUserPage.setEmail("test@gmail.com");
        registerUserPage.setPassword("testpass");

        registerUserPage.add();

        UserOverviewPage userOverviewPage = PageFactory.initElements(driver, UserOverviewPage.class);
        assertEquals("Bekijk alle users", userOverviewPage.getTitle());
        assertTrue(userOverviewPage.containsUserWithEmail("test@gmail.com"));
    }

    @Test
    public void given_error_When_FirstName_NotFilledIn() {
        RegisterUserPage registerUserPage = PageFactory.initElements(driver, RegisterUserPage.class);
        registerUserPage.setFirstName("");
        registerUserPage.setLastName("winkel");
        registerUserPage.setEmail("test@gmail.com");
        registerUserPage.setPassword("testpass");

        registerUserPage.add();

        assertEquals("Sign Up", registerUserPage.getTitle());
        assertTrue(registerUserPage.hasEmptyFirstName());
        assertTrue(registerUserPage.hasErrorMessage("No firstname given"));
    }

    @Test
    public void given_error_When_LastName_NotFilledIn() {
        RegisterUserPage registerUserPage = PageFactory.initElements(driver, RegisterUserPage.class);
        registerUserPage.setFirstName("alessio");
        registerUserPage.setLastName("");
        registerUserPage.setEmail("test@gmail.com");
        registerUserPage.setPassword("testpass");

        registerUserPage.add();

        assertEquals("Sign Up", registerUserPage.getTitle());
        assertTrue(registerUserPage.hasEmptyLastName());
        assertTrue(registerUserPage.hasErrorMessage("No last name given"));
    }

    @Test
    public void given_error_When_Email_NotFilledIn() {
        RegisterUserPage registerUserPage = PageFactory.initElements(driver, RegisterUserPage.class);
        registerUserPage.setFirstName("alessio");
        registerUserPage.setLastName("winkel");
        registerUserPage.setEmail("");
        registerUserPage.setPassword("testpass");

        registerUserPage.add();

        assertEquals("Sign Up", registerUserPage.getTitle());
        assertTrue(registerUserPage.hasEmptyEmail());
        assertTrue(registerUserPage.hasErrorMessage("No email given"));
    }
}
