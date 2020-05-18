package viewObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.time.temporal.ChronoUnit;

public class LoggedInView {
    @WithTimeout(time = 15, chronoUnit = ChronoUnit.SECONDS)
    // note ChronoUnit is the new class to use for time unit

    /* this is a tricky element because even though it is a 'label' it is dynamic
     * I'll code it as unique to iOS and Android, but then play with other ways
     * to make it agnostic, maybe string builder with the username as the input
     * to a static portion of the string.  The string should be the same for
     * iOS and Android.
     */
//    private final String loggedInMsgLoc = "//XCUIElementTypeOther[contains(@name, 'You are logged in as')]";
    @iOSFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'You are logged in as')]")
    // change this AndroidOS element
    @AndroidFindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'You are logged in as')]")
    private WebElement loggedInMsg;

    public LoggedInView(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getLoggedInUsername() {
        String text = loggedInMsg.getText();
        System.out.println("here is all text displayed -"+text);
        System.out.println("here is what is returned to assert.equals -"
                +text.replaceAll(".*You are logged in as ([^ ]+).*", "$1"));
        return text.replaceAll(".*You are logged in as ([^ ]+).*", "$1");
    }
}
