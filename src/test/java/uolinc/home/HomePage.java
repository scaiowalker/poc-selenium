package uolinc.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage {

    @FindBy(xpath = "//table//td/p/a")
    private List<WebElement> links;
    
    @FindBy(id = "header")
    private WebElement header;

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePageAssert assertThat() {
        return new HomePageAssert(this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getLinks() {
        return links;
    }

	public WebElement getHeader() {
		return header;
	}

}
