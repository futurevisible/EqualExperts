Feature: one or more customers attempt to book the Equal Experts hotel with incomplete
  information.

  Background: Arrival on the booking landing page
    Given a new customer lands on the hotel booking page

  Scenario: A new booking is made lacking the customers first name
    When the customer fills in the required information except for first name
    Then submission of the booking form fails

  Scenario: A new booking is made lacking the customer last name
    When the customer fills in the required information except for last name
    Then submission of the booking form fails

  Scenario: A new booking is made lacking the customer deposit
    When the customer fills in the required information except for deposit
    Then submission of the booking form fails

  Scenario: A new booking is made lacking the customer arrival date
    When the customer fills in the required information except for deposit
    Then submission of the booking form fails

  Scenario: A new booking is made lacking the customer departure date
    When the customer fills in the required information except for deposit
    Then submission of the booking form fails


