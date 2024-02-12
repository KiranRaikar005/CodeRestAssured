Feature: Pager API on Product details Page

Scenario: Test different scenarios on the pager ( validating that it returns the expected amount ) [https://api.escuelajs.co/api/v1/products?offset=0&limit=10]

Given Pager API Endpoints are given

Then I retrieve the products with offset 0 and limit 10

And Number of products count should be 10

And response code should be 200

