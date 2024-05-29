package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;

    public static String getValueFromPropertyFile(String fileName, String key)
    {
        String value ="";
        try{
            String path = System.getProperty("user.dir"+"/src/test/Properties/" +fileName+ ".properties");
            FileInputStream fin =new FileInputStream(path);
            Properties properties = new Properties();
            properties.load(fin);
            value= properties.getProperty(key);
        }
        catch (Exception e){
            System.out.println(e.toString());

        }
        return value;
    }

    public static void browserLaunch(String browser)
    {
        if(Objects.equals(browser, "Chrome"))
        {
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_vales.notifications",2);
            ChromeOptions co =new ChromeOptions();
            co.setExperimentalOption("prefs",prefs);
            WebDriverManager.chromedriver().driverVersion("125.0.6422.113").setup();
            WebDriverManager.chromedriver().setup();

            co.addArguments("--remote-allow-origins=*");


            driver= new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            driver.manage().window().maximize();


       }
        else if(Objects.equals(browser, "firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            driver.manage().window().maximize();
        }

        else if(Objects.equals(browser, "edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            driver.manage().window().maximize();

        }

    }

    public static void browserClose()
    {
        driver.quit();
    }
     public static void browserSetup()
     {

         System.setProperty("webdriver.chrome.driver", "C:/Users/Vishal/Desktop/Frameworks/Selenium/seleniumTest/src/test/resources/Properties/chromedriver.exe");

         // Create a new instance of the ChromeDriver
         WebDriver driver = new ChromeDriver();
     }
}
