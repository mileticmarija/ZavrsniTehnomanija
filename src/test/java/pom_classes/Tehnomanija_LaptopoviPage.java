package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Tehnomanija_LaptopoviPage {
    WebDriver driver;
    public Tehnomanija_LaptopoviPage(WebDriver driver){
        this.driver=driver;
    }

    private By laptopRacunari= By.cssSelector(".main-col-category>div:nth-child(1)>div:nth-child(1)");

    String url="https://www.tehnomanija.rs/it-shop/laptopovi";

    public void selectLaptopRacunari(){
        //Verify that you are on the correct page by checking the URL
        Assert.assertEquals(driver.getCurrentUrl(),url);
        // Click on "Laptop racunari" image
        driver.findElement(laptopRacunari).click();
    }




}
