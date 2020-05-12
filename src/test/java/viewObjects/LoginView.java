package viewObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.temporal.ChronoUnit;

public class LoginView {
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)

    private final String usernameFieldSel = "username";
    /* @FindBy(xpath = "//XCUIElementTypeTextField[@name=\"username\"]")
     * not sure why the examples change from xpath to accessibilityID, inspector doesn't say
     * that accessibility ID can be used
     */
    @iOSFindBy(accessibility = usernameFieldSel)
    @AndroidFindBy(accessibility = usernameFieldSel)
    private WebElement usernameField;

    private final String passwordFieldSel = "password";
//    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name=\"password\"]")
    @iOSFindBy(accessibility = passwordFieldSel)
    @AndroidFindBy(accessibility = passwordFieldSel)
    private WebElement passwordField;

    private final String loginBtnSel = "loginBtn";
    @iOSFindBy(accessibility = loginBtnSel) // this was the initial strategy
    @AndroidFindBy(accessibility = loginBtnSel)
    private WebElement loginBtn;

    // this is the constructor method, using capitalized class name as the best practice pattern
    public LoginView(AppiumDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /* interesting, this is a behavior as the method, and incremental steps
     * that are needed for the behavior.  So group all behaviors possible on
     * this view as the methods in this class?
     *
     * Don't know how to get the screen shots in there though??
     */
    public void login(String username, String password) {

        /* race issue finding by accessibility where the
         * error says keyboard not present, and the sendkeys
         * looked like it envoked a 'paste' command.  But putting
         * in an extra step to click on the field before sendKeys
         * seems to make sure the keyboard is there.
         *
         * hypothesis is that the specific text element is not being
         * selected by the accessibility ID location strategy.  The
         * inspector could find multiple elements with accessibility ID
         * and I think that's why it wasn't recommending that strategy
         *
         * potentially a reason to use xpath with elementClass/Type?
         *
         * but then won't be OS agnostic
         */
        usernameField.click();
        usernameField.sendKeys(username);
        passwordField.click(); // needed clicks in both spots, paste shows up in namefield
        passwordField.sendKeys(password);
        loginBtn.click();
    }
}
