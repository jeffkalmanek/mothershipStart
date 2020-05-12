import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {
    /* based on the name of this class, "LoginTest" that extends BaseTest
     * I would guess that each test class would be a 1 @Scenario test.  But
     * it doesn't seem efficient to instantiate a driver for each @Scenario.
     * Keep this idea open for now.
     */

    @Test // here this @Test contains 1 @Scenario, but could contain more
    public void testLogin() {
        final String username = "alice";
        final String password = "mypassword";

        // Given User starts app and selects login view
        mainView.navToLogin(); // this is a @Step
        // When User logs in with 'username' and 'password'
        loginView.login(username, password); // this is a @Step
        // Then User must see she is logged in
        String loggedInUsername = loggedInView.getLoggedInUsername();
        Assert.assertEquals(loggedInUsername, username); // this is a @Step

    }
}
