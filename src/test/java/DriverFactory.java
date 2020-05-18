import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class DriverFactory {

    private PlatformType platformType;
    private File app;
    private URL serverUrl;

    public DriverFactory(PlatformType platformType, File app, URL serverUrl) {
        this.platformType = platformType;
        this.app = app;
        this.serverUrl = serverUrl;
    }
    public AppiumDriver<MobileElement> getDriver() {
        DesiredCapabilities dCaps = new DesiredCapabilities();
        dCaps.setCapability("app", app);

        if (platformType == PlatformType.ANDROID) {
            dCaps.setCapability("platformName", "Android");
            dCaps.setCapability("platformVersion", "9");
            dCaps.setCapability("deviceName", "Samsung S9");
            dCaps.setCapability("automationName", "UiAutomator2");
            dCaps.setCapability("udid", "5242525a44553398");
            return new AndroidDriver<MobileElement>(serverUrl, dCaps);
        } else {
            dCaps.setCapability("platformName", "iOS");
            dCaps.setCapability("platformVersion", "13.4");
            dCaps.setCapability("deviceName", "iPhone 11");
            dCaps.setCapability("automationName", "XCUITest");
            return new IOSDriver<MobileElement>(serverUrl, dCaps);
        }
    }
}
