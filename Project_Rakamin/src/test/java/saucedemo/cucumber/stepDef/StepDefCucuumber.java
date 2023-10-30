package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDefCucuumber {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    //Test Login
    @Given("Halaman login saucedemo")
    public void halamanLoginSaucedemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        String LoginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assertions.assertEquals(LoginPageAssert, "Swag Labs");
    }

    @When("Input username")
    public void inputUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("User can login to dashboard page")
    public void userCanLoginToDashboardPage() {
        String Product = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assertions.assertEquals(Product, "Products");
    }


    @And("Input invalid password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("Failed_Password");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        String ErrorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assertions.assertEquals(ErrorLogin, "Epic sadface: Username and password do not match any user in this service");
    }


    //Sort Item Feature
    @Given("User already login the SwagLabs site")
    public void userAlreadyLoginTheSwagLabsSite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        String LoginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assertions.assertEquals(LoginPageAssert, "Swag Labs");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        String Product = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assertions.assertEquals(Product, "Products");
    }

    @When("User click icon sort")
    public void userClickIconSort() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();

    }

    @And("User sort by price \\(low to high)")
    public void userSortByPriceLowToHigh() {
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();
    }

    @Then("Users can see the products have been sorted")
    public void usersCanSeeTheProductsHaveBeenSorted() {
        String Price = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")).getText();
        Assertions.assertEquals(Price, "$7.99");
    }

    @When("User click Add to Cart button on one of the product or more")
    public void userClickAddToCartButtonOnOneOfTheProductOrMore() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]")).click();
        throw new io.cucumber.java.PendingException();

    }

    @And("User click Cart icon on the top right side")
    public void userClickCartIconOnTheTopRightSide() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        throw new io.cucumber.java.PendingException();
    }

    @And("User check the shopping list details & click the Checkout button")
    public void userCheckTheShoppingListDetailsClickTheCheckoutButton() {
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        throw new io.cucumber.java.PendingException();
    }

    @And("User fill the buyer's biodata form & click the Continue button")
    public void userFillTheBuyerSBiodataFormClickTheContinueButton() {
        driver.findElement(By.id("first-name")).sendKeys("Name");
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        throw new io.cucumber.java.PendingException();
    }

    @And("User double-check the shopping list & click the Finish button")
    public void userDoubleCheckTheShoppingListClickTheFinishButton() {
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
        throw new io.cucumber.java.PendingException();
    }

    @Then("User successfully purchased the product & directed to Checkout: Complete! page")
    public void userSuccessfullyPurchasedTheProductDirectedToCheckoutCompletePage() {
        String Complete = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
        Assertions.assertEquals(Complete, "Thank you for your order!");
        throw new io.cucumber.java.PendingException();
    }

    @And("User can back to Homepage with click the Back Home button")
    public void userCanBackToHomepageWithClickTheBackHomeButton() {
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
        throw new io.cucumber.java.PendingException();
    }
}
