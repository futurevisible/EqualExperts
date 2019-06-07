package bdd.stepDefs

import java.lang.System._

import common.helpers.Customer
import common.pages._
import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

class stepDefinitions extends ScalaDsl with EN with Matchers {

  setProperty("driver", System.getenv("driver"))


  //  persons personal details
  val defaultCustomer: Customer = Customer(
                                            Some("Terry"),
                                            Some("Jones"),
                                            Some(1000),
                                            Some(true),
                                            Some("2019-08-01"),
                                            Some("2019-08-31")
                                          )

  /**
    * Hook run BEFORE each scenario.
    * In future may need to add endpoint action to destroy cases prior to
    * each scenario being run.
    * Longer term tests should be able to work without data destruction
    * as this is a much better pattern for parallelisation
    * Probably don't want to start up the app prior to each scenario so
    * commands commented out at present.
    */
//  Before() { s =>
//    println("before!")
//  }

  /**
    * Hook run AFTER each scenario.
    * Probably don't want to shut down the app prior to each scenario so
    * commands commented out at present.
    */
//  TODO: make sure any booking records reaped from the page via deletion. Tests must be stateless.
//  After() { s =>
//
//  }

  Given("""^a new customer lands on the hotel booking page""") { () =>
      LandingPage.navigateToPage()
      LandingPage.waitForCompletion()
  }

  When("""^the customer fills in the required information except for the (.*)""") { field: String =>
    LandingPage.fillInWithOneMissingField(field, defaultCustomer)
    LandingPage.waitForCompletion()
  }

  Then("""submission of the booking form (.*)""") { submissionState: String =>
    val expectedResult: Int = submissionState match {
      case "succeeds" => 1
      case "fails" => 0
    }
    LandingPage.saveBooking()
    LandingPage.waitForCompletion()
    assert(LandingPage.numberOfCustomerRecords(defaultCustomer) == expectedResult)
  }

  Then("""the customer fills in the required information with no exceptions""") { () =>
    LandingPage.completeForm(defaultCustomer)
    LandingPage.waitForCompletion()
  }

  When("""the customer opts to delete the booking""") { () =>
    LandingPage.deleteBooking(defaultCustomer)
    LandingPage.waitForCompletion()
  }

  Then("""the record is removed from the booking page""") { () =>
    LandingPage.waitForCompletion()
    assert(LandingPage.numberOfCustomerRecords(defaultCustomer) == 0)
  }

}
