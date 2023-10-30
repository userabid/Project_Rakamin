package saucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class All_Test {
    @Test
    public void Success_Login_Case(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        //Assertion Login Page
        String LoginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assertions.assertEquals(LoginPageAssert,"Swag Labs");



        //Input Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //User Click Login Button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //Assertion HomePage
        String Product = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assertions.assertEquals(Product,"Products");

        driver.close();
    }

    @Test
    public void Failed_Login_Case(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);
        String LoginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assertions.assertEquals(LoginPageAssert,"Swag Labs");



        //Input Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Input Password Salah
        driver.findElement(By.id("password")).sendKeys("Failed_Password");
        //User Click Login Button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        String ErrorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assertions.assertEquals(ErrorLogin,"Epic sadface: Username and password do not match any user in this service");

        driver.close();
    }


    @Test
    public void sort_item (){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        //Assertion Login Page
        String LoginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assertions.assertEquals(LoginPageAssert,"Swag Labs");



        //Input Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //User Click Login Button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //Assertion HomePage
        String Product = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assertions.assertEquals(Product,"Products");

        //Click Icon Sort
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
        //Click Sort By Price Low to High
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]")).click();
        //Assertion Success
        String Price = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")).getText();
        Assertions.assertEquals(Price, "$7.99");

        driver.close();
    }

    @Test
    public void Order_item(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        //Assertion Login Page
        String LoginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assertions.assertEquals(LoginPageAssert,"Swag Labs");



        //Input Username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Input Password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //User Click Login Button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //Assertion Homepage
        String Product = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
        Assertions.assertEquals(Product,"Products");

        // User click "Add to Cart" button on one of the product or more
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]")).click();

        // User click Cart icon on the top right side
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

        // User check the shopping list details & click the Checkout button
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

        // User fill the buyer's biodata form & click the Continue button
        driver.findElement(By.id("first-name")).sendKeys("Name");
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();

        // User double-check the shopping list & click the Finish button
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();

        // User successfully purchased the product & directed to "Checkout: Complete!" page
        String Complete = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();
        Assertions.assertEquals(Complete, "Thank you for your order!");

        // User can back to Homepage with click the "Back Home" button
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();

        driver.close();

    }
}