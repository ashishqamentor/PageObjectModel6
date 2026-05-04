Feature: to verify login functionality

Scenario Outline: To verify login.
Given user is on sause demo site.
When user enters <username> and <password>
And click on login
Then inventory page should display with url "https://www.saucedemo.com/inventory.html"

Examples:
  | username 				| password 			   | 
  | standard_user          	| secret_sauce         | 
  | locked_out_user         | secret_sauce         | 
  | problem_user          	| secret_sauce         | 
  | performance_glitch_user	| secret_sauce         | 
  | error_user          	| secret_sauce         | 
  | visual_user         	| secret_sauce         | 
  