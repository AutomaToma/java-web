package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static config.Driver.getDriver;

import java.text.DecimalFormat;

import beans.ValuesHelper;

public class ComprasPage extends BasePage {
	
	public ComprasPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	static ValuesHelper helper = new ValuesHelper();
	
	@FindBy(xpath = "//h1[@itemprop='name']")
	private WebElement tituloProduto;
	
	@FindBy(id = "our_price_display")
	private WebElement valorUnitario;
	
	@FindBy(id = "quantity_wanted")
	private WebElement inputQuantity;
	
	@FindBy(id = "group_1")
	private WebElement selectTamanho;
	
	@FindBy(name = "Submit")
	private WebElement btnAddToCart;
	
	@FindBy(xpath = "(//h2)[1]")
	private WebElement mensagemSucessoCarrinho;
	
	@FindBy(id = "layer_cart_product_title")
	private WebElement nomeProduto;
	
	@FindBy(id = "layer_cart_product_price")
	private WebElement precoUnitarioCarrinho;
	
	@FindBy(xpath = "//span[@class='ajax_cart_shipping_cost']")
	private WebElement valorFreteCarrinho;
	
	@FindBy(xpath = "//span[@class='ajax_block_cart_total']")
	private WebElement valorTotalCarrinho;
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	private WebElement btnProceedToCheckout;
	
	// --- METÓDOS --- //
	
	public void validarInformacoesProduto(String nomeProduto) throws Exception {	
		Assert.assertEquals(nomeProduto, tituloProduto.getText());
		helper.setValorProduto(valorUnitario.getText().replace("$", ""));
	}
	
	public void inserirInformacoesDeCompra() {
		inputQuantity.clear();
		inputQuantity.sendKeys("1");
		selecionarPorTexto(selectTamanho, "M");		
		WebElement cor = getDriver().findElement(By.xpath("//a[@name='White']"));	
		cor.click();
		btnAddToCart.click();
	}
	
	public void validarProdutoAdicionadoAoCarrinho(String nomeProduto) {
		pietro(2000);
		Assert.assertEquals(nomeProduto, this.nomeProduto.getText());
		Assert.assertEquals(helper.getValorProduto(), precoUnitarioCarrinho.getText().replace("$", ""));
		helper.setValorFrete(valorFreteCarrinho.getText().replace("$", ""));
		float valorTotal = Float.parseFloat(valorTotalCarrinho.getText().replace("$", ""));
		helper.setValorTotal(String.valueOf(String.format("%.2f", valorTotal)));
		Assert.assertEquals(String.valueOf(helper.somarValorTotal(helper.getValorProduto(), helper.getValorFrete())), String.valueOf(valorTotal));
		btnProceedToCheckout.click();
	}
}
