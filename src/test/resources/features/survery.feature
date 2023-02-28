Feature: Cricket Survey - qa-survey-respondent

  Background: navigate to url and goto register page
    Given verify navigate to url "https://qa-survey-respondent-web.marketonce.com/7@mysimpletest?mos_flag=test"
    Then User Navigated to home page with continue button title "Survey"
    When verify click continue
    Then Advance to first survey called Q1 with title "Survey"
    When Verify the question will ask the user "Do you enjoy watching Cricket?"
    And  verify that you see exactly 2 radio buttons & the Radio buttons should have text of "Yes" and "No"
    Then  verify the user can see the Continue button

# Page1
    Scenario:verify when User select Yes user should Enter comment to end of the survey
      When Select "Yes"
      And  Click the continue button
      Then Verify the user advances to Q2 with question "What do you enjoy?"
      When Enter "I enjoy the excitement of the game" in the testBox
      And  Click the continue button
      And  The response is submitted and message displays "We thank you for your time spent taking this survey. Your response has been recorded."
      Then close browser

# Page 2
  Scenario: verify when User select NO user navigated to end of the survey
    When Select "No"
    And  Click the continue button
    And  The response is submitted and message displays "We thank you for your time spent taking this survey. Your response has been recorded."
    Then close browser