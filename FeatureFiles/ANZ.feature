Feature: This feature for validate the Borrowing calculator
Scenario: Enter personal details in prompted Text box
	Given ANZ web page is loaded
	When Click the Single in Application type field
	And Give the 0 dependant in Number of dependants
	And Click the Home to live in Property you would like to buy field
	And Give the 80000 in Your annual income field
	And Give the 10000 in Your annual other income field
	And Give the 500 in Monthly living expenses field
	And Give the 0 in Current home loan monthly repayments field
	And Give the 100 in Other loan monthly repayments field
	And Give the 0 in Other monthly commitments field
	And Give the 10000 in Total credit card limits field
	And Click the Work Out how much I could borrow button
	Then Check the Estimated borrow amount
	When Clicked Start over button
	Then All Text boxs should be cleared
	When Give the 1 in Monthly living expenses field
	And Click the Work Out how much I could borrow button
	Then Warning message should be display
	
