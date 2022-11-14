package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//a[contains(text(),'ENG')]")
    public WebElement translateEng;
    @FindBy(id = "logdata")
    public WebElement linkLogin;
    @FindBy(id = "Email")
    public WebElement emailBox;
    @FindBy(id = "Password")
    public WebElement passwordBox;
    @FindBy(xpath = "//input[@value='Login']")
    public WebElement signIn;
    @FindBy(xpath = "//*[@id='logdata']/div/a")
    public WebElement hoverAccount;
    @FindBy(xpath = "//a[@onclick='Signout()']")
    public WebElement signOut;

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String doLogin(String email, String password) throws InterruptedException {
        translateEng.click();
        linkLogin.click();
        Thread.sleep(2000);
        emailBox.sendKeys(email);
        Thread.sleep(2000);
        passwordBox.sendKeys(password);
        Thread.sleep(2000);
        signIn.click();
        Thread.sleep(5000);
        String heading = driver.findElement(By.xpath("//a[contains(.,'Sajib Riyan Your Account')]")).getText();
        hoverAccount.click();
        Thread.sleep(2000);
        signOut.click();
        return heading;
    }

    public String doLoginWithWrongPassword(String email, String password) throws InterruptedException {
        translateEng.click();
        linkLogin.click();
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        Thread.sleep(2000);
        signIn.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alertMessage= driver.switchTo().alert().getText();
        alert.accept();
        return alertMessage;
    }

    public String doLoginWithWrongEmail(String email, String password) throws InterruptedException {
        translateEng.click();
        linkLogin.click();
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        Thread.sleep(2000);
        signIn.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String alertMessage= driver.switchTo().alert().getText();
        alert.accept();
        return alertMessage;
    }
}
