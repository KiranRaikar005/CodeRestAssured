Feature: Filter Products by Price Range

  
  Scenario Outline: Product should be within price range
     Given Endpoint url is given
    When the user filters products within 2 random prices between <minPrice> and <maxPrice>
    Then the returned products should fall between <minPrice> and <maxPrice>

    
    
     Examples:
      | minPrice | maxPrice |
      | 0      | 50     | 