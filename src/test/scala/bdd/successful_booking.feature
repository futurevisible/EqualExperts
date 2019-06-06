@end_to_end @success
Feature: a customer successfully completes a booking and then deletes the returned information

Scenario: A new booking is made with all the required information
  Given a new customer lands on the hotel booking page
  When the customer fills in the required information with no exceptions
  Then submission of the booking form succeeds

  When the customer opts to delete the booking
  Then the record is removed from the booking page