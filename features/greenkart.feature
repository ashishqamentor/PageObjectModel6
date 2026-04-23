Feature: End to end Checkout journey.

Scenario: To verify checkout journey.
Given user is on greenkart site.
When user add vegitable in basket.
Then user do checkout.
And successfull message is displyed.
