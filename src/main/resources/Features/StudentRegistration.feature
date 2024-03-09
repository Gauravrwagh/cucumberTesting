Feature: register student

Scenario: verify student registration functionality

			Given user is on demoqa form page
			When user enters details
			Then user select gender
			Then user enters mobile number
			And user select date of birth
      And user enter subjects
		  And user click hobbies checkboxes
			And user enter address
			And user select state
			And user select city
			And user submit the form
			Then confirmation message should display