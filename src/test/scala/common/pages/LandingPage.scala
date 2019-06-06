package common.pages

import common.helpers.{Booking, Customer}

object LandingPage extends PageInfo with MyPage with Booking {

  val pi = info(this)
  val url = pi._1
  val title = pi._2

  def navigateToPage(): Unit = {
    goToPage(url)
  }

  def completeForm(customer: Customer): Unit = {
      setFirstName(customer.firstName)
      setLastName(customer.lastName)
      setPrice(customer.price)
      setDeposit(customer.deposit)
      setCheckIn(customer.checkIn)
      setCheckOut(customer.checkOut)
  }

  def fillInWithOneMissingField(missingFieldName: String, completeCustomer: Customer): Unit = {
    missingFieldName match {
      case "first name" => completeForm(Customer(
                                          None,
                                          completeCustomer.lastName,
                                          completeCustomer.price,
                                          completeCustomer.deposit,
                                          completeCustomer.checkIn,
                                          completeCustomer.checkOut
                                          )
                                        )
      case "last name" => completeForm(Customer(
                                          completeCustomer.firstName,
                                          None,
                                          completeCustomer.price,
                                          completeCustomer.deposit,
                                          completeCustomer.checkIn,
                                          completeCustomer.checkOut
                                          )
                                        )
      case "price" => completeForm(Customer(
                                          completeCustomer.firstName,
                                          completeCustomer.lastName,
                                          None,
                                          completeCustomer.deposit,
                                          completeCustomer.checkIn,
                                          completeCustomer.checkOut
                                          )
                                  )
      case "deposit" => completeForm(Customer(
                                          completeCustomer.firstName,
                                          completeCustomer.lastName,
                                          completeCustomer.price,
                                          None,
                                          completeCustomer.checkIn,
                                          completeCustomer.checkOut
                                          )
                                  )
      case "arrival date" => completeForm(Customer(
                                        completeCustomer.firstName,
                                        completeCustomer.lastName,
                                        completeCustomer.price,
                                        completeCustomer.deposit,
                                        None,
                                        completeCustomer.checkOut
                                        )
                                  )
      case "departure date" => completeForm(Customer(
                                        completeCustomer.firstName,
                                        completeCustomer.lastName,
                                        completeCustomer.price,
                                        completeCustomer.deposit,
                                        completeCustomer.checkIn,
                                        None
                                        )
                                  )
    }
  }

  def numberOfCustomerRecords(customer: Customer): Int = {
    def furtherChecks(customer: Customer): Int = {
      // we need to check that a completed customer record is present in the booking.
      val firstName = customer.firstName.getOrElse(throw new RuntimeException("Always should be a complete customer record"))
      val lastName = customer.lastName.getOrElse(throw new RuntimeException("Always should be a complete customer record"))
      val price = customer.price.getOrElse(throw new RuntimeException("Always should be a complete customer record"))
      val checkIn = customer.checkIn.getOrElse(throw new RuntimeException("Always should be a complete customer record"))
      val checkOut = customer.checkOut.getOrElse(throw new RuntimeException("Always should be a complete customer record"))

      val parentElementXPath = "//div[contains(@class, 'col-md-2')]/p[contains(text(),'" + lastName + "' )]/../.."
      val listOfPotentialParentsContainingCustomers = returnElementsViaValue(parentElementXPath)

      var counter = 0
      for (potentialParent <- listOfPotentialParentsContainingCustomers) {
        val textInParent = potentialParent.getText

        val containsFirstName: Boolean = textInParent.contains(firstName)
        val containsPrice: Boolean = textInParent.contains(price.toString)
        val containsCheckIn: Boolean = textInParent.contains(checkIn)
        val containsCheckOut: Boolean = textInParent.contains(checkOut)

        //if the enclosing parent contains all the freeform booking info, then increment the number of found records
        if (containsFirstName && containsPrice && containsCheckIn && containsCheckOut) {
          counter = counter + 1
        }
      }
      counter
    }

    val firstNameXPath = "//div[contains(@class, 'col-md-2')]/p[contains(text(),'" + customer.firstName.getOrElse("") + "')]"
    // first we find whether we can find a form element that contains the first name
    waitForCompletion()
    val recordOfFirstNameExists = waitForElementToBeVisible(firstNameXPath)

    recordOfFirstNameExists match {
      case true => furtherChecks(customer)
      case false => 0
    }

  }

//  setters
  def setFirstName(firstName: Option[String]): Unit = {
    firstName match {
      case Some(fName) => setInputElement("firstname", fName)
      case None => doNothing()
    }
  }

  def setLastName(lastName: Option[String]): Unit = {
    lastName match {
      case Some(lName) => setInputElement("lastname", lName)
      case None => doNothing()
    }
  }

  def setPrice(price: Option[Int]): Unit = {
    price match {
      case Some(p) => setInputElement("totalprice", p.toString)
      case None => doNothing()
    }
  }

  def setDeposit(firstName: Option[Boolean]): Unit = {
    firstName match {
      case Some(dep) =>
      case None => doNothing()
    }
  }

  def setCheckIn(checkInDate: Option[String]): Unit = {
    checkInDate match {
      case Some(cInDate) => setInputElement("checkin", cInDate)
      case None => doNothing()
    }
  }

  def setCheckOut(checkOutDate: Option[String]): Unit = {
    checkOutDate match {
      case Some(cOutDate) => setInputElement("checkout", cOutDate)
      case None => doNothing()
    }
  }

  def saveBooking(): Unit = {
    clickElementUsingXpath("//*[@id='form']/div/div[7]/input")
  }

  def deleteBooking(customer : Customer): Unit = {
    val xPath = "//div[contains(@class, 'col-md-2')]/p[contains(text(),'" + customer.lastName.getOrElse(throw new RuntimeException("Always should be a complete customer record")) +"' )]/../..//div[contains(@class, 'col-md-1')]//input[@value = 'Delete']"
    clickElementUsingXpath(xPath)
  }

  def doNothing(): Unit = {}

}
