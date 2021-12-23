package ANZRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="FeatureFiles/ANZ.feature", 
							glue="ANZStepDefinition", dryRun = false, plugin= {"html:Report/WebReport"})

public class AnzRunner {

}
