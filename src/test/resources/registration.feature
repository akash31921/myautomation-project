Feature: Registration Form

  Scenario: Register a user successfully

    Given user opens the registration page

    When user enters the registration details

    |FirstName|LastName|Address|Email address|Phone no.|Password|Confirm Password|
    |Akash    |Deep    |Ghaziabad|akash70538@gmail.com|8130885062|admin123|admin123|

    And user click on submit button

    Then Registration should be successful
