package levelset_test;

import levelset_objects.Home;
import levelset_objects.GetPaid;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LevelTest {
    WebDriver driver;
    Home home;
    GetPaid getPaid;

    @BeforeClass
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get("https://www.levelset.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //34an msh byl72 y catch el data bdl el function
        home = new Home(driver);
        getPaid = new GetPaid(driver);
        System.out.println("You navigate to correct Website");
    }

    @Test
    public void NavigateToGetPaid()
    {

        home.BtnClick();
        System.out.println("You navigate to GetPaid page");
    }

    @Test
    public void Validate_Free_Documents()
    {
        List<String> expectedTexts = Arrays.asList("Exchange a Waiver", "Send a Payment Document");
        getPaid.validateFreeDocumentsCount(2, expectedTexts);
        System.out.println("1-This Test is about - FREE - documents and Sucessfullly Execute");

    }

    @Test
    public void Validate_Price_Documents()
    {
        List<String> expectedTexts = Arrays.asList("Send a Warning");
        getPaid.validatePriceDocumentsCount(1, expectedTexts);
        System.out.println("2-This Test is about - Price - documents and Sucessfullly Execute");

    }




    @AfterTest
    public void closeDriver()
    {

        driver.quit();
    }

}