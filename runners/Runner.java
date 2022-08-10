package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_definitions",//src/test/resources/ we did delete bc given error same times
        tags = "@exaplesTable",//or @regression", // we are filtering now //it triggers only two of them//tags = "@smokeTest and @regression" you can use and as well
        dryRun = false,//make sure if you need use true
        plugin = {"json:target/report.json","rerun:target/failed.txt"}//json is a file format. // target comes from on the leftside target folder
)
public class Runner {
}
