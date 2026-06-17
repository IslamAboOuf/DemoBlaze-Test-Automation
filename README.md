# DemoBlaze Testing Project

## Project Overview

This project was developed as part of the ITI Software Testing Track.

The objective is to perform both Manual Testing and Automation Testing on the DemoBlaze E-Commerce web application.

The project includes:

- Test Planning
- Test Scenarios
- Test Cases
- Bug Reporting
- Selenium Automation Framework
- Allure Reporting

---

## Testing Scope

### Modules Covered

- Sign Up
- Login
- Logout
- Product Details
- Categories
- Cart
- Place Order
- Contact Us
- About Us

---

## Manual Testing

### Deliverables

- Test Plan
- Test Scenarios
- 46 Test Cases
- Bug Reports
- Traceability Matrix

### Bugs Identified

Examples:

- Password validation issues
- Contact Us validation issues
- Category filter pagination issue
- UI/Functional defects

---

## Automation Testing

### Framework

- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)

### Automated Modules

- Login
- Register
- Contact Us
- Product
- Cart
- Checkout
- About US

---

## Reporting

### Allure Reports

Generate report:

```bash
mvn clean test
allure serve allure-results
```

---

## Tools Used

- Selenium WebDriver
- TestNG
- Maven
- Allure
- IntelliJ IDEA

---

### Project Structure

- src
    - main
        - java
            - pages
    - test
        - java
            - Base
            - Test
- testng.xml

---

## Test cases were created based on project requirements and expected business rules.

- Manual testing was performed to identify defects and ensure the application meets the specified requirements.
- Automation testing was implemented to validate critical functionalities and ensure regression testing is efficient.
- All identified bugs were reported and tracked for resolution.

---

## Team Members

- Islam El-Dosoky
- Shams Mohamed