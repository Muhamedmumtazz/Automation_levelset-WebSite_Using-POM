package levelset_objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home
{
    WebDriver driver;

    public Home(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()='Get paid ']")
    public WebElement GetPaidBtn;

    public void BtnClick()
    {
        GetPaidBtn.sendKeys(Keys.ENTER);
    }
}