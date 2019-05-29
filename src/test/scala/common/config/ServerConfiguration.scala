package common.config

/**
  * Created by andrewcadman on 16/06/2016.
  */

import scala.sys.SystemProperties

trait ServerConfiguration {

  val properties = new SystemProperties()
  val serverConfig: ServerConfig = properties.get("server") match {
    case _ => NotProdServerConfig
  }

  def baseUrl : String = serverConfig.baseUrl

}

abstract class ServerConfig {
  def baseUrl: String

  def initialise() {
    println(toString)
  }
}

object NotProdServerConfig extends ServerConfig {
  override def baseUrl = "http://hotel-test.equalexperts.io/"

  initialise()
}

