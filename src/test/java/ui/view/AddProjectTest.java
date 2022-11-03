package ui.view;

import domain.model.Project;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddProjectTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverHelper.getDriver();
    }

    @After
    public void clean() {
    }

    @Test
    public void given_allFieldsFilledInCorrectly_when_ProjectAdd_then_ProjectIsAdded() {
        AddProjectPage addProjectPage = PageFactory.initElements(driver, AddProjectPage.class);
        addProjectPage.setProjectNaam("testproject");
        addProjectPage.setStart("22-02-2022");
        addProjectPage.setEinde("22-02-2042");


        addProjectPage.add();

        ProjectOverviewPage projectOverviewPage = PageFactory.initElements(driver, ProjectOverviewPage.class);
        assertEquals("Bekijk alle projecten", projectOverviewPage.getTitle());
        assertTrue(projectOverviewPage.containsProjectWithName("testproject"));
    }
}
