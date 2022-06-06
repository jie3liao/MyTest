package jieliao.step;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jieliao.page.AccountPage;
import jieliao.page.LandingPage;

public class AccountStep {
	
	private LandingPage landingPage;
	private AccountPage accountPage;
	
	@Given("user is on the landing page")
	public void user_is_on_the_landing_page() {
		landingPage.gotoLandingPage();
	}

	@When("user clicks the account creating button")
	public void user_clicks_the_account_creating_button() {
		landingPage.clickAccountCreatingButton();
	}
	
	@Then("verify the account creating page is displayed")
	public void verify_the_account_creating_page_is_displayed() {
		assertTrue(accountPage.isFirstNameFieldVisible());
	}
	
	@When("user enters {string} value on account creating page")
	public void user_enters_value_on_account_creating_page(String name) {
		accountPage.enterValueToField(name, null);
	}
	
	@When("user selects {string} radio button {string} on account creating page")
	public void user_selects_radio_button_on_account_creating_page(String name, String value) {
		accountPage.clickRadioButton(name, value);
	}
	
	@When("user selects {string} checkbox on account creating page")
	public void user_selects_checkbox_on_account_creating_page(String name) {
		accountPage.clickCheckbox(name);
	}
	
	@When("user confirms not robot in CAPTCHA on account creating page")
	public void user_confirms_not_robot_in_captcha_on_account_creating_page() {
		accountPage.clickReCaptchaCheckbox();
	}
	
	@When("user clicks {string} button on account creating page")
	public void user_clicks_button_on_account_creating_page(String name) {
	    accountPage.clickButton(name);
	}
	
	@Then("verify the account is created successfully")
	public void verify_the_account_is_created_successfully() {
		assertTrue(landingPage.isSignOutButtonVisible());
	}

}
