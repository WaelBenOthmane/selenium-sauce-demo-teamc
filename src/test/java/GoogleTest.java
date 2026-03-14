import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;

public class GoogleTest {


    @Test
    @Parameters({"browser"})
    public static void openGoogle(String browser) throws Exception {

        String username = System.getenv("SAUCE_USERNAME");
        String accessKey = System.getenv("SAUCE_ACCESS_KEY");

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserName", browser);
        caps.setCapability("browserVersion", "latest");
        caps.setCapability("platformName", "Windows 11");
        caps.setCapability("name", "Google Test");
        caps.setCapability("build", "TeamCity Build");

        WebDriver driver = new RemoteWebDriver(
                new URL("https://" + username + ":" + accessKey +
                        "@ondemand.eu-central-1.saucelabs.com/wd/hub"),
                caps);

        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        System.out.println("Title of the page is: " + driver.getTitle());

        driver.quit();

    }
}