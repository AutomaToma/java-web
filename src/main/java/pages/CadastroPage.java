package pages;

import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CadastroPage extends BasePage {
	public CadastroPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy (className="page-subheading")
	private WebElement titaccount;
	
	@FindBy ( id="email_create")
	private WebElement emailaddress;
	
	@FindBy ( id="SubmitCreate")
	private WebElement criarconta;
	
	@FindBy (xpath="//h3[text()='Your personal information']" )
	private WebElement titinfopessoal;
	
	public void validarPagCadastro() {
		assertEquals("CREATE AN ACCOUNT",titaccount.getText());
		
	}
	
	public void inserirEmail(String email){
		emailaddress.sendKeys(email);
	
	}
	
	public void cliqueBtnCriarConta(){
		criarconta.click();
	}
	
	public void validarInfoPessoal() {
		assertEquals("YOUR PERSONAL INFORMATION",titinfopessoal.getText());
	}
}
