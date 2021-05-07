package pages;

import static org.junit.Assert.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "login")
	private WebElement btnSignIn;

	public void validarAcesso() {
		assertEquals("My Store", driver.getTitle());
	}

	public void acessarLogin() {
		btnSignIn.click();
	}
}
