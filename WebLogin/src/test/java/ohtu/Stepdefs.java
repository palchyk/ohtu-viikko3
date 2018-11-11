package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {

    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";

    @Given("^login is selected$")
    public void login_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
    }

    @Given("^command new user is selected$")
    public void register_selected() throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
    }
    @Given("^user with username \"([^\"]*)\" with password \"([^\"]*)\" is successfully created$")
    public void registered_selected(String username, String password) throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        registerWith(username, password, password);
    }
    
    
     @Given("^user with username \"([^\"]*)\" and password \"([^\"]*)\" is tried to be created$")
    public void registered_selected_withwrongthings(String username, String password) throws Throwable {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        registerWith(username, password, password);
    }
    
    

    @When("^username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_and_password_are_given(String username, String password) throws Throwable {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    @Then("^system will respond \"([^\"]*)\"$")
    public void system_will_respond(String pageContent) throws Throwable {
        assertTrue(driver.getPageSource().contains(pageContent));
    }

    @When("^correct username \"([^\"]*)\" and password \"([^\"]*)\" are given$")
    public void username_correct_and_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^a valid username \"([^\"]*)\" and password \"([^\"]*)\" and matching password confirmation are entered$")
    public void register_correct(String username, String password) throws Throwable {
        registerWith(username, password, password);
    }

    @When("^too short username \"([^\"]*)\" and password \"([^\"]*)\" and matching password confirmation are entered$")
    public void register_shortname(String username, String password) throws Throwable {
        registerWith(username, password, password);
    }

    @When("^username \"([^\"]*)\" and too short password \"([^\"]*)\" and matching password confirmation are entered$")
    public void register_shortpass(String username, String password) throws Throwable {
        registerWith(username, password, password);
    }

    @When("^a valid username \"([^\"]*)\" and password \"([^\"]*)\" and not matching password confirmation \"([^\"]*)\" are entered$")
    public void register_wrongconfirm(String username, String password, String confirmation) throws Throwable {
        registerWith(username, password, confirmation);
    }

    @When("^correct username \"([^\"]*)\" and incorrect password \"([^\"]*)\" are given$")
    public void username_and_incorrect_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @When("^nonexistent username \"([^\"]*)\" and nonexistent password \"([^\"]*)\" are given$")
    public void username_and_unex_password_are_given(String username, String password) throws Throwable {
        logInWith(username, password);
    }

    @Then("^user is logged in$")
    public void user_is_logged_in() throws Throwable {
        pageHasContent("Ohtu Application main page");
    }

    @Then("^a new user is created$")
    public void user_is_registered() throws Throwable {
        pageHasContent("Welcome to Ohtu Application!");
    }

    @Then("^user is not logged in and error message is given$")
    public void user_is_not_logged_in_and_error_message_is_given() throws Throwable {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");
    }

    @Then("^user is not created and error \"username should have at least 3 characters\" is reported$")
    public void user_is_not_registered_withshortname() throws Throwable {
        pageHasContent("username should have at least 3 characters");
    }

    @Then("^user is not created and error \"password should have at least 8 characters\" is reported$")
    public void user_is_not_registered_withshortpass() throws Throwable {
        pageHasContent("password should have at least 8 characters");
    }

    @Then("^user is not created and error \"password and password confirmation do not match\" is reported$")
    public void user_is_not_registered_withwrongconfirmpass() throws Throwable {
        pageHasContent("password and password confirmation do not match");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /* helper methods */
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();
    }

    private void registerWith(String username, String password, String confirmation) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(confirmation);
        element = driver.findElement(By.name("signup"));
        element.submit();
    }
}
