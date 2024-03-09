Feature: Login Functionality

Scenario: verify login with valid data members
			Given user is on login page
			When user enter username and password
			Then user click on login button
			And user login successfully
