package steps;

import base.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.SurveyPage;

public class StepDefinitions extends BasePage{

    SurveyPage page;

    @Given("verify navigate to url {string}")
    public void verify_navigate_to_url(String url)
    {
//        BasePage.driverUtils.navigateToUrl(url);
        BasePage.initializeDriver();
        page = new SurveyPage(driver);
    }

    @Then("User Navigated to home page with continue button title {string}")
    public void user_navigated_to_home_page_with_continue_button_title(String title) {
        page.waitTillHomePageTitleIsLoaded(title);
       Assertions.assertEquals(title,page.getPageTitle());
    }

    @When("verify click continue")
    public void verify_click_continue() {

        //driver.findElement(By.id("asgfshgfhgsf"));
        page.ContinueButtonTwo.click();
    }

    @Then("Advance to first survey called Q1 with title {string}")
    public void advance_to_first_survey_called_q1(String title) {
        Assertions.assertEquals(title,page.getPageTitle());
    }

    @When("Verify the question will ask the user {string}")
    public void verify_the_question_will_ask_the_user_do_you_enjoy_watching_cricket(String questionHeaderExpected) {

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.textToBePresentInElement(page.getHeaderQuestion(),questionHeaderExpected));
        Assertions.assertEquals(questionHeaderExpected,page.getQuestionHeaderText());
    }

    @When("verify that you see exactly {int} radio buttons & the Radio buttons should have text of {string} and {string}")
    public void verify_that_you_see_exactly_radio_buttons_the_radio_buttons_should_have_text_of_yes_and_no(int noOfBtn, String expectedValue1, String expectedValue2) {
        Assertions.assertEquals(noOfBtn,page.getNoOfRadioButtons());
        Assertions.assertEquals(true,page.validateExpectedLabelsPresent(expectedValue1,expectedValue2));
    }

    @Then("verify the user can see the Continue button")
    public void verify_the_user_can_see_the_continue_button() {
        Assertions.assertEquals(true,page.continueButtonTwoDisplayed());

    }

    @When("Select {string}")
    public void selectAnyRadioBtn(String label) {
        page.getRadioBtnInput(label).click();
    }



    @When("Click the continue button")
    public void click_the_continue_button() {
        page.clickContinueButton();
    }
    @Then("Verify the user advances to Q2 with question {string}")
    public void verify_the_user_advances_to_q2_with_question(String questionHeaderExpected) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.textToBePresentInElement(page.getHeaderQuestion(),questionHeaderExpected));
        Assertions.assertEquals(questionHeaderExpected,page.getQuestionHeaderText());
    }
    @When("Enter {string} in the testBox")
    public void enter_in_the_test_box(String string) {
        page.getResponseTextArea().sendKeys(string);
    }


    @Then("The response is submitted and message displays {string}")
    public void the_response_is_submitted_and_message_displays(String responseMessage) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.textToBePresentInElement(page.getHeaderQuestion(),responseMessage));
        Assertions.assertEquals(responseMessage,page.getQuestionHeaderText());
    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }
}
