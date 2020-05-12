//package viewObjects;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import io.appium.java_client.pagefactory.WithTimeout;
//import io.appium.java_client.pagefactory.iOSFindBy;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//import java.time.temporal.ChronoUnit;
//
//public class LoginViewIOSonly {
////    private final String usernameFieldSel = "username";
//    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
//
//    @FindBy(xpath = "//XCUIElementTypeTextField[@name=\"username\"]")
//    private WebElement usernameField;
//
//    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"password\"]")
//    private WebElement passwordField;
//
//    @iOSFindBy(accessibility = "loginBtn")
//    private WebElement loginBtn;
//
//    public LoginViewIOSonly(AppiumDriver driver) {
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//    }
//
//    public void login(String username, String password) {
//        usernameField.sendKeys(username);
//        passwordField.sendKeys(password);
//        loginBtn.click();
//    }
//}
