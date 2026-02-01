# Casekaro Playwright Automation (Java)

## Project Overview
This project automates critical user flows on the **Casekaro e-commerce website** using **Playwright with Java** and **TestNG**, following the **Page Object Model (POM)** design pattern.

The automation simulates a real user journey:
- Searching for Apple phone cases
- Selecting a phone model dynamically
- Adding multiple material variants (Hard, Glass, Soft) to cart
- Validating cart contents
- Printing item details such as material, price, and product link

---

##  Tech Stack
- **Language:** Java  
- **Automation Tool:** Playwright (Java)  
- **Test Framework:** TestNG  
- **Build Tool:** Maven  
- **Design Pattern:** Page Object Model (POM)  
- **Version Control:** Git & GitHub  

---

##  Project Structure
PLAYWRIGHT-AUTOMATION
│
├── src
│ ├── main
│ │ └── java
│ │ ├── base
│ │ │ └── BaseTest.java
│ │ │
│ │ └── pages
│ │     ├── HomePage.java
│ │ |   ├── SearchPage.java
│ │ |   ├── ProductListing.java
│ │ |   └── Cart.java
│ │ |
│   └── tests
│       └── Testing.java
│ 
│ 
│
├── pom.xml
└── README.md


rerequisites
For Normal Run

Java 17+

Maven 3.8+

Chrome / Chromium browser

Verify:

java -version
mvn -version

For Docker Run
Verify:
docker --version
docker-compose --version

 Run Tests Normally (Local Machine)
1️ Install Playwright Browsers (One Time Only)
mvn exec:java "-Dexec.mainClass=com.microsoft.playwright.CLI" "-Dexec.args=install"

2️ Run All Tests
mvn test

3️ Run Using TestNG XML (Optional)
mvn test -DsuiteXmlFile=testing.xml

4️  Test Reports
target/surefire-reports/

 Run Tests Using Docker (Recommended for CI/CD)
1️ Build & Run
docker-compose up --build

2️ Run Again (Without Rebuild)
docker-compose up

3️ Stop Containers
docker-compose down

4️ Test Reports (Docker)
target/surefire-reports/