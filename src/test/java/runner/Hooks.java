package runner;

import config.Driver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.automationPratice.HomePage;

public class Hooks extends Driver {

	HomePage home = new HomePage(); 
			
	@Before
	public void setup() {
		getDriver();
		home.acessarUrl();


		//Criar um parametro para acessar a url que for ser usada




		
	}
	
	@After
	public void tearDown() {
		finish();
	}
}
