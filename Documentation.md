Casekaro Playwright Automation Framework

Overview
--------
This project is an end-to-end automation framework built using Playwright (Java) and TestNG
for automating user journeys on the Casekaro e-commerce website.
The framework follows the Page Object Model (POM) design pattern to ensure maintainability,
scalability, and readability.

Tech Stack
----------
- Java
- Playwright (Java)
- TestNG
- Maven
- Page Object Model (POM)

Project Structure
-----------------
src
 └── test
     └── java
         ├── base
         │   └── BaseTest.java
         ├── pages
         │   ├── HomePage.java
         │   ├── SearchPage.java
         │   ├── ProductListing.java
         │   └── Cart.java
         └── tests
             └── Testing.java

Test Scenario Covered
---------------------
1. Launch Casekaro homepage
2. Navigate to "Mobile Covers @ 69"
3. Search for Apple brand
4. Validate only Apple products appear in search results
5. Open an Apple product
6. Select iPhone 16 Pro model
7. Add the same product with:
   - Hard material
   - Glass material
   - Soft material
8. Validate exactly 3 items are present in the cart
9. Print cart item details:
   - Material
   - Price
   - Product link

Class Responsibilities
----------------------

BaseTest
- Manages Playwright lifecycle
- Launches browser before each test
- Closes browser after each test

Testing
- Main test orchestration class
- Executes the complete end-to-end flow
- Contains assertions and validations

HomePage
- Opens homepage
- Navigates to Mobile Covers section
- Performs brand search using the search modal

SearchPage
- Validates search results contain only Apple products
- Filters out non-product results like blogs
- Selects an Apple product dynamically

ProductListing
- Searches and selects a specific phone model
- Uses exact matching to avoid ambiguity between similar models

Cart
- Selects the first available product design
- Adds multiple material variants to the cart
- Handles Shopify cart drawer behavior
- Validates only visible cart items
- Prints detailed cart information

Key Automation Challenges Solved
--------------------------------
- Avoided strict mode violations by using ARIA role locators
- Filtered product cards to exclude blog entries
- Handled Shopify hidden DOM elements during cart validation
- Selected radio buttons via labels to avoid interaction issues
- Ensured cart count validation is based on visible items only

How to Run the Test
-------------------
mvn clean test

Design Principles Used
----------------------
- Page Object Model
- Separation of concerns
- Reusable components
- Dynamic element handling
- Robust locator strategies

Interview Explanation Summary
-----------------------------
This project demonstrates real-world automation handling of a Shopify-based e-commerce site,
focusing on stability, maintainability, and accurate business validation rather than fragile
UI interactions.
