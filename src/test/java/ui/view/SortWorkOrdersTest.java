package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class SortWorkOrdersTest {

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
        WorkOrderOverviewPage workOrderOverviewPage = PageFactory.initElements(driver, WorkOrderOverviewPage.class);
        workOrderOverviewPage.setEmailInput("director@ucll.be");
        workOrderOverviewPage.setPasswordInput("t");
        workOrderOverviewPage.logIn();

        workOrderOverviewPage.goToWorkOrderPage();
        workOrderOverviewPage.sort();


        assertTrue(workOrderOverviewPage.containsWorkOrderWithName("Test"));
    }

    @Test
    public void not_authorized_login_failed() {
        WorkOrderOverviewPage workOrderOverviewPage = PageFactory.initElements(driver, WorkOrderOverviewPage.class);
        workOrderOverviewPage.setEmailInput("director222222@ucll.be");
        workOrderOverviewPage.setPasswordInput("t");
        workOrderOverviewPage.logIn();


        assertTrue(workOrderOverviewPage.containsError("No valid email/password"));
    }
}
