package jieliao.page;

import java.util.HashMap;
import java.util.Map;

import jieliao.data.Account;
import jieliao.util.GeneralUtil;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AccountPage extends PageObject {
    
	@FindBy(xpath="//input[@name='firstName']")
	protected static WebElementFacade firstNameField;
	
	@FindBy(xpath="//input[@name='lastName']")
	protected static WebElementFacade lastNameField;
	
	@FindBy(xpath="//input[@name='email']")
	protected static WebElementFacade emailField;
	
	@FindBy(xpath="//input[@name='password']")
	protected static WebElementFacade passwordField;
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	protected static WebElementFacade confirmPasswordField;
	
	@FindBy(xpath="//div[@data-testid='accreditedRadioGroup']/input[@data-testid='accreditedOptionYes']")
	protected static WebElementFacade accreditedYesRadioButton;
	
	@FindBy(xpath="//input[@name='hasAgreedTos']")
	protected static WebElementFacade termsAndConditionsCheckbox;
	
	@FindBy(xpath="//span[contains(@class, 'recaptcha-checkbox')]")
	protected static WebElementFacade recaptchaCheckbox;
	
	@FindBy(xpath="//iframe[@title='reCAPTCHA']")
	protected static WebElementFacade reCAPTCHAFrame;
	
	@FindBy(xpath="//button[.='Create an account']")
	protected static WebElementFacade createAccountButton;
	
	private Map<String, WebElementFacade> nameElementMap;
	
	private Account fakeAccount;
	
	private Map<String, WebElementFacade> getNameElementMap() {
		if (nameElementMap == null) {
			nameElementMap = new HashMap<>();
			
			nameElementMap.put("First name", firstNameField);
			nameElementMap.put("Last name", lastNameField);
			nameElementMap.put("Email address", emailField);
			nameElementMap.put("Password", passwordField);
			nameElementMap.put("Confirm Password", confirmPasswordField);
			nameElementMap.put("Are you an accredited invester|Yes", accreditedYesRadioButton);
			nameElementMap.put("I have read and accepted the terms and conditions", termsAndConditionsCheckbox);
			nameElementMap.put("Create an account", createAccountButton);
		}
		
		return nameElementMap;
	}
	
	private Account getAccount() {
		if (fakeAccount == null) {
			fakeAccount = GeneralUtil.generateFakeAccount();
		}
		
		return fakeAccount;
	}
	
	public boolean isFirstNameFieldVisible() {
		return firstNameField.isVisible();
	}
	
	public void enterValueToField(String fieldName, String value) {
		Map<String, WebElementFacade> map = getNameElementMap();
		
		WebElementFacade element = map.get(fieldName);
		if (element == null) {
			throw new RuntimeException("Cannot find element: " + fieldName);
		}
		
		if (value == null) {
			Account account = getAccount();
			switch(fieldName) {
			    case "First name":
			    	value = account.firstName;
			    	break;
			    case "Last name":
			        value = account.lastName;
			        break;
			    case "Email address":
			    	value = account.email;
			    	break;
			    case "Password":
			    	value = account.password;
			    	break;
			    case "Confirm Password":
			    	value = account.password;
			    	break;
			    default:
			    	value = null;
			}
		}
		
		element.type(value);
	}
	
	public void clickRadioButton(String groupName, String option) {
        Map<String, WebElementFacade> map = getNameElementMap();
		
		WebElementFacade element = map.get(groupName + "|" + option);
		if (element == null) {
			throw new RuntimeException("Cannot find element: " + groupName + "|" + option);
		}
		
		element.click();
	}
	
	public void clickCheckbox(String checkboxName) {
        Map<String, WebElementFacade> map = getNameElementMap();
		
		WebElementFacade element = map.get(checkboxName);
		if (element == null) {
			throw new RuntimeException("Cannot find element: " + checkboxName);
		}
		
		element.click();
	}
	
	public void clickButton(String buttonName) {
        Map<String, WebElementFacade> map = getNameElementMap();
		
		WebElementFacade element = map.get(buttonName);
		if (element == null) {
			throw new RuntimeException("Cannot find element: " + buttonName);
		}
		
		element.click();
	}
	
	public void clickReCaptchaCheckbox() {
		getDriver().switchTo().frame(reCAPTCHAFrame);
		recaptchaCheckbox.click();
		getDriver().switchTo().parentFrame();
	}
}
