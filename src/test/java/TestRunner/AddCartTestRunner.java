package TestRunner;

import Base.Setup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;

public class AddCartTestRunner extends Setup {

    ShoppingCartPage shoppingCartPage;
    @Test
    public void doAddCart() throws InterruptedException {
        driver.get("https://www.ajkerdeal.com/");
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.addToCart();
        Assert.assertTrue(shoppingCartPage.productFound());
    }
}