package TestRunner;

import Base.Setup;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    Utils utils=new Utils();

    @Test(priority = 1)
    public void doLogin() throws IOException, ParseException, InterruptedException {
        driver.get("https://www.ajkerdeal.com/");
        loginPage = new LoginPage(driver);
        utils=new Utils();
        utils.getUserCreds(0);
        String accountName = loginPage.doLogin(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(accountName.contains("Sajib Riyan Your Account"));
    }

    @Test(priority = 2)
    public void doLoginWithWrongPassword() throws IOException, ParseException, InterruptedException {
        driver.get("https://www.ajkerdeal.com/");
        loginPage = new LoginPage(driver);
        utils=new Utils();
        utils.getUserCreds(1);
        String txt = loginPage.doLoginWithWrongPassword(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(txt, "Wrong Email Or Password");
    }

    @Test(priority = 3)
    public void doLoginWithWrongEmail() throws IOException, ParseException, InterruptedException {
        driver.get("https://www.ajkerdeal.com/");
        loginPage = new LoginPage(driver);
        utils=new Utils();
        utils.getUserCreds(2);
        String txt = loginPage.doLoginWithWrongEmail(utils.getEmail(), utils.getPassword());
        Assert.assertEquals(txt, "Wrong Email Or Password");
    }
}