import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import viewObjects.LoggedInView;
import viewObjects.LoginView;
import viewObjects.MainView;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public abstract class BaseTest {

    private AppiumDriver driver;
    private PlatformType platform;
    private final String appiumUrl = "http://127.0.0.1:4723/wd/hub";

    protected MainView mainView;
    protected LoginView loginView;
    protected LoggedInView loggedInView;

    public BaseTest() {
        /* one thing that bugged me was System wasn't defined anywhere.
         * it seems like it's part of Java that is defined and can't be
         * changed.  In this situation the build.gradle file will be the source
         * of the 'platformType' but I don't really understand the why involved.
         */
        String cliArg = System.getProperty("platformType");
        if (cliArg == null) {
            // default to ios if no one set the platform type
            cliArg = "ios";
        }
        if (cliArg.equalsIgnoreCase(PlatformType.ANDROID.name())) {
            platform = PlatformType.ANDROID;
        } else {
            platform = PlatformType.IOS;
        }
    }

    private File getAppFile(String app) throws URISyntaxException {
        URL resource = getClass().getClassLoader()
                .getResource("apps/"+app);
        return Paths.get(resource.toURI()).toFile();
    }

    @Before
    public void setUp() throws MalformedURLException, URISyntaxException {
        File app = getAppFile("TheApp-v1.2.1.app.zip");
        if (platform == PlatformType.ANDROID) {
            app = getAppFile("TheApp-v1.2.1.apk");
        }
        URL serverUrl = new URL(appiumUrl);
        System.out.println("serverURL is "+serverUrl);

        DriverFactory driverFactory = new DriverFactory(platform, app, serverUrl);
        driver = driverFactory.getDriver();

        /* defining all the views for the test, but I think this
         * portion should also be abstracted. It is specific to testing 'TheApp'
         * so it is not really a baseTest yet.
         */
        mainView = new MainView(driver);
        loginView = new LoginView(driver);
        loggedInView = new LoggedInView(driver);
    }

    @After
    public void tearDown() {
        try {
            driver.quit();
        } catch (Exception ignore) {}
    }

}
