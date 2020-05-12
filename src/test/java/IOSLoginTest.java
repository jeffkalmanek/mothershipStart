//import io.appium.java_client.MobileBy;
//import io.appium.java_client.ios.IOSDriver;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.nio.file.Paths;
//
//public class IOSLoginTest {
//    IOSDriver driver;
//    WebDriverWait wait;
//
//    @Before
//    public void setUp() throws MalformedURLException, URISyntaxException {
//        URL appiumUrl = new URL("http://127.0.0.1:4723/wd/hub");
//        URL resource = getClass().getClassLoader().getResource("apps/TheApp-v1.2.1.app.zip");
//        File app = Paths.get(resource.toURI()).toFile();
//
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("platformName", "iOS");
//        desiredCapabilities.setCapability("platformVersion", "13.4");
//        desiredCapabilities.setCapability("deviceName", "iPhone 11");
//        desiredCapabilities.setCapability("app", app);
//
//        System.out.println("appiumURL is "+appiumUrl);
//
//        driver = new IOSDriver(appiumUrl, desiredCapabilities);
//        wait = new WebDriverWait(driver, 10);
//
//    }
//
//    @After
//    public void tearDown() {
//        try {
//            driver.quit();
//        } catch (Exception ignore) {}
//    }
//
//    private WebElement safeFind(By by) {
//        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
//    }
//
//    @Test
//    public void testLogin() {
//        safeFind(MobileBy.AccessibilityId("Login Screen")).click();
//        safeFind(By.xpath("//XCUIElementTypeTextField[@name=\"username\"]"))
//                .sendKeys("alice");
//        safeFind(By.xpath("//XCUIElementTypeSecureTextField[@name=\"password\"]"))
//                .sendKeys("mypassword");
//        safeFind(MobileBy.AccessibilityId("loginBtn")).click();
//        safeFind(MobileBy.AccessibilityId("You are logged in as alice"));
//    }
//}
