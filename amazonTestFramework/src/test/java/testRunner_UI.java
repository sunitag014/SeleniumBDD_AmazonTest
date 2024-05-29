import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/resources/features/",
                glue = {"stepDefinitions"},
       // tags="@sanity",
        monochrome = true,
        plugin = {"pretty","html:target/HtmlReports.html",
                "json:target/JsonReports.json",
                "usage:target/usage.json",
                "timeline:target/TimelineReports",
                "rerun:target/rerun.txt"
        })
public class testRunner_UI extends AbstractTestNGCucumberTests {

}
