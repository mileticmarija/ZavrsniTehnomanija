package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Tehnomanija_LaptopRacunariPage {
    WebDriver driver;
    public Tehnomanija_LaptopRacunariPage(WebDriver driver){
        this.driver=driver;
    }

    String url="https://www.tehnomanija.rs/it-shop/laptop-racunari";
    private By honor= By.cssSelector(".filter-content:nth-child(7)>ul>div>div>li:nth-child(8)>div");
    private By sortBtn=By.cssSelector(".sort-wrap:nth-child(3)>div:nth-child(2)");
    private By descending=By.cssSelector("[name='sort']:nth-child(5)");
    private By honorTX=By.cssSelector(".product-wrap-grid.js-product-ga-wrap:nth-child(2) .product-name-grid");
    String honorText="Honor";
    private By cena1=By.cssSelector(".product-wrap-grid.js-product-ga-wrap:nth-child(2) .price-wrap-grid .price");
    private By cena2=By.cssSelector(".product-wrap-grid.js-product-ga-wrap:nth-child(3) .price-wrap-grid .price");

    public void honorMarkCheck(){
        //Verify that you are on the correct page by checking the URL
        Assert.assertEquals(driver.getCurrentUrl(),url);
        //check the "Honor" in "Robna marka"
        driver.findElement(honor).click();
        //Verify that only "Honor" products are shown
        Assert.assertEquals(driver.findElement(By.cssSelector(".filters-sticky:nth-child(2)>span:nth-child(2)")).getText(),"Robna marka: Honor");

        String honorCheck=driver.findElement(honorTX).getText();
        Assert.assertTrue(honorCheck.contains(honorText));

        WebDriverWait webDriverWait=new WebDriverWait(driver,10);

        //Sort products by price descending

  //Select select=new Select(driver.findElement(sortBtn));
  //select.selectByValue("price_desc");

        driver.findElement(sortBtn).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(descending));
        driver.findElement(descending).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(cena1));
        //Verify that the products are sorted by price descending
        double price1=Double.parseDouble(driver.findElement(cena1).getText().replaceFirst(" RSD", ""));
        double price2=Double.parseDouble(driver.findElement(cena2).getText().replaceFirst(" RSD", ""));

        Assert.assertTrue(price1>=price2);


    }
}
