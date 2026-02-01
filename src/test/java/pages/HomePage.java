package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
    
    private final Page page;
    private static final String URL="https://casekaro.com/";
    private static final String MOBILE_TEXT="Mobile Covers @ 69";
    private static final String SEARCH_HOMEPAGE_HEADER="Search";
    private static final String TEXT_HOMEPAGE_PLACEHOLDER="Search";
    public HomePage(Page page) {
        this.page=page;
    }
    public void navigateToHome()
    {
        page.navigate(URL);
    }
    public void clickOnMobileCovers(){
        // var locator=page.getByText(name);
        // locator.click();
        //we can use first as it is ambiguios
       Locator locator=page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(MOBILE_TEXT));
       locator.click();
    }
    public void BrandSearch(String text){
        Locator locator=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName(SEARCH_HOMEPAGE_HEADER));
        locator.click();
        //Why i got the problem of having the placeholder with similar search name thats why
        locator=page.getByPlaceholder(TEXT_HOMEPAGE_PLACEHOLDER,new Page.GetByPlaceholderOptions().setExact(true));
        locator.fill(text);
        locator.press("Enter");
        page.waitForTimeout(3000);
    }
}
