package saucedemo;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginDDT {
    @Test
    public void login_ddt(){
        WebDriver driver;
        String baseUrl = "https://www.saucedemo.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        String csvDir =  System.getProperty("user.dir")+"/src/test/Data/test-data.csv";

        try(CSVReader reader = new CSVReader(new FileReader(csvDir))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String email = null;
                String password = null;
                String status = null;
                for (int i = 0; i < 1; i++) {
                    email = nextLine[i];
                    password = nextLine[i+1];
                    status = nextLine[i+2];
                }
                driver = new ChromeDriver(opt);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                driver.get(baseUrl);

                driver.findElement(By.id("user-name")).sendKeys(email);
                //Input Password Salah
                driver.findElement(By.id("password")).sendKeys(password);
                driver.findElement(By.xpath("//input[@id='login-button']")).click();

                if (status.equals("success")) {
                    String Product = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
                    Assertions.assertEquals(Product, "Products");
                } else {
                    String ErrorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
                    Assertions.assertEquals(ErrorLogin, "Epic sadface: Sorry, this user has been locked out.");
                }
                driver.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }

    }

    private String nextLine(int i) {
        return null;
    }
}
