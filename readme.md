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
## Project Structure
```
PLAYWRIGHT-AUTOMATION
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   │   └── BaseTest.java
│   │   │   │
│   │   │   ├── pages
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── SearchPage.java
│   │   │   │   ├── ProductListing.java
│   │   │   │   └── Cart.java
│   │   │   │
│   │   │   └── tests
│   │   │       └── Testing.java
│   │   │
│   │   └── resources
│   │
│   └── test
│       └── java
│
├── pom.xml
└── README.md
```


## Prerequisites For Normal Run

- **Java 17+**
- **Maven 3.8+**
- **Chrome / Chromium browser**

## Verify Installation

Check your installations:
```bash
java -version
mvn -version
```

For Docker, verify:
```bash
docker --version
docker-compose --version
```

## Run Tests Normally (Local Machine)

### 1. Install Playwright Browsers (One Time Only)
```bash
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```

### 2. Run All Tests
```bash
mvn test
```

### 3. Run Using TestNG XML (Optional)
```bash
mvn test -DsuiteXmlFile=testing.xml
```

### 4. Test Reports

Reports are generated at: `target/surefire-reports/`

## Run Tests Using Docker (Recommended for CI/CD)

### 1. Build & Run
```bash
docker-compose up --build
```

### 2. Run Again (Without Rebuild)
```bash
docker-compose up
```

### 3. Stop Containers
```bash
docker-compose down
```

### 4. Test Reports (Docker)

Reports are available at: `target/surefire-reports/`