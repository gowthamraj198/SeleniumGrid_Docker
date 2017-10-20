package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class GooglePage {

    private  WebDriver driver;
    private  WebDriverWait wait;

    @FindBy(id = "lst-ib")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchButton;


    public GooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 30);
    }

    public void goTo() {
        driver.get("https://www.google.com");
    }

    public void searchFor() throws InterruptedException {
        try {
            searchBox.sendKeys("he");
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File("image.png"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
