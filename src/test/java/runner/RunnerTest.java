package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	snippets = SnippetType.UNDERSCORE,
	features = {"classpath:features"},
	glue = {"steps","runner"},
	tags = {"@AUT-01"}
)
public class RunnerTest {
	
}
