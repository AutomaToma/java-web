package pages;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CadastroPage extends BasePage {
	public CadastroPage() {
		PageFactory.initElements(driver, this);
	}

	// TEXTO

	@FindBy(className = "page-subheading")
	private WebElement titaccount;

	@FindBy(className = "info-account")
	private WebElement titInfoConta;

	// BUTTON
	@FindBy(id = "SubmitCreate")
	private WebElement criarconta;

	@FindBy(id = "submitAccount")
	private WebElement btnRegister;

	// RADIO BUTTON
	@FindBy(xpath = "//input[@id='id_gender1']")
	private WebElement inputGeneroMasculino;

	@FindBy(xpath = "//input[@id='id_gender2']")
	private WebElement inputGeneroFeminino;

	// SELECT
	@FindBy(id = "days")
	private WebElement selectDays;

	@FindBy(id = "months")
	private WebElement selectMonths;

	@FindBy(id = "years")
	private WebElement selectYears;

	@FindBy(id = "id_state")
	private WebElement selectState;

	@FindBy(id = "id_country")
	private WebElement selectCountry;

	// INPUT TEXT

	@FindBy(id = "email_create")
	private WebElement emailaddress;

	@FindBy(xpath = "//h3[text()='Your personal information']")
	private WebElement titinfopessoal;

	@FindBy(name = "customer_firstname")
	private WebElement inputFirstName;

	@FindBy(name = "customer_lastname")
	private WebElement inputLastName;

	@FindBy(id = "email")
	private WebElement inputEmail;

	@FindBy(id = "passwd")
	private WebElement inputPassword;

	@FindBy(name = "firstname")
	private WebElement inputAddressFirstName;

	@FindBy(name = "lastname")
	private WebElement inputAdressLastName;

	@FindBy(id = "company")
	private WebElement inputCompany;

	@FindBy(id = "address1")
	private WebElement inputAdress;

	@FindBy(id = "city")
	private WebElement inputCity;

	@FindBy(id = "postcode")
	private WebElement inputZipCode;

	@FindBy(id = "other")
	private WebElement inputAdditionalInfo;

	@FindBy(id = "phone")
	private WebElement inputHomePhone;

	@FindBy(id = "phone_mobile")
	private WebElement inputMobilePhone;

	@FindBy(id = "alias")
	private WebElement inputAlias;

	// --- Methods ---- //

	public void validarPagCadastro() {
		assertEquals("CREATE AN ACCOUNT", titaccount.getText());
	}

	public void inserirEmail(String email) {
		emailaddress.sendKeys(email);

	}

	public void cliqueBtnCriarConta() {
		criarconta.click();
	}

	public void validarInfoPessoal() {
		assertEquals("YOUR PERSONAL INFORMATION", titinfopessoal.getText());
	}

	public void realizarCadastro(String nome1, String sobrenome1, String email, String senha, String dia, String mes,
			String ano, String nome2, String sobrenome2, String empresa, String endereco, String cidade, String estado,
			String cep, String pais, String infoAdicional, String telefoneFixo, String celular,
			String apelidoEndereco) {

		inputGeneroMasculino.click();
		inputFirstName.sendKeys(nome1);
		inputLastName.sendKeys(sobrenome1);
		inputEmail.clear();
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(senha);

		selecionarPorValue(selectDays, dia);
		selecionarPorValue(selectMonths, mes);
		selecionarPorValue(selectYears, ano);

		inputAddressFirstName.clear();
		inputAddressFirstName.sendKeys(nome2);
		inputAdressLastName.clear();
		inputAdressLastName.sendKeys(sobrenome2);
		inputCompany.sendKeys(empresa);
		inputAdress.sendKeys(endereco);
		inputCity.sendKeys(cidade);

		selecionarPorTexto(selectState, estado);

		inputZipCode.sendKeys(cep);

		selecionarPorTexto(selectCountry, pais);

		inputAdditionalInfo.sendKeys(infoAdicional);

		inputHomePhone.sendKeys(telefoneFixo);
		inputMobilePhone.sendKeys(celular);
		inputAlias.sendKeys(apelidoEndereco);

		btnRegister.click();
	}

	public void validarContaCriada() {
		Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.",
				titInfoConta.getText());
	}

}
