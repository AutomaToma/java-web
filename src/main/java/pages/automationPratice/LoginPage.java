package pages.automationPratice;

import static config.Driver.getDriver;
import static org.junit.Assert.*;

import datafiles.TestDataReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class LoginPage extends BasePage {
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	TestDataReader massa = new TestDataReader();
	
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

	public void loginComDadosDaPlanilha(){
		inputEmail.sendKeys(massa.getDt("username"));
		inputSenha.sendKeys(massa.getDt("password"));
		btnSignIn.click();
	}
	
}
