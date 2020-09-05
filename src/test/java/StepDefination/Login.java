package StepDefination;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Login {

    public static WebDriver driver;       // test adımlarımızı tarayıcımız üzerinden çalıştırmamızı yardımcı olur.

    @Given("trendyol yüklenir")
    public void trendyol_homepage()
    {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");              //sistem özelliğinin adı ve değeri tanımlanır.
        driver=new ChromeDriver();                                                     //google chrome'un açılmasını sağlıyoruz
        driver.manage().window().maximize();                                           //WebDriver tarayıcı penceresinin büyütülmesini destekler
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);           //sayfanın yüklenmesi için 60 saniye bekler.
        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);           //sayfadaki öğeleri bulmaya çalışırken belirli bir süre beklemesini ifade eder.

        driver.get("https://www.trendyol.com/");
        driver.findElement(By.className("fancybox-close")).click();

    }

    @When("giriş yap ikonuna tıklanır")
    public void click_login_icon()
    {

        driver.findElement(By.className("login-container")).click();
    }

    @Then("eposta adresi girilir")
    public void fill_email()
    {
        WebElement email=driver.findElement(By.name("email"));
        email.sendKeys("example@gmail.com"); //bulunan alana veri gönderilmesini sağlar.
    }

    @And("şifre girilir")
    public void fill_password()
    {
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("sifre1234");
    }

    @And("giriş yap butonuna tıklanır")
    public void click_sign() throws InterruptedException {
        WebElement login=driver.findElement(By.id("loginSubmit"));
        login.click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

    }

    @And("ürün araması yapılır")
    public void search_product()
    {
        WebElement search=driver.findElement(By.className("search-box"));
        search.sendKeys("ayakkabı");
        search.sendKeys(Keys.ENTER);
    }

    @And("ürüne tıklanır")
    public void Click_product()
    {
        List<WebElement> product= driver.findElements(By.className("p-card-wrppr"));
        product.get(2).click();
    }

    @And("ürün numarası seçilir")
    public void AddToBasket()
    {
        String number ="40";
        driver.findElement(By.className("pr-in-sz-pk")).click();
        List<WebElement> number1= driver.findElements(By.tagName("li"));
        for (WebElement option : number1)
        {
            if (option.getText().equals(number))
            {
                option.click();
                break;
            }
        }
    }


    @And("ürün listeleme ekranına geri dönülür")
    public void BackProduct()
    {

        driver.findElement(By.linkText("Spor Ayakkabı")).click();
    }
}
