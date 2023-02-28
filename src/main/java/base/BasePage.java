package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import utils.ConfigFileReader;

public class BasePage
{

    public static WebDriver driver;

    public static void initializeDriver()
    {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();

        //Launch browser
        String env = ConfigFileReader.getInstance().getEnv();
        String urlEnv = ConfigFileReader.getInstance().getURL(env);
        driver.get(urlEnv);

        // Timeouts
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

    }


}
