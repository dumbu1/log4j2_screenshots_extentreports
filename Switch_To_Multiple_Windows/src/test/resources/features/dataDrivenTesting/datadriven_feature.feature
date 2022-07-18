Feature: feature1
Background: bg1
Given user is on "Web Examples - CrossBrowserTesting.com" page
When user clicks on "selenium examples page" page
Scenario Outline: scenario1
Given user is on "Selenium Test Example Page1" page
When user enters names on text box as per <rowno> and clicks on Submit button
Examples:
|rowno|
|2|
|3|
|1|