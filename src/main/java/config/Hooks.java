package config;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends Driver {

	@Before
	public void setup() {
		getDriver();
	}
	
	@After
	public void tearDown() {
		finish();
	}
}
