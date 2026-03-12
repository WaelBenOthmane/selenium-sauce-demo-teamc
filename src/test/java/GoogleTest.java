import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class GoogleTest {

    public static void main(String[] args) throws Exception {

        String username = System.getenv("SAUCE_USERNAME");
        String accessKey = System.getenv("SAUCE_ACCESS_KEY");

        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "latest");
        options.setCapability("platformName", "Windows 11");

        WebDriver driver = new RemoteWebDriver(
                new URL("https://" + username + ":" + accessKey +
                        "@ondemand.eu-central-1.saucelabs.com/wd/hub"),
                options);

        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        System.out.println("Title of the page is: " + driver.getTitle());

        driver.quit();

    }
}