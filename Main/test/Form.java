import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ConfirmationPage;
import pages.formPage;

import static org.junit.Assert.assertEquals;

public class Form {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:/Projects/Selenium Automation Testing/Chrome Driver/chromedriver.exe"); // Need to use chromedriver location on the computer
        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form"); //Using formy project forms

        formPage formpage = new formPage();
        formpage.submitForm(driver);

        ConfirmationPage confirmationPage = new ConfirmationPage();

        confirmationPage.waitForAlertBanner(driver);

        assertEquals("The form was successfully submitted!", confirmationPage.getAlertBannerText(driver));

        driver.quit();
    }

}
