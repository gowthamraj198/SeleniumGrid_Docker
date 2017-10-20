package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GooglePage;

import java.net.MalformedURLException;
import java.net.URL;

public class Test1 {

    private WebDriver driver;

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");
        DesiredCapabilities dcap = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"),dcap);
    }

    @AfterTest
    public void afterTest()
    {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        GooglePage g = new GooglePage(driver);
        g.goTo();
        g.searchFor();
    }

}
