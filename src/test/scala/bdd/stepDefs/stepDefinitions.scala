package bdd.stepDefs

import common.helpers.{Booking, DefaultCustomer}
import common.pages._
import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

import scala.collection.mutable.{Map => MutableMap}

class stepDefinitions extends ScalaDsl with EN with Matchers {

//  System.setProperty("driver", System.getenv.get("driver"))
//  System.setProperty("server", System.getenv.get("server"))

  LandingPage.setCaptureDir("../../../screenshots/")

  implicit val browser = common.browsers.BrowserType.webDriver

  //vars for later test expectations added to this mutable map
  var expectationVars = MutableMap[String, String]()
  //  persons personal details
  val customer: Booking = DefaultCustomer()

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
//  After() { s =>
//
//  }

  Given("""^a new customer lands on the hotel booking page""") { () =>
      LandingPage.goToPage()
      Thread.sleep(4000)
  }

}
