package jieliao.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LandingPage extends PageObject {
	
	@FindBy(xpath="//a[.='Create An Account']")
	protected static WebElementFacade createAnAccountButton;
	
	@FindBy(xpath="//button[.='Sign Out']")
	protected static WebElementFacade signOutButton;
	
	public void gotoLandingPage() {
		getDriver().navigate().to("https://test.crowdstreet.com");
	}
	
	public void clickAccountCreatingButton() {
		createAnAccountButton.click();
	}
	
	public boolean isSignOutButtonVisible() {
		return signOutButton.isVisible();
	}
}
