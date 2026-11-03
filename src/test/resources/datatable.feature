Feature: Demo feature

  Scenario: login functionality

    Given Goto the website loginpage

    When enter correct credentials
    |username|password|
    |Admin   |admin123|

    And click on the login button on homepage

    Then login successful on homepage

    And profile picture displayed on homepage

