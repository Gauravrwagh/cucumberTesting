Feature: verify PIM Module

Scenario Outline: Test PIM functionality 

Given user on loginpage
When user submit credentials 
And user enter details employename as <empName> and employeeId as <empID>
Then user click on searchfield
And verify record avilibity message <expectedResult>

Examples:
					| empName | empID | expectedResult   |
					| ram     | 111   | (1) Record Found |
					| shiv    | 100   | No Records Found |

