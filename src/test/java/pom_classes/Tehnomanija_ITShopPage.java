package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Tehnomanija_ITShopPage {
    WebDriver driver;
    public Tehnomanija_ITShopPage(WebDriver driver){
        this.driver=driver;
    }

    private By laptopovi= By.cssSelector(".main-col-category>div:nth-child(1)>div:nth-child(1)>a");

    String url="https://www.tehnomanija.rs/it-shop";

    public void selectLaptop(){
        //Verify that you are on the correct page by checking the URL
        Assert.assertEquals(driver.getCurrentUrl(),url);
        //Click on "Laptopovi" image
        driver.findElement(laptopovi).click();
    }





}
