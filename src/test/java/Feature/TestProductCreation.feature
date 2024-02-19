Feature: Product Creation Negative Test

  Scenario: Create product with invalid data
    Given Pass URI data
    When retrieve the response with invalid resource
    Then the response status code should be 404
    Then use method post instead of get method status code should be 404
  