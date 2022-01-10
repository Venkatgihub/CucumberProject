	Feature: CustomerAddition
	@Smoke
	Scenario: Customer Addtion and Validation
	
	Given User can View the Customer Addition Icon in DashBoard "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
	When After Clicking the ADD Customer User can view the input Data
	When Maditory Fields verification
	Then User can Save the details
	Then If user not have a valid data Error Msg "" Should be Display
	And User can View the Added Customer Details
	
	@UnitTest
	
	Scenario: Search Added Customer are having valid credentials
	Given Locate the Search with EMAIL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F""admin@yourstore.com""admin""admin@yourstore.com""Email5"
	When While click on SearchTaB Valid Details should display
	And Displayed Details and Sear Details should Same
	Then Click on Logout

	
	