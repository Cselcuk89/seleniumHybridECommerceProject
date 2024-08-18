package com.selcuk.base;

import com.selcuk.actionDriver.Action;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    public static Properties prop;
    public static WebDriver driver;

    @BeforeTest
    public void loadConfig() throws IOException {
        System.out.println("Loading configuration");
        try{
            prop = new Properties();
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "Configuration/config.properties");
            prop.load(fileInputStream);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void launchApp() throws Throwable {
        System.out.println("Launching application");
        WebDriverManager.chromedriver().setup();
        String browser = prop.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("Browser not supported");

        }

    }
}
