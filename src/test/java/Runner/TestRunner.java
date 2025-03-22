package Runner;


import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {".\\src\\test\\resources\\features\\Homepage.feature",
				".\\src\\test\\resources\\features\\searchpage.feature",
				".\\src\\test\\resources\\features\\productdetailpage.feature",
				".\\src\\test\\resources\\features\\shoppingcartpage.feature",
				".\\src\\test\\resources\\features\\invalidlogincredentialspage.feature",
				//".\\src\\test\\resources\\features\\userregistrationandloginpage.feature",
				
		},
		glue = {"stepDefinations","Hooks",},
		plugin = {"pretty","html:reports/HTMLReports.html",
				"json:reports/json-report.json",
				"junit:reports/junit_report.xml",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		},
		dryRun = false
		)

@Test
public class TestRunner extends AbstractTestNGCucumberTests{

}
