@isNumeric
Feature: Is it Numeric?
  Everybody wants to know if string it's Numeric
 
  Scenario: Av isn't Numeric
    Given string is Av
    When I ask whether it's Numeric
    Then I should be told "Nope"