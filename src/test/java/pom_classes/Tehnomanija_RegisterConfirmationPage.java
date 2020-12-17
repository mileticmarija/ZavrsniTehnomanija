package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Tehnomanija_RegisterConfirmationPage {
    WebDriver driver;
    public Tehnomanija_RegisterConfirmationPage(WebDriver driver){
        this.driver=driver;
    }

    private By confirmationMessage= By.cssSelector(".message .wrapped");
    String confirmationMessageTX="Uspešno ste se registrovali.\n" +
            "Hvala.\n" +
            "Vaša Tehnomanija!";

    public void checkCongirmationMessage(){
        //Verify that the user is registered message is shown
        Assert.assertEquals(driver.findElement(confirmationMessage).getText(),confirmationMessageTX);
    }
}
