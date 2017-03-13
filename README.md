# cs-go-ui
## Selenium Automation Framework
Using Goibibo site. In this we will check the Headers, Sign In Frame (which is only accessible from, https://www.goibibo.com/bus/#home) and the colors, alignments, fonts of the elements involved in this.

Using Page Factory Model for the Automation. Will define all the elements of a page ( a basic segregation of web elements that would be used together) in a page and using a PageBase we can intialize all the elements of the page and access them.

## Framework
Framework comprises of the following files.

1. **BrowserFactory.java** - All the code related to Browsers (Firefox, Chrome, Safari & IE) and the respective driver initialization and setup code. 
2. **Constants.java** - All the constant values are stored here. 
3. **Helpers.java** - Helper functions required for Automation.
4. **PageBase.java** - This file helps in initializing the page factories of different pages.
5. **TestBase.java** - All the base set up required for the test suite is defined here, which will be extended by all the test classes.

## Page Factories
1. **HomePage.java** - Home Page header's elements
2. **LoginPage.java** - Sign In Frame's elements
3. **PopupFrame.java** - Frame which appears requesting registration, need to close it to continue the testing. Better to have page factory of it.

## Tests
1. **HomePageTests.java** - Check if the Headers are available and clicking on each header should load there respective page. 
2. **LoginPageTests.java** - Navigate to, https://www.goibibo.com/bus/#home, using the HomePage's Bus button and click on Sign In, so that the Frame Appears. Perform the basic testing consisting of login scenarios and different error messages.
3. **ColorTests.java** - All the elements are checked for there colors, before and after hovering on them.
4. **AlignmentAndFontTests.java** - Headers are checked if there alignment and font family and sizes are correct.
