package Hooks;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.Base;

public class Hooks extends Base {
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeAll
    public static void beforeAll() {
        try {
            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void afterAll() {
        extent.flush();
        // Quit the browser after all tests finish
        if (Base.driver != null) {
         //   Base.driver.quit();
        //    Base.driver = null; // Important: Set driver to null after quitting
        }
    }

    @Before
    public void before(Scenario scenario) {
        test = extent.createTest(scenario.getName());
        System.out.println("Hooks @Before: Driver instance: " + Base.driver); // Debugging
        if (Base.driver == null) {
            getBrowser();
            getUrl();
        }

    }

    @After
    public void after(Scenario scenario) {
        System.out.println("Hooks @After: Driver instance: " + Base.driver); // Debugging
        if (scenario.isFailed()) {
            test.fail("Scenario failed: " + scenario.getName());
        } else {
            test.pass("Scenario passed: " + scenario.getName());
        }

        if (Base.driver != null) {
        //    Base.driver.quit();
        }
    }
}