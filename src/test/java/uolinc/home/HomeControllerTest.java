package uolinc.home;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uolinc.Application;
import uolinc.selenium.support.SeleniumTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(value = "server.port=9000")
@SeleniumTest(driver = ChromeDriver.class, baseUrl = "http://localhost:9000")
public class HomeControllerTest {

    @Autowired
    private WebDriver driver;

    private HomePage homePage;

    @Before
    public void setUp() throws Exception {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void containsLinks() {
        homePage.assertThat()
                .hasLink("roma", "mordor", "gondor")
                .hasNoLink("dubai");
    }
    
    @Test
    public void greetTheRightTeam() {
        homePage.assertThat().greetTheRightTeam("ROMA");
    }

    @Test
    public void failingTest() {
        homePage.assertThat()
                .hasNoLink("dubai");
    }
}