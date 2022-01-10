Feature: Login

@regression
Scenario: Login Feature Validation
Given User Can Enable the Login Credentials by URL "http://admin-demo.nopcommerce.com/login"
When User Can input the credentials UserName and Password
And  Successfully Logged in and Title Verified
Then User Can View the DashBoard

