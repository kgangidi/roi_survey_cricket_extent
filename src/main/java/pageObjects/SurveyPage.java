package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

import java.util.ArrayList;
import java.util.List;

public class SurveyPage {
    WebDriver driver;

    private final static String radioBtnLocator = "//div[@class='choices']//input";
    private static String radioBtnInputDynamicLocator = "//div[@class='choices']//label[text()='value']/preceding-sibling::div/input";
    private final static String labelRadioBtnLocator = "//div[@class='choices']//div[contains(@class,'radio-container')]//label";

    @FindBy(id="forward-btn_label")
    public WebElement ContinueButtonOne;

    @FindBy(id="Q1-R1-r-rad")
    public WebElement YesRadio;

    // @FindBy(xpath = "(\"//input[@type='checkbox']\")")
    // public WebElement radioButton;

    @FindBy(id="forward-btn_label")
    public WebElement ContinueButtonTwo;

    @FindBy(id="Q2-ta")
    public WebElement CommentTextBox;

    @FindBy(id="forward-btn_label")
    public WebElement ContinueButton;

    @FindBy(className = "header-text")
    public WebElement surveyEndMsg;

    @FindBy(xpath = "//div[contains(@class,'header-text')]")
    public WebElement headerQuestion;

    @FindBy(tagName = "textarea")
    public WebElement responseTextArea;


    public SurveyPage(WebDriver driver){
        //this step to initialize the pagefactory
        //Page factory cannot be created here as it will be local .so we have to created global
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickContinueButtonOne(){
        ContinueButtonOne.click();
    }
    //Thread.sleep(3000);
    public void clickYesRadioButton()
    {
        YesRadio.isSelected();
    }
    //Thread.sleep(3000);
    public void clickContinueButtonTwo(){
        ContinueButtonTwo.click();
    }
    //Thread.sleep(3000);
    public void enterComment(String comment){
        CommentTextBox.sendKeys(comment);
    }
    public void clickContinueButton(){
        ContinueButton.click();
    }
    public String getPageTitle()
    {
        return driver.getTitle();
    }
    public void surveyEndMsg(){
        surveyEndMsg.getText();
    }
    public String getQuestionHeaderText()
    {
        return headerQuestion.getText();
    }
    public WebElement getHeaderQuestion()
    {
        return headerQuestion;
    }

    public int getNoOfRadioButtons()
    {
        List<WebElement> radioBtns = driver.findElements(By.xpath(radioBtnLocator));
        return radioBtns.size();
    }

    public boolean validateExpectedLabelsPresent(String expectedValue1, String expectedValue2)
    {
        List<WebElement> labels = driver.findElements(By.xpath(labelRadioBtnLocator));
        List<String> labelTexts = new ArrayList<String>();
        labelTexts.add(expectedValue1);
        labelTexts.add(expectedValue2);
        for(WebElement label:labels)
        {
            if(!labelTexts.contains(label.getText()))
            {
                return false;
            }
        }
        return true;
    }

    public boolean continueButtonTwoDisplayed()
    {
        return ContinueButtonTwo.isDisplayed();
    }
    public WebElement getRadioBtnInput(String labelText)
    {
        String locatorRadioBtn = radioBtnInputDynamicLocator.replace("value",labelText);
        return driver.findElement(By.xpath(locatorRadioBtn));
    }

    public WebElement getResponseTextArea()
    {
        return responseTextArea;
    }

    public void waitTillHomePageTitleIsLoaded(String title) {
        String titleOfPage = driver.getTitle();
        int maxIteration = 0;
        while(titleOfPage!=title)
        {
            if(maxIteration==20)
                break;
            titleOfPage = driver.getTitle();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            maxIteration++;
        }
    }
}
