# dmgAssignment

**Running in the command line**
1. Navigate to the folder where the repo has been cloned.
2. Within the dmgAssignment, type:
```
mvn test
```
3. This will run the test within the dmgAssignment.feature file.
4. By default, it will run in headless mode. To run in headed mode, comment out line 43 in the DriverUtilities.class
5. When the execution is finished, a report will be generated within target\cucumber-reports. Open the index.html file and it will load the report. If there are any failures, a screenshot will be included in the report.

**Overview of the code**

Data package:
* The Constants class is used to store variables that are used within the site or just used within the project

Pages package:
* The BasePage class contains elements or methods that are common across all the pages of the site e.g. the navigation header
* All other elements that are not common should be stored in its own page class. The page class should have page elements, interactions with the page (clicks, or getting text) and waits.

Utilities package:
* The CommonMethods class is used to store common methods used across the project and isn't tired down to a single page e.g. javascript interactions
* The DriverUtilities class is used to create and close the driver and currently determines whether the tests should be run in headless mode or not.
* Whenever a new page is created within the Pages package, a method within PageObjectManager class needs to be created that links the page to the driver, so that the methods within the newly created page can be utilised within the StepDefs package.
* The ScenarioContext class is used to share test data between step definitions. Use the setters to store the data and the getters to then retrieve it.
* The TestContext class is used to manage the DriverUtilities and PageObjectManager class

resources/features:
* The strucute of a test is written using Gherkin Syntax. At the top of each feature, you declare tags that identify this feature file. You then give a brief explanation of what the tests on that feature file are about using the "Feature" command. 
* The keywords to use when creating a test are either "Given, When or Then". "And" is used to extend the previous keyword command
* Given is used to set the test pre-condititions, When is used to indicate an action as part of the test and Then is used as a check to ensure the When action is done correctly.

Hooks:
* The hooks class is used to determine what a test should do before and after it is run

StepDefs package:
* In the constructor, you should declare any page objects to be used within the class via the PageObjectManager class
* Classes in here are used to link the Gherkin syntax within the feature file with the page objects found within the page class
* Above each method within the class is the gherkin syntax with a Given/When/Then command to start it off.
* Asserts should be done on this page to ensure a test passes or not

TestRunner:
* Here is where you set the file paths for the feature files that contains the gherkin syntax and the step definitions
