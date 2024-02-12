Feature: Validate the creation of product [https://api.escuelajs.co/api/v1/products/]



  Scenario: Create a new product
  
  Given API Endpoint is  given
  When  "Modern Ergonomic Office Chair" is created
  Then verify name of the product is "Furnitures1"
  And status code shoud be 200
 
  
  
  