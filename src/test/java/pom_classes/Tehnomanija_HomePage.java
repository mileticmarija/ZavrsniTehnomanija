package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Tehnomanija_HomePage {
    WebDriver driver;
    public Tehnomanija_HomePage(WebDriver driver){
        this.driver=driver;
    }

    private By prijavaButton= By.cssSelector(".main-content .user-wraper");
    private By registerButton=By.cssSelector(".register-links-wrap>a");
    private By categoriesMenu=By.cssSelector(".category-menu.js-category-menu");
    private By categories=By.cssSelector(".category-menu-wrap:nth-child(2)>div>div>a");
    private By categoriesIcons=By.cssSelector(".category-menu-wrap:nth-child(2)>div>div>a>img");
    private By itShop=By.cssSelector(".category-menu-wrap:nth-child(2)>div>div:nth-child(7)>a");

    String categoryNames[]={"CELEBRITY STORE - NOVO","IGRAČKE","BELA TEHNIKA","MALI KUĆNI APARATI","KLIMA UREĐAJI I GREJANJE","TV I VIDEO",
            "IT SHOP","TELEFONIJA","LEPOTA I ZDRAVLJE","FOTO-APARATI I KAMERE","AUDIO","AUTO TEHNIKA","SVE ZA KUĆU","LIFESTYLE"};

    public void accCookies(){
        driver.findElement(By.cssSelector(".buttons-read-more-cookie-agree>a>span")).click();
    }

    public void clickRegister(){
        Actions actions= new Actions(driver);
        // Hover over "Prijava"
        actions.moveToElement(driver.findElement(prijavaButton)).build().perform();
        //Click register
        driver.findElement(registerButton).click();
    }

    public void categoriesCheck(){

        Actions actions=new Actions(driver);
        //Hover over "Kategorije proizvoda"
        actions.moveToElement(driver.findElement(categoriesMenu)).perform();
        //Verify that all the menu items are displayed (text and icons)
        for(int i = 0; i<driver.findElements(categories).size(); i++){
            Assert.assertTrue(driver.findElements(categories).get(i).isDisplayed());
            Assert.assertEquals(categoryNames[i],driver.findElements(categories).get(i).getText());
            Assert.assertTrue(driver.findElements(categoriesIcons).get(i).isDisplayed());
        }


    }

    public void itShop(){
        Actions actions=new Actions(driver);
        //Hover over "IT SHOP"
        actions.moveToElement(driver.findElement(itShop)).perform();
        //Verify that the color of the text is yellow.
        Assert.assertEquals(driver.findElement(itShop).getCssValue("color"),"rgba(255, 203, 5, 1)");
        //Click "IT SHOP"
        driver.findElement(itShop).click();
    }

}
