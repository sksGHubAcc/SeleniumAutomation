Feature: Tutorial Homepage
  Background: Visiting website
    Given User input URL in browser address bar
    And   User waits for Homepage to load

  Scenario: Element validation
    Then  User is shown Title as "Selenium Practice - Browser Windows"
    And User enter user details as "TestFName" "TestEmail" "TestAddress"
    And User select checkbox "2"
    And User select radio button "igottwo"
    And User click on "Double Click Me"
    And User click link on "HomewPWPU"
    And User closes the page
