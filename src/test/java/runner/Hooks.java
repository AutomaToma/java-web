package runner;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import datafiles.TestDataReader;

import static config.Driver.finish;
import static config.Driver.getDriver;


public class Hooks{

	private static TestDataReader massa = new TestDataReader();

	@Before
	public void setup(Scenario cenario) {
		getDriver().get("http://automationpractice.com/index.php");

		Object[] tags = cenario.getSourceTagNames().toArray();
		String ct = "";

		for(Object tagsNovas : tags){
			ct = tagsNovas.toString().replace("@", "");
			massa.setCtKey(ct);
		}

		System.out.println("RODANDO CENÁRIO: " + ct);

	}
	
	@After
	public void tearDown() {
		finish();
	}

}
