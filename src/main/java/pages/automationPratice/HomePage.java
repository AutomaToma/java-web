package pages.automationPratice;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import beans.ValuesHelper;
import pages.BasePage;


public class HomePage extends BasePage {

	ValuesHelper values = new ValuesHelper();
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "login")
	private WebElement btnSignIn;
	
	@FindBy(xpath="//div[@id='layer_cart']//h2[contains(., 'Product successfully added to your shopping cart')]")
	private WebElement lblProdutoAdicionado;
	
	@FindBy(xpath = "//span[ends-with(text(), 'Proceed to checkout')]")
	private WebElement btnProceedCheckout;
	
	public void validarAcesso() {
		assertEquals("My Store", driver.getTitle());
	}

	public void acessarLogin() {
		btnSignIn.click();
	}
	
	public void clickBtnAddToCart(String nomeDoProduto){

		Actions actions = new Actions(driver);		
//		WebElement nomeProduto = driver.findElement(By.xpath("//li[contains(@class, 'last-item-of-mobile-line')]//a[contains(text(), '" + nomeDoProduto +"')]"));
		WebElement nomeProduto = driver.findElement(By.xpath("(//h5[@itemprop='name']//a[contains(text(), '"+nomeDoProduto+"')])[1]"));
//		WebElement precoProduto = nomeProduto.findElement(By.xpath("//..//..//..//span[@itemprop='price']"));
//		String precoTratado = precoProduto.getText().trim().replace("$", "");		
//		JavascriptExecutor js = (JavascriptExecutor) driver;		
//		values.setValorProduto(precoTratado);		
//		actions.moveToElement(nomeProduto).build().perform();
//		WebElement btnAddToCart = nomeProduto.findElement(By.xpath("//..//..//div[@class='button-container']//span[text()='Add to cart']"));
//		js.executeScript("arguments[0].scrollIntoView();", btnAddToCart);
		
		nomeProduto.click();
	}

	public void validarItemAdicionadoCarrinho(){
		assertTrue(lblProdutoAdicionado.isDisplayed());
	}
	
	public void clickProcederCheckout(){
		btnProceedCheckout.click();
	}
}
