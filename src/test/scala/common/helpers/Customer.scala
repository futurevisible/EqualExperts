package common.helpers

case class Customer  (
  firstName: Option[String],
  lastName: Option[String],
  price: Option[Int],
  deposit: Option[Boolean],
  checkIn: Option[String],
  checkOut: Option[String]
)
