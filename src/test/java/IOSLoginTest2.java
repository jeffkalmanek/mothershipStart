//import io.appium.java_client.MobileBy;
//import io.appium.java_client.ios.IOSDriver;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import viewObjects.LoggedInView;
//import viewObjects.LoginView;
//import viewObjects.MainView;
//
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.nio.file.Paths;
//
//public class IOSLoginTest2 {
//
//    private IOSDriver driver;
//    private MainView mainView;
//    private LoginView loginView;
//    private LoggedInView loggedInView;
//
//    @Before
//    public void setUp() throws MalformedURLException, URISyntaxException {
//        URL appiumUrl = new URL("http://127.0.0.1:4723/wd/hub");
//        URL resource = getClass().getClassLoader()
//                .getResource("apps/TheApp-v1.2.1.app.zip");
//        File app = Paths.get(resource.toURI()).toFile();
//
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("platformName", "iOS");
//        desiredCapabilities.setCapability("platformVersion", "13.4");
//        desiredCapabilities.setCapability("deviceName", "iPhone 11");
//        desiredCapabilities.setCapability("app", app);
//        desiredCapabilities.setCapability("automationName", "XCUITest");
//
//        System.out.println("appiumURL is "+appiumUrl);
//
//        driver = new IOSDriver(appiumUrl, desiredCapabilities);
//
//        mainView = new MainView(driver);
//        loginView = new LoginView(driver);
//        loggedInView = new LoggedInView(driver);
//    }
//
//    @After
//    public void tearDown() {
//        try {
//            driver.quit();
//        } catch (Exception ignore) {}
//    }
//
//    @Test // the test tag would have multiple Scenarios, could have multiple Features
//    public void testLogin() {
//        final String username = "alice";
//        final String password = "mypassword";
//
//        // Given User start app and selects login
//        mainView.navToLogin();
//        // When User logs in with 'username' and 'password'
//        loginView.login(username, password);
//        // Then User must see she is logged in
//        String loggedInUsername = loggedInView.getLoggedInUsername();
//        Assert.assertEquals(loggedInUsername, username);
//
//    }
//}
