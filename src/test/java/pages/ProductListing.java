package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
public class ProductListing{
    private static final String PLACE_HOLDER="Search";
    private static final String MODEL="iPhone 16 Pro";
    private final Page page;
    public ProductListing(Page page) {
        this.page=page;
    }
    
    public void SelectAndClick(){
        //Violation same name so use role
    //   Locator locator=page.getByPlaceholder(PLACE_HOLDER);
    Locator locator=page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName(PLACE_HOLDER));
      locator.fill(MODEL);
    //   page.waitForTimeout(2000);
    // conflict with name of pro max so set exact and text made me error of 6 conflict
    //  locator=page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(MODEL));
    locator=page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName(MODEL).setExact(true));
     locator.click();
     page.waitForTimeout(2000);
    }
}