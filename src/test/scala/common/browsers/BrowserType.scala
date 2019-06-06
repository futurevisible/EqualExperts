package common.browsers

import common.config.ServerConfiguration
import org.openqa.selenium.WebDriver
import org.scalatest.selenium.WebBrowser


trait BrowserType extends ServerConfiguration with WebBrowser
{
  implicit lazy val webDriver: WebDriver = BrowserType.webDriver
}

object BrowserType extends ServerConfiguration  {
  implicit lazy val webDriver: WebDriver = properties.get("driver") match {
    case Some("chrome") => new Chrome().driver
    case Some("firefox") => new Firefox().driver
    case _ => new Chrome().driver
  }
}
