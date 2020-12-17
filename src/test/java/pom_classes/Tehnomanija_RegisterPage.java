package pom_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;

public class Tehnomanija_RegisterPage {
    WebDriver driver;
    public Tehnomanija_RegisterPage(WebDriver driver){
        this.driver=driver;
    }

    private By select=By.cssSelector(".two-column.customer-type>div:nth-child(1)>input");
    private By titula=By.cssSelector(".two-column.title-type>div:nth-child(1)>input");
    private By firstName=By.cssSelector(".two-columns:nth-child(7)>li:nth-child(1)>input");
    private By lastName=By.cssSelector(".two-columns:nth-child(7)>li:nth-child(2)>input");
    private By email=By.cssSelector(".two-columns:nth-child(7)>li:nth-child(3)>input");
    private By emailConfirmation=By.cssSelector(".two-columns:nth-child(7)>li:nth-child(4)>input");
    private By password=By.cssSelector(".two-columns:nth-child(7)>li:nth-child(7)>input");
    private By passwordConfirmation=By.cssSelector(".two-columns:nth-child(7)>li:nth-child(8)>input");
    private By phoneNumber=By.cssSelector(".two-columns:nth-child(7)>li:nth-child(9)>input");
    private By dateOfBirth=By.cssSelector(".two-columns:nth-child(7)>li:nth-child(10)>input");
    private By street=By.cssSelector(".two-columns:nth-child(10)>li:nth-child(1)>input");
    private By number=By.cssSelector(".two-columns:nth-child(10)>li:nth-child(2)>input");
    private By floor=By.cssSelector(".two-columns:nth-child(10)>li:nth-child(3)>input");
    private By city=By.cssSelector(".two-columns:nth-child(10)>li:nth-child(5)>input");
    private By apartmentNumber=By.cssSelector(".two-columns:nth-child(10)>li:nth-child(4)>input");
    private By phone=By.cssSelector(".two-columns:nth-child(10)>li:nth-child(7)>input");
    private By postCode=By.cssSelector(".two-columns:nth-child(10)>li:nth-child(6)>input");
    private By agreeButton=By.cssSelector("#accept_terms");
    private By captcha=By.cssSelector("#rc-anchor-container #recaptcha-anchor");
    private By registerBtn=By.cssSelector(".btn.register-btn.basket:nth-child(1)");


    public void fillInFormAndRegister(String ime, String prezime, String emailTX, String sifra,String phoneNumberTX,
                           String ulica,String broj,String sprat,String brojStana,String grad,String postanskiBroj,String brojTelefona) throws InterruptedException {
        //Fill the form "Formular za registraciju"
        driver.findElement(firstName).sendKeys(ime);
        driver.findElement(lastName).sendKeys(prezime);
        driver.findElement(email).sendKeys(emailTX);
        driver.findElement(emailConfirmation).sendKeys(emailTX);
        driver.findElement(password).sendKeys(sifra);
        driver.findElement(passwordConfirmation).sendKeys(sifra);
        driver.findElement(phoneNumber).sendKeys(phoneNumberTX);
        driver.findElement(dateOfBirth).click();

        Select month=new Select(driver.findElement(By.cssSelector(".ui-datepicker-month")));
        month.selectByValue("1");
        Select year=new Select(driver.findElement(By.cssSelector(".ui-datepicker-year")));
        year.selectByValue("1995");
        driver.findElement(By.cssSelector(".ui-datepicker-calendar>tbody>tr:nth-child(2)>td:nth-child(3)")).click();

        driver.findElement(street).sendKeys(ulica);
        driver.findElement(number).sendKeys(broj);
        driver.findElement(floor).sendKeys(sprat);
        driver.findElement(apartmentNumber).sendKeys(brojStana);
        driver.findElement(city).sendKeys(grad);
        driver.findElement(postCode).sendKeys(postanskiBroj);
        driver.findElement(phone).sendKeys(brojTelefona);
        driver.findElement(agreeButton).click();

        //captcha
        //driver.findElement(captcha).click();
        Thread.sleep(50000);
        //Click "Regsitracija button"
        driver.findElement(registerBtn).click();


    }

}
