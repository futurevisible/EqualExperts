@incomplete_information
Feature: one or more customers attempt to book the Equal Experts hotel with incomplete
  information.

  Background:
    Given a new customer lands on the hotel booking page

  Scenario: A new booking is made lacking the booking first name
    When the customer fills in the required information except for the first name
    Then submission of the booking form fails

  Scenario: A new booking is made lacking the booking last name
    When the customer fills in the required information except for the last name
    Then submission of the booking form fails

  Scenario: A new booking is made lacking the booking price
    When the customer fills in the required information except for the price
    Then submission of the booking form fails

  Scenario: A new booking is made lacking the booking arrival date
    When the customer fills in the required information except for the arrival date
    Then submission of the booking form fails

  Scenario: A new booking is made lacking the booking departure date
    When the customer fills in the required information except for the departure date
    Then submission of the booking form fails





