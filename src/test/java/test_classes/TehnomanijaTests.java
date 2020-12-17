package test_classes;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pom_classes.*;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.util.concurrent.TimeUnit;

//@Listeners({allure.AllureListener.class})
public class TehnomanijaTests {
    WebDriver driver;
    String URL="https://www.tehnomanija.rs/";
    DriverManager driverManager;
    Tehnomanija_HomePage tehnomanijaHomePage;
    Tehnomanija_RegisterPage tehnomanijaRegisterPage;
    Tehnomanija_RegisterConfirmationPage tehnomanijaRegisterConfirmationPage;
    Tehnomanija_ITShopPage tehnomanijaItShopPage;
    Tehnomanija_LaptopoviPage tehnomanijaLaptopoviPage;
    Tehnomanija_LaptopRacunariPage tehnomanijaLaptopRacunariPage;

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser){
        driverManager= DriverManagerFactory.getDriverManager(browser);
        driver=driverManager.qetWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void TC001RegisterAndCheckMessage() throws InterruptedException {
        tehnomanijaHomePage=new Tehnomanija_HomePage(driver);
        tehnomanijaHomePage.accCookies();
        tehnomanijaHomePage.clickRegister();

        tehnomanijaRegisterPage=new Tehnomanija_RegisterPage(driver);
        tehnomanijaRegisterPage.fillInFormAndRegister("ime","prezime","maildneki5@gmail.com","paSS.123.456","0987654321","neka ulica","34","1","1","beograd","11000","0987609876");

        tehnomanijaRegisterConfirmationPage=new Tehnomanija_RegisterConfirmationPage(driver);
        tehnomanijaRegisterConfirmationPage.checkCongirmationMessage();

    }

    @Test
    public void TC002NavigationAndHonorMarkCheck() {
        tehnomanijaHomePage=new Tehnomanija_HomePage(driver);
        tehnomanijaHomePage.accCookies();
        tehnomanijaHomePage.categoriesCheck();
        tehnomanijaHomePage.itShop();

        tehnomanijaItShopPage=new Tehnomanija_ITShopPage(driver);
        tehnomanijaItShopPage.selectLaptop();

        tehnomanijaLaptopoviPage=new Tehnomanija_LaptopoviPage(driver);
        tehnomanijaLaptopoviPage.selectLaptopRacunari();

        tehnomanijaLaptopRacunariPage=new Tehnomanija_LaptopRacunariPage(driver);
        tehnomanijaLaptopRacunariPage.honorMarkCheck();


    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }

}
