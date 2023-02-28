package steps;

import base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverFactory;

public class Hooks {
    /*
    @Before
    public void setUp(){
        DriverFactory.getDriver();
    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)DriverFactory.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"Image/png", "screenshot");

        }
        DriverFactory.closeDriver();
    }
    */

    @After
    public static void tearDown(Scenario scenario) {

        //validate if scenario has failed
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        BasePage.driver.quit();
    }
}
