package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import config.Driver;

public class BasePage {
	@FindBy(xpath="//img[contains(@class, 'logo')]")
	private WebElement logo;

	WebDriver driver = Driver.getDriver();
	
	
	public void acessarUrl() {
		driver.get("http://automationpractice.com/index.php");
	}

	public void acessarUrl(String url) {
		driver.get(url);
	}
	
	public void selecionarPorValue(WebElement elemento, String valor) {
		Select selectDateDays = new Select(elemento);
		selectDateDays.selectByValue(valor);
	}
	
	public void selecionarPorTexto(WebElement elemento, String texto) {
		Select selectDateDays = new Select(elemento);
		selectDateDays.selectByVisibleText(texto);;
	}
	
	public void voltarParaHome(){
		logo.click();
	}
	
	public void pietro(int milissegundos) {
		try {
			Thread.sleep(milissegundos);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
