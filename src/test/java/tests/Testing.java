package tests;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.Cart;
import pages.HomePage;
import pages.ProductListing;
import pages.SearchPage;
// mvn exec:java "-Dexec.mainClass=com.microsoft.playwright.CLI" "-Dexec.args=codegen"
public class Testing extends BaseTest{
    private static final String BRAND_NAME="Apple";
    @Test
    public void testCasekaroFlow()
    {
            HomePage homePage=new HomePage(page);
            homePage.navigateToHome();
            homePage.clickOnMobileCovers();
            homePage.BrandSearch(BRAND_NAME);
            SearchPage searchPage=new SearchPage(page);
            boolean result = searchPage.validateOnlyAppleResults();
            System.out.println(result);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(result, "Non-Apple results found!");
            searchPage.ClickOnTheApple();
            ProductListing ProductListing=new ProductListing(page);
            ProductListing.SelectAndClick();
            Cart cart=new Cart(page);
            cart.selectFirstModelOption();
            cart.addAllMaterialsToCart();
            assertTrue(cart.validateThreeItemsInCart(),"Items were not exactly like you added");
            cart.printCartItemDetails();

// cart.printCartItemDetails()
    }
}
