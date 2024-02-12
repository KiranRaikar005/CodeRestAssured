Feature: Validate pager parameters for fetching products

  Scenario: Fetching products with specified offset and limit
    Given EndPoint is provided
    When Retrieve products with offset 0 and limit 10
    Then The number of  products should be 10