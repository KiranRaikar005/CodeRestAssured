Feature: Validating price

Scenario: Validate all products have the price larger than zero
Given Endpoints are given
When Retrieve all product details
Then price must be greater than 0