package pages;

import static org.junit.Assert.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='My account']")
	private WebElement titleMyAccount;
	
	@FindBy(className="info-account")
	private WebElement lblWelcomeAccount;
	
	public void validarMinhaConta(){
		assertTrue(titleMyAccount.isDisplayed());
	}
	
	public void validarMensagemWelcome(){
		assertEquals(lblWelcomeAccount.getText(), "Welcome to your account. Here you can manage all of your personal information and orders.");
	}
}
