import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.SignUpPage;
import util.StringUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CreateUserTest {

    StringUtils su = new StringUtils();
    ChromeDriver driver;
    SignUpPage signUpPage;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        signUpPage = new SignUpPage(driver);
    }

    @AfterMethod
    public void clearFields() {
        driver.get(driver.getCurrentUrl());
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }

    @Test(priority = 1)
    public void shouldGiveWarningForWeakPassword() {
        //Given
        String firstName = su.generateRandomText(5);
        String middleName = su.generateRandomText(5);
        String lastName = su.generateRandomText(5);
        String email = su.generateRandomText(5) + "@asd.com";
        String password = su.generateRandomAlfaNumeric(5);


        //When
        signUpPage.fillInputs(firstName, middleName, lastName, email, password);
        signUpPage.createAccountButtonClick();

        //Then

        assertThat("password is weak warning should appear", signUpPage.getPasswordText(), is("Password is not strong enough"));
    }

    @Test(priority = 2)
    public void shouldGiveWarningForinvalidMail() {
        //Given
        String firstName = su.generateRandomText(5);
        String middleName = su.generateRandomText(5);
        String lastName = su.generateRandomText(5);
        String email = su.generateRandomText(5);
        String password = su.generateRandomAlfaNumeric(10);


        //When
        signUpPage.fillInputs(firstName, middleName, lastName, email, password);
        signUpPage.createAccountButtonClick();


        //Then
        assertThat("invalid email warning should appear", signUpPage.getInvalidEmailText(), is("Email is not valid"));
    }

    @Test(priority = 3)
    public void shouldCreateUserAndProceedToNextPage() {
        //Given
        String firstName = su.generateRandomText(5);
        String middleName = su.generateRandomText(5);
        String lastName = su.generateRandomText(5);
        String email = su.generateRandomText(5) + "@asd.com";
        String password = su.generateRandomAlfaNumeric(15);


        //When
        signUpPage.fillInputs(firstName, middleName, lastName, email, password);
        signUpPage.waitUntilPasswordCall();
        signUpPage.createAccountButtonClick();
        signUpPage.waitUntilVerifyPageLoads();

        //Then
        assertThat("should be redirected to verify email page", driver.getCurrentUrl(), is("https://rain-react-staging-0.rain.bh/email-verification"));
    }
}
