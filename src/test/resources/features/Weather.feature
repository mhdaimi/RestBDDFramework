Feature: Check Bitcoin Price

Scenario: Check Bitcoin Price
Given There is a rest api to check crypto price
When I provide Bitcoin
Then I get price information