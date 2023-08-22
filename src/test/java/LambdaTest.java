import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LambdaTest {
    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.lambdatest.com/selenium-playground/");
        Thread.sleep(2000);
        WebElement inputFormSubmit = driver.findElement(By.xpath("//a[.='Input Form Submit']"));
        inputFormSubmit.click();
        Thread.sleep(2000);
        WebElement name = driver.findElement(By.cssSelector("#name"));
        name.sendKeys("Dinara");
        WebElement email = driver.findElement(By.cssSelector("#inputEmail4"));
        email.sendKeys("dinara@gmail.com");
        WebElement password = driver.findElement(By.cssSelector("#inputPassword4"));
        password.sendKeys("1234567ddd");
        WebElement company = driver.findElement(By.cssSelector("#company"));
        company.sendKeys("CodeFish");
        WebElement website = driver.findElement(By.cssSelector("#websitename"));
        website.sendKeys("www.company.com");
        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        company.sendKeys("Kazakhstan");
        WebElement city = driver.findElement(By.cssSelector("#inputCity"));
        city.sendKeys("Schaumburg");
        WebElement address1 = driver.findElement(By.cssSelector("#inputAddress1"));
        address1.sendKeys("1282 Pine Valley Drive");
        WebElement address2 = driver.findElement(By.cssSelector("#inputAddress2"));
        address2.sendKeys("apt 203");
        WebElement state = driver.findElement(By.cssSelector("#inputState"));
        state.sendKeys("IL");
        WebElement zip = driver.findElement(By.cssSelector("#inputZip"));
        zip.sendKeys("60173");
        Thread.sleep(2000);
        WebElement submitButton = driver.findElement(By.xpath("//button[.='Submit']"));
        submitButton.click();
        List<WebElement> allText = driver.findElements(By.xpath("//p"));
        for(int i = 0; i<allText.size();i++ ){
            if(allText.get(i).getText().contains("Thanks")){
                Assert.assertEquals(allText.get(i).getText(),"Thanks for contacting us, we will get back to you shortly.");
                System.out.println(allText.get(i).getText());
                break;
            }
        }
    }
}
