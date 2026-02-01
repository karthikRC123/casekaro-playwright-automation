package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
public class SearchPage {
    private final Page page;
    public SearchPage(Page page) {
        this.page=page;
    }
    public boolean validateOnlyAppleResults() {
    // Locator cards = page.locator("div.card.article-card");
    Locator cards=page.locator("div.card__content:has(a[href^='/pages/'])");
    int count = cards.count();
    System.out.println(count);
    boolean hasInvalidBrand = false;

    for (int i = 0; i < count; i++) {
        String text=cards.nth(i).innerText();
        if (text.contains("Samsung") ||
            text.contains("Google Pixel") ||
            text.contains("OnePlus") ||
            text.contains("Xiaomi")) {

            System.out.println(" Invalid brand detected:");
            System.out.println(text);
            hasInvalidBrand = true;
        }
    }
    return !hasInvalidBrand;
}
    public void ClickOnTheApple(){
        Locator cards = page.locator("div.card__content:has(a[href^='/pages/'])");
        // cards.nth(0).click();
        // page.waitForTimeout(2000);        
        int count=cards.count();
        for(int i=0;i<count;i++){
            String text=cards.nth(i).innerText().toLowerCase();
            if(text.contains("apple") || text.contains("iphone")){
                cards.nth(i).click();
                break;
            }
            page.waitForTimeout(2100);
        }
    }
    
}
