import org.openqa.selenium.WebDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;

public class GoogleTest {

    @Test
    @Parameters({"browser"})
    public void openGoogle(String browser) throws Exception {

        String username = System.getenv("SAUCE_USERNAME");
        String accessKey = System.getenv("SAUCE_ACCESS_KEY");

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("build", "TeamCity Build");
        sauceOptions.setCapability("name", "Google Test");

        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("platformName", "Windows 10");

        capabilities.setCapability("sauce:options", sauceOptions);

        WebDriver driver = new RemoteWebDriver(
                new URL("https://" + username + ":" + accessKey +
                        "@ondemand.eu-central-1.saucelabs.com/wd/hub"),
                capabilities
        );

        driver.get("https://www.google.com");

        System.out.println(driver.getTitle());

        driver.quit();

    }
}