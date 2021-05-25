package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import beans.ValuesHelper;
import static org.junit.Assert.*;

public class OrderPage extends BasePage{	
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	ValuesHelper values = new ValuesHelper();
	
	@FindBy(id = "total_product")
	private WebElement lblTotalProdutos;
	
	@FindBy(xpath = "//span[text() = 'Proceed to checkout']")
	private WebElement btnProceedToCheckout;

	public void validarValorProduto(){
		assertEquals(values.getValorProduto(), lblTotalProdutos.getText());
	}
	
	public void clickProcederCheckout(){
		btnProceedToCheckout.click();
	}
}
