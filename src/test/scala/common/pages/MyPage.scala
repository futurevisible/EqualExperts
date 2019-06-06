package common.pages

import common.browsers.BrowserType
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium.{By, WebElement}
import org.scalatest.selenium.WebBrowser

import scala.collection.JavaConverters._
import scala.collection.mutable

trait MyPage extends BrowserType with WebBrowser {

    implicit val title: String

    def goToPage(url: String): Unit = go to url

    def waitForCompletion(): Boolean = {
        new WebDriverWait(webDriver, 10).until(
            ExpectedConditions.jsReturnsValue("return jQuery.active == 0 && document.readyState === 'complete'")
        )
        true
    }

    def waitForElementToBeVisible(xP: String): Boolean = {
        try {
            val wait = new WebDriverWait(webDriver, 10)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xP)))
        } catch {
            case e: Exception => return false
        }

        true
    }

    def returnElementsViaValue(xP: String): mutable.Buffer[WebElement] = asScalaBuffer(webDriver.findElements(By.xpath(xP)))

    def existsOnPage(expectedText: String): Boolean = webDriver.getPageSource.contains(expectedText)

    def clickElementUsingXpath(xP: String): Unit = webDriver.findElement(By.xpath(xP)).click()

//  setters
    def setInputElement(elementID: String, elementValue: String): Unit = webDriver.findElement(By.id(elementID)).sendKeys(elementValue)

}
