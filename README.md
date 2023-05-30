# Nuvolar FrontEnd Testing Task

This document demonstrates the use of Rest Assured with Java framework for backend testing task. The project provides automation (backend) testing task to the test the findPetsByStatus API of petStore.

**Table of Contents**
* Author
* Prerequisites
* Setup
* Files Structure
* Running the Tests
* Reporting
* Contributing 

**Author**

Name: Muhammad Junaid Akhter

Designation: Sr. Automation Test Engineer

Purpose: Automate testing task

**Prerequisites**

Before running the tests, ensure that the following software is installed on your machine:
* Java Development Kit (JDK) 19
 
**Setup**

1. Clone this repository to your local machine with below command.
git clone https://github.com/muhammadjunaidakhter/NuvolarBackendTesting.git
3. Open the project in IDE, my preferred IDE is IntelliJ
4. Install the maven project dependencies by running the following command in the project directory:
    1. Open project in directory and run 
mvn install 
    2. IntelliJ, Eclipse, and NetBeans IDE have built-in Maven integration. You can import your Maven project into the IDE, and it will automatically resolve and download the dependencies specified in the pom.xml file


**Files Structure**

Pets : File located at src/test/java/petStore/Pets. 
<img src="/readmePicture/files.png" alt="File-Picture">


**Running the Tests**

To execute the automated tests, follow these steps:
1. Through Feature File
    1. Go to the src/test/java/petStore/Pets file and click TestRunner icon shown left to class or function start.
    2. Click Run icon on top of IntelliJ.

**Reporting**

This project uses extent reports feature to generate detailed test reports. After running the tests, you can find the HTML reports in the test-output/RestAssuredReport.html directory. Open the RestAssuredReport.html file in a web browser to view the test execution summary.
<img src="/readmePicture/reports.png" alt="Report-Picture">

**Contributing**

If you'd like to contribute to this project, please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and test them thoroughly.
4. Commit your changes with descriptive commit messages.
5. Push your changes to your forked repository.
6. Submit a pull request, explaining the purpose and details of your changes.
