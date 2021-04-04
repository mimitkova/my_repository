package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public abstract class TestBase {
	
	protected static WebDriver driver = null;

	protected static Properties config = null;
	
	public static boolean isBrowserOpened = false;
	
	
	protected TestBase() throws Exception {
		initConfig();
		initDriver();
		openBrowser();
	}
		
	//Read and load config.properties file
	private static void initConfig() {
		if (config == null) {
			Properties config_env = new Properties();
			FileInputStream ip = null;
			
			try {
				ip = new FileInputStream(System.getProperty("user.dir")+"//src3//test//java//resources//config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				config_env.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			config = config_env;
			System.out.println("initConfigFinished");
		}
	}	
	
	//Initialize driver as per the config.properties file's browser type
	private static void initDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Mile\\chromedriver_win32/chromedriver.exe");
			if (config.getProperty("browser").equals("Mozilla")) {
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("IE")) {
				driver = new InternetExplorerDriver();
			} else if (config.getProperty("browser").equals("Chrome")) {
				driver = new ChromeDriver();
			}
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("initDriverfinished");
		}
	}
	
	//quit driver
	public static void quitDriver() {
		driver.quit();
		driver = null;
		System.out.println("Closing the Browser");
	}
	
    //Gets the config in case it is required
	public static Properties getConfig() {
		if (config == null) {
			initConfig();
		}
		return config;
	}
	
	/**
     *Gets the driver. Used to re-initialize driver in case required (example,
	 *after browser quit/crash)
	 */
	public static WebDriver getDriver() {
		if (driver == null) {
			initDriver();
		}
		return driver;
	}
	
	// selenium Webdriver open a browser if its not opened
	public static void openBrowser() {
		if (!isBrowserOpened) {
			if (config.getProperty("browser").equals("Firefox")) {
				System.out.println(config.getProperty("browser"));
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("IE"))
				driver = new InternetExplorerDriver();
			else if (config.getProperty("browser").equals("CHROME"))
				driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			isBrowserOpened = true;
			driver.navigate().to(config.getProperty("baseUrl"));
		}
	}
	
	// close browser
	public void closeBrowser() {
			driver.quit();
			isBrowserOpened = false;
	}
}
