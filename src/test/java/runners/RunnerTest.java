package test.java.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"steps"},
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

        monochrome = true,
dryRun = false)



public class RunnerTest {
//    @AfterClass
//    public static void writeExtentReport() {
//
//    }
}
