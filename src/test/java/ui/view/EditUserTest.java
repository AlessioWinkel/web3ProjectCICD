package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EditUserTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverHelper.getDriver();
    }

    @After
    public void clean() {
    }

    @Test
    public void given_allFieldsFilledInCorrectly_when_userUpdate_Then_User_Is_Updated() {

        EditUserPage editUserPage = PageFactory.initElements(driver, EditUserPage.class);
        String veranderdeNaam = "veranderd12342112212121";
        editUserPage.setFirstName(veranderdeNaam);
        editUserPage.setLastName("winkel");
        editUserPage.setEmail("test3@gmail.com");


        editUserPage.edit();

        UserOverviewPage userOverviewPage = PageFactory.initElements(driver, UserOverviewPage.class);
        assertEquals("Bekijk alle users", userOverviewPage.getTitle());
        assertTrue(userOverviewPage.containsUserWithName(veranderdeNaam));
    }

    @Test
    public void given_Error_When_Same_Email_Used() {

        EditUserPage editUserPage = PageFactory.initElements(driver, EditUserPage.class);
        String veranderdeNaam = "veranderd12342112212121";
        editUserPage.setFirstName(veranderdeNaam);
        editUserPage.setLastName("winkel");
        editUserPage.setEmail("test@gmail.com");


        editUserPage.edit();
        assertTrue(editUserPage.hasErrorMessage("Er is al een account met dezelfde mail."));
    }
}
