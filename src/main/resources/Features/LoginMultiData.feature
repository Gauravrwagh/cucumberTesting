Feature: Login Functionality

Scenario Outline: Verify Login Functionality with Multiple Data
			Given user is on the login page of orangehrm
			When user enter username as <username> and password as <password>
			And user hit login button
			Then login validation message should display as <expectedResult>
			
Examples:
			|username | password | 	expectedResult |
			|admin    | admin123 | Dashboard       |
			|adminn   | sdf123   | Invalid credentials  |
			|azxsdd   | aswe3421 | Invalid credentials  |