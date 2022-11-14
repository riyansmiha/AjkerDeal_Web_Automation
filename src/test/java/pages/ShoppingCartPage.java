package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
    @FindBy(xpath = "//a[contains(text(),'ENG')]")
    public WebElement translateEng;
    @FindBy(xpath = "//button[normalize-space()='T- Shirts']")
    public WebElement clickTShirt;
    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart() throws InterruptedException {
        translateEng.click();
        clickTShirt.click();
        driver.findElement(By.cssSelector("img[src='https://static.ajkerdeal.com/images/deals/745140608183844/1_t-shirt.webp']")).click();
        driver.findElement(By.id("Size2")).click();
        driver.findElement(By.cssSelector("#\\31 389341\\  > img")).click();
        driver.findElement(By.cssSelector("img[alt='X']")).click();
        driver.findElement(By.cssSelector("img[src='https://static.ajkerdeal.com/images/desktop-home/cart.svg']")).click();
        Thread.sleep(4000);
    }
    public boolean productFound(){
        if (driver.findElement(By.cssSelector("ul[class='shopping-list'] li")).isDisplayed()){
            return true;
        }
        else {
            return false;
        }
    }
}
