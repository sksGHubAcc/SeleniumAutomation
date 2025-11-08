package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class homePage_Steps {
    ChromeOptions cOptions;
    WebDriver driver;
    WebElement menu;
    List<WebElement> menuList;

    public homePage_Steps() {
        cOptions = new ChromeOptions();
        cOptions.addArguments("--headless=new");
        //cOptions.addArguments("start-maximised");

        driver = new ChromeDriver(cOptions);
        driver.manage().window().setSize(new Dimension(1440, 900));
    }

    @Given("User input URL in browser address bar")
    public void user_input_url_in_browser_address_bar() {
        driver.get("https://www.tutorialspoint.com/selenium/practice/browser-windows.php");
        //throw new io.cucumber.java.PendingException();
    }
    @Given("User waits for Homepage to load")
    public void user_waits_for_homepage_to_load() {

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        //throw new io.cucumber.java.PendingException();
    }
    @Then("User is shown Title as {string}")
    public void user_is_shown_title_as(String string) {
        System.out.println("Page Title is : " + driver.getTitle());
        Assert.assertEquals(string,driver.getTitle());
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Then("User enter user details as {string} {string} {string}")
    public void user_enter_user_details_as(String string, String string2, String string3) {
        WebElement menu;
        List<WebElement> menuList;

        driver.findElement(By.id("headingOne")).click();
        menu = driver.findElement(By.id("collapseOne"));
        menuList = menu.findElements(By.className("list-group-item"));
        menuList.get(0).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.findElement(By.id("fullname")).sendKeys(string);
        driver.findElement(By.id("email")).sendKeys(string2);
        driver.findElement(By.id("address")).sendKeys(string3);
    }

    @Then("User select checkbox {string}")
    public void user_select_checkbox(String string) {
        List<WebElement> checkboxList;
        WebElement menu;
        List<WebElement> menuList;

        user_waits_for_homepage_to_load();

        driver.findElement(By.id("headingOne")).click();
        menu = driver.findElement(By.id("collapseOne"));
        menuList = menu.findElements(By.className("list-group-item"));
        menuList.get(1).click();

        checkboxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
        if(checkboxList.size() > 0) {

            driver.findElement(By.id("c_bs_2")).click();
        }

        Assert.assertEquals("true",driver.findElement(By.id("c_bs_2"))
                .getAttribute("checked"));
    }

    @Then("User select radio button {string}")
    public void user_select_radio_button(String string) {
        List<WebElement> rbList;
        WebElement menu;
        List<WebElement> menuList;

        driver.findElement(By.id("headingOne")).click();
        menu = driver.findElement(By.id("collapseOne"));
        menuList = menu.findElements(By.className("list-group-item"));
        menuList.get(2).click();

        rbList = driver.findElements(By.xpath("//input[@name='tab']"));
        if(rbList.size() > 0) {
            //driver.findElement(By.xpath("//input[@value='" + string + "']")).click();
            for(WebElement list:rbList){
                if(list.getAttribute("value").contains(string)){
                    list.click();
                }
            }
        }

        Assert.assertEquals("true",driver.findElement(By.xpath("//input[@value='" + string + "']"))
                .getAttribute("checked"));
    }
    @Then("User click on {string}")
    public void user_click_on(String string) {

    }
    @Then("User click link on {string}")
    public void user_click_link_on(String string) {

    }


    @Then("User closes the page")
    public void user_closes_the_page() {
        driver.quit();

    }
}
