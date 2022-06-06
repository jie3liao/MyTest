Feature: Create an account in test.crowdstreet.com

    @CreateAccount
    Scenario: Open the landing page and create an account
        Given user is on the landing page
        When user clicks the account creating button
        Then verify the account creating page is displayed
        When user enters 'First name' value on account creating page
        And user enters 'Last name' value on account creating page
        And user enters 'Email address' value on account creating page
        And user enters 'Password' value on account creating page
        And user enters 'Confirm Password' value on account creating page
        And user selects 'Are you an accredited invester' radio button 'Yes' on account creating page
        And user selects 'I have read and accepted the terms and conditions' checkbox on account creating page
        And user confirms not robot in CAPTCHA on account creating page
        And user clicks 'Create an account' button on account creating page
        Then verify the account is created successfully
        
