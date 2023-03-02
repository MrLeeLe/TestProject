# Short Automation Test Plan
## Assumptions
  1. A short test plan used for automating tests of upload feature, not a complete plan for the whole automation project
  2. The case study is just provided the UI of upload feature, no description/documentation on how the feature works (for requirement-based testing, APIs documentation, …)
      - Test cases are designed based on exploring the web page and experience-based testing
      - Automation is implemented on UI layer
## Objectives
  Automating regression test for Upload features
  
## Development Criteria
  - Readable, maintainable and extendable automation framework
  - Running across environment (Dev, Staging, …)
  - Running across platforms (Web app, Mobile app to be considered later) and browser (Chrome, Edge, FF, …)
  
## Scope of Testing
  1. List of test cases should be designed and reviewed to ensure the quality of Upload feature (feature files in code repository)
  2. Automating all designed test cases
  
## Automation Test Layer
Based on the assumption, UI Automation for Web is developed (other automation types will be considered if needed)

## Test Condition
- OS: Window 10 machine (personal laptop of interviewee)
-	Brower: Chrome/FF/Edge

Out scope and being considered later:
-	Mobile web (Android/iOS)

## Test resources
-	Application Under Test: https://demo.guru99.com/test/upload/
-	UI Automation solution:  Page Object Model (Java)
    - Selenium Webdriver
    - Cucumber
-	Development tool:
    - Eclipse for Java development
    - Maven
    - Github
  
## Setup
-	Download and install Eclipse for Java developer at https://www.eclipse.org/downloads/
-	Download Java JDK zip file at https://www.oracle.com/eg/java/technologies/downloads/#jdk19-windows
-	Download Chrome driver at https://chromedriver.chromium.org/downloads
-	Download FF driver at: https://github.com/mozilla/geckodriver/releases
-	Download Edge driver at : https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
  ==> Check your Chrome/FF/Edge version to download the appropriate version of Webdriver
-	Launch Eclipse, and import existing **TestProject**
-	Configure Eclipse to point to Java JDK/bin (to run scripts cmd, need to configure JAVA_HOME and MAVEN_HOME)
-	Maven build and run scripts on eclipse
-	Tool to create file with specific file extension and size
  https://www.windows-commandline.com/how-to-create-large-dummy-file/

## List of test scenarios to be tested
Refer to **upload.feature** file inside source code
