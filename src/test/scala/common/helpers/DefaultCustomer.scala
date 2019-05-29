package common.helpers

case class DefaultCustomer  (
    firstName: String = "Terry",
    lastName: String = "Jones",
    price: Int = 1000,
    deposit: Boolean = true,
    checkIn: String = "2019-08-01",
    checkOut: String = "2019-08-31"
) extends Booking
