package viewObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.time.temporal.ChronoUnit;

public class MainView {
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)

    private final String navToLoginBtnSel = "Login Screen";
    @iOSFindBy(accessibility = navToLoginBtnSel)
    @AndroidFindBy(accessibility = navToLoginBtnSel)
    private WebElement navToLoginBtn;

    public MainView(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void navToLogin() {
        navToLoginBtn.click();
    }
}
