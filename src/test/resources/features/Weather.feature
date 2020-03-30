Feature: Check weather of a city

Scenario: Check weather of city
Given There is a rest api
When I provide a city name
Then I get weather information