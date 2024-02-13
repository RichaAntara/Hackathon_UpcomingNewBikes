# Selenium Automation Testing Project: Identify New Bikes

## Project Overview

This Selenium automation testing project focuses on automating tasks on ZigWheels.com

The primary objectives include providing user information, navigating through the portal, verifying the presence of specific elements and extracting details from the page. 

The project uses various dependencies and libraries to facilitate automation.

## Project Structure

### 1. Maven Repository

- *Maven Version*: 3.9.6

### 2. Dependencies

- *Apache POI*

  - Version: 5.2.2

  - Purpose: Used for reading and writing Excel files, facilitating data-driven testing.

- *TestNG*

  - Version: 7.8.0

  - Purpose: Framework for test automation that allows for parallel execution and flexible test configuration.

- *Extent Report*

  - Version: 5.0.9

  - Purpose: Generates interactive and detailed HTML reports to enhance test result analysis.

- *Selenium*

  - Version: 4.15.0

  - Purpose: Enables interaction with web elements, navigation, and form submission in the browser.

- *Loggers*

  - Version: 2.20.0

  - Purpose: Provides logging capabilities for better debugging and traceability.

## Automation Test Flow

1. *Open ZigWheels.com*

   - Navigate to the ZigWheels.com.

2. *Hover on New Bikes and click on Upcoming bikes*

   - Hover on the New Bikes tab, click on Upcoming bikes option and verify the title.

   - Capture screenshot of the page.

3. *Filter all the honda bikes under 4 lacs*

   - Select Honda from the manufacturer dropdown.

   - Verify whether Honda bikes are displayed or not.

   - Filter and print all the bikes under 4 lacs.

   - Capture screenshot of the page.

   - Navigate to home page.

4. *Hover on Used Cars and click on Chennai*

   - Hover on Used Cars tab, click on Chennai and verify the title.

   - Capture screenshot of the page.

5. *Capture the popular models and display in console*

   - Select all the popular models from the popular models side panel and print in console.

   - Scroll down and take screenshot of the page .

   - Navigate back to home page.
 
6. *Click on Login button*

   - Click on Login button in homepage .

   - Click on Google SignIn button.

7. *Provide a invalid login details*

   - Provide an invalid email-id, Click on Next and print the error message in the console .

   - Capture the screenshot.

8. *Verify the results displayed *

   - Verify and write the results in excel sheet.

## How to Run the Tests

1. *Open Eclipse IDE:*

   - Launch Eclipse IDE on your machine.

2. *Import Project:*

   - Select File -> Import from the menu.

   - Choose Existing Maven Projects and click Next.

   - Browse to the directory where you cloned the repository and select the project.

3. *Update Maven Project:*

   - Right-click on the project in the Project Explorer.

   - Choose Maven -> Update Project.

   - Click OK to update dependencies.

4. *Set Up Configuration:*

   - Open the src/test/resources/config.properties file.

   - Update any configuration parameters like browser type, URLs, etc., as needed.

5. *Run Test Suite:*

   - Locate the test suite file (e.g. /testng.xml).

   - Right-click on the file and choose Run As -> TestNG Suite.

6. *View Reports:*

   - After execution, open the test-output folder and open index.html for reports.

   - Find the Extent Report HTML file (myReport.html) in reports folder for detailed test reports.

## Reporting

1. **Locate Test Reports:**

   - After the execution, navigate to the `test-output` folder in the project directory.

2. **Open Extent Report:**

   - Inside the `test-output` folder, find the Extent Report HTML file named `index.html`.

3. **View Test Reports:**

   - Open the `index.html` file using any web browser.

   - This report provides a detailed overview of test executions, including passed and failed tests, test duration, and any exceptions encountered.

4. **Screenshots and Logs:**

   - Extent Report may include screenshots captured during test execution and relevant logs for failed test cases.

5. **Analyze Results:**

   - Utilize the visual representation in the Extent Report to quickly identify test status and any issues encountered during the test run.

## Author Information

- *Antara Saha*

## Disclaimer

This project is intended for educational and testing purposes only. The authors are not responsible for any unauthorized use or modification of the code. Use at your own risk.
 

