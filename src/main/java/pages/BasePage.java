package pages;

import org.openqa.selenium.WebDriver;

import config.Driver;

public class BasePage {
	WebDriver driver = Driver.getDriver();

	public void acessarUrl() {
		driver.get("http://automationpractice.com/index.php");
	}

	public void acessarUrl(String url) {
		driver.get(url);
	}
}
