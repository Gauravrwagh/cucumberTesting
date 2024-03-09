Feature: registration Functionality
  
  Scenario Outline: verify User Registration Functionality
  Given user is on the opencart WebPage
  When user select register option
  Then user enters details <username> <firstname> <lastname> <email> <password>
  Then user select country from dropdown <country>
  And user fill captcha manually 
  And user click on Register button
  Then user should see message <statusMessage>
  And user click on continue button
  #Then user is on login page
  #And user enter email and password
  #And user click on login button
  #Then user should see login successfull message

 Examples: 
 		|username   | firstname    | lastname      | email              | password  | country | statusMessage |
 	  |@qwerre12  | MunnaDon     | Khureshiuncle | munna591@gmail.com | Munna@123 | India | Welcome to OpenCart, your account has been created |
 	 