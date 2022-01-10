$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/FeatureFiles/Login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Login Feature Validation",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@regression"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User Can Enable the Login Credentials by URL \"http://admin-demo.nopcommerce.com/login\"",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.StepDefinitionsLogin.user_Can_Enable_the_Login_Credentials_by_URL(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Can input the credentials UserName and Password",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.StepDefinitionsLogin.user_Can_input_the_credentials_UserName_and_Password()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Successfully Logged in and Title Verified",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.StepDefinitionsLogin.successfully_Logged_in_and_Title_Verified()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User Can View the DashBoard",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.StepDefinitionsLogin.user_Can_View_the_DashBoard()"
});
formatter.result({
  "status": "passed"
});
});