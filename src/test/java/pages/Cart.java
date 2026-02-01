package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Cart {
    private final Page page;

    public Cart(Page page) {
        this.page = page;
    }
    public void selectFirstModelOption(){
       Locator cards= page.locator("li.grid__item.scroll-trigger.animate--slide-in");
    //    int count= cards.count();
       cards.nth(0).click();
       page.waitForTimeout(2000);
      
    }
public void addAllMaterialsToCart() {

    page.waitForSelector("product-info");

    String[] materials = {"Hard", "Glass", "Soft"};

    for (String material : materials) {

        Locator materialLabel = page.locator(
            "input[name='Material'][value='" + material + "'] + label"
        );

        if (materialLabel.count() == 0) {
            System.out.println(material + " not available");
            continue;
        }

        // Scroll label into view
        materialLabel.first().scrollIntoViewIfNeeded();

        // Click label (NOT input)
        materialLabel.first().click();

        // Add to cart
        page.locator("button[name='add']").click();

        // Wait for cart drawer
        page.waitForSelector("button.drawer__close");

        // Close cart drawer
        page.locator("button.drawer__close").click();

        // Wait for UI to stabilize
        page.waitForSelector("product-info");

        System.out.println(material + " added to cart");
    }
}
public void OpenCart(){
 page.navigate("https://casekaro.com/cart");
}
//now select all the element in the cart and now
public boolean  validateThreeItemsInCart() {
        page.navigate("https://casekaro.com/cart");
    page.waitForSelector("h1");

    Locator allItems = page.locator("tr.cart-item");

    int visibleCount = 0;

    for (int i = 0; i < allItems.count(); i++) {
        if (allItems.nth(i).isVisible()) {
            visibleCount++;
        }
    }

    System.out.println("Visible items found in cart: " + visibleCount);

    if (visibleCount == 3) {
        System.out.println("PASS: Exactly 3 visible items present in cart");
    } else {
        System.out.println("FAIL: Expected 3 items but found " + visibleCount);
    }
    return visibleCount==3;
}
public void printCartItemDetails() {

       Locator cartItems = page.locator("tr.cart-item");

    int itemNumber = 1;

    for (int i = 0; i < cartItems.count(); i++) {

        Locator item = cartItems.nth(i);

        if (!item.isVisible()) {
            continue;
        }

        String details = item.innerText();
        String link = item.locator("a").first().getAttribute("href");

        System.out.println("------------ CART ITEM " + itemNumber + " ------------");
        System.out.println("Details :\n" + details);
        System.out.println("Link    : https://casekaro.com" + link);

        itemNumber++;
    }
    }

}

