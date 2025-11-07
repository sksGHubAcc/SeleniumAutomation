
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "json:target/cucumber.json", "pretty",
                "html:target/cucumber-reports.html","junit:target/cucumber-results.xml" },
        features="src/main/resources/features",
        glue = "steps"
        //,tags ="@Test"
        //,dryRun= true
)


public class RunCucumberTest {
}
