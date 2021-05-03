package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        driver.get(this.pageUrl);
        w = new WebDriverWait(driver, 10);

    }

    protected WebDriver driver;
    private final String pageUrl = "https://rain-react-staging-0.rain.bh/signup";
    private final By firstNameBy = By.id("first-name");
    private final By middleNameBy = By.id("middle-name");
    private final By lastNameBy = By.id("last-name");
    private final By eMailBy = By.id("email");
    private final By passWordBy = By.id("password");
    private final By createAccountButton = By.className("MuiButton-label");
    private final By passwordText = By.id("password-helper-text");
    private final By invalidEmailText = By.id("email-helper-text");
    WebDriverWait w;

    public void enterUserName(String userName) {
        driver.findElement(firstNameBy).sendKeys(userName);
    }

    public void enterMiddleName(String middleName) {
        driver.findElement(middleNameBy).sendKeys(middleName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameBy).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(eMailBy).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passWordBy).sendKeys(password);
    }

    public void createAccountButtonClick() {
        driver.findElement(createAccountButton).click();
    }

    public String getPasswordText() {
        return driver.findElement(passwordText).getText();
    }

    public String getInvalidEmailText() {
        return driver.findElement(invalidEmailText).getText();
    }

    public void waitUntilPasswordCall() {
        w.until(ExpectedConditions.textToBePresentInElementLocated(passwordText, "Very Strong"));
    }

    public void waitUntilVerifyPageLoads() {
        w.until(ExpectedConditions.urlMatches("https://rain-react-staging-0.rain.bh/email-verification"));
    }


    public void fillInputs(String firstName, String middleName, String lastName, String email, String password) {
        this.enterUserName(firstName);
        this.enterMiddleName(middleName);
        this.enterLastName(lastName);
        this.enterEmail(email);
        this.enterPassword(password);
    }
}
