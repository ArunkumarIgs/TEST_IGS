Feature: Fund transfer functionality

 Scenario: Transfer funds between own accounts
 
 Given I login into the site with the registered username and password
 Then the user checks the account balance
 When the user transfers amount dollars to own account
 Then the user should see a confirmation message
 When the user searches for transactions using the current date
 Then the user should find the transaction for amount dollars