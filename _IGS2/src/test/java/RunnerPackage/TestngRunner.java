package RunnerPackage;

import org.testng.annotations.Listeners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import listeners.ExtentReportListener;
import org.testng.annotations.Listeners;
import listeners.ExtentReportListener;

@CucumberOptions(features = "src/test/java/Feature", glue = "stepDefinitions", monochrome = true, plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
@Listeners(ExtentReportListener.class)
public class TestngRunner extends AbstractTestNGCucumberTests {
}
