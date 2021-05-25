package pages;

import static org.junit.Assert.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Authentication']")
	private WebElement titleAuthentication;
	
	@FindBy(id="email")
	private WebElement inputEmail;
	
	@FindBy(name="passwd")
	private WebElement inputSenha;
	
	@FindBy(id="SubmitLogin")
	private WebElement btnSignIn;
	
	public void validarSignInPage() {
		assertTrue(titleAuthentication.isDisplayed());
	}
	
	public void loginComDadosValidos(String email, String senha){
		inputEmail.sendKeys(email);
		inputSenha.sendKeys(senha);
		btnSignIn.click();
	}
	
}
