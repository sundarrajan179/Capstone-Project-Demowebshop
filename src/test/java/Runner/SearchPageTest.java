package Runner;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {
				".\\src\\test\\resources\\features\\searchpage.feature"},
		glue = {"stepDefinations","Hooks",},
		plugin = {"pretty","html:reports/HTMLReports.html",
				"json:reports/json-report.json",
				"junit:reports/junit_report.xml",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		},
		dryRun = false
		)
public class SearchPageTest extends AbstractTestNGCucumberTests {

}
