package uolinc.home;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageAssert extends AbstractAssert<HomePageAssert, HomePage> {

    protected HomePageAssert(HomePage homePage) {
        super(homePage, HomePageAssert.class);
    }

    public HomePageAssert hasLink(String... values) {
        assertThat(getLinkNames()).contains(values);
        return this;
    }

    public HomePageAssert hasNoLink(String... values) {
        assertThat(getLinkNames()).doesNotContain(values);
        return this;
    }
    
    public HomePageAssert greetTheRightTeam(String value) {
        assertThat(actual.getHeader().getText()).contains(value);
        return this;
    }

    private List<String> getLinkNames() {
        List<WebElement> links = actual.getLinks();
        return links.stream().map(e -> e.getText()).collect(Collectors.toList());
    }
}
