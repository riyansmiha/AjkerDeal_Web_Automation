package TestRunner;

import Base.Setup;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;
import utils.Utils;

import java.io.IOException;

public class SearchTestRunner extends Setup {
    SearchPage searchPage;
    @Test
    public void findProducts() throws IOException, ParseException {
        driver.get("https://www.ajkerdeal.com/");
        searchPage = new SearchPage(driver);
        String text2 = searchPage.findProducts();
        Assert.assertEquals(text2, text2);
    }
}
