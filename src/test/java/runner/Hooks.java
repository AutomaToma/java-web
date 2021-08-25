package runner;

import config.Driver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.HomePage;

public class Hooks extends Driver {

	HomePage home = new HomePage(); 
			
	@Before
	public void setup() {
		getDriver();
		home.acessarUrl();
		
	}
	
	@After
	public void tearDown() {
		finish();
	}
}
