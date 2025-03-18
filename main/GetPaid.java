package levelset_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class GetPaid {
    WebDriver driver;

    public GetPaid(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //count
    @FindBy(xpath = "//span[(@class='price-amount') and text()='Free']")
    public List<WebElement> freeDocuments;

    //validate Text
    @FindBy(xpath = "//span[contains(text(),'Free')]//parent::div//parent::div//child::div[@class='left']")
    public List<WebElement> freeDocumentsText;

    @FindBy(xpath = "//span[contains(@class,\"price-amount\") and number(translate(text(),\"$\",\"\"))>=30 and number(translate(text(),\"$\",\"\"))<=60]")
    public List<WebElement>priceDocuments;

    @FindBy(xpath = "//span[contains(@class,\"price-amount\") and number(translate(text(),\"$\",\"\"))>=30 and number(translate(text(),\"$\",\"\"))<=60]//parent::div//parent::div//child::div[@class='left']")
    public List<WebElement>priceDocumentsText;



    public void validateFreeDocumentsCount(int expectedCount, List<String> expectedTexts)
    {
        Assert.assertEquals(freeDocuments.size(), expectedCount, "Free documents count mismatch");

        List<String> actualTexts = new ArrayList<>();
        for (WebElement element : freeDocumentsText)
        {
            actualTexts.add(element.getText());
        }

        Assert.assertEquals(actualTexts, expectedTexts, "Free documents text mismatch");
    }

    public void validatePriceDocumentsCount(int expectedCount, List<String> expectedTexts)
    {
        Assert.assertEquals(priceDocuments.size(), expectedCount, "Price documents count mismatch");

        List<String> actualTexts = new ArrayList<>();
        for (WebElement element : priceDocumentsText)
        {
            actualTexts.add(element.getText());
        }

        Assert.assertEquals(actualTexts, expectedTexts, "Price documents text mismatch");
    }






}