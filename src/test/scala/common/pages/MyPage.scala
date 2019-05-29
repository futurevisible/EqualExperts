package common.pages

import common.browsers.BrowserType
import org.scalatest.selenium.WebBrowser

trait MyPage extends BrowserType with WebBrowser {

    implicit val title: String

    def goToPage(): Unit = go to "http://hotel-test.equalexperts.io/"

    def existsOnPage(expectedText: String): Boolean = webDriver.getPageSource.contains(expectedText)

}
