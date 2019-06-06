package common.helpers

trait Booking {
  def setFirstName(fN: Option[String]): Unit
  def setLastName(lN: Option[String]): Unit
  def setPrice(p: Option[Int]): Unit
  def setDeposit(d: Option[Boolean]): Unit
  def setCheckIn(cIn: Option[String]): Unit
  def setCheckOut(cOut: Option[String]): Unit
}


