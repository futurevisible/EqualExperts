package common.browsers

/**
  * Created by andrewcadman on 16/06/2016.
  */

import java.io.File

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver

class Firefox {
  val driver: WebDriver =  new FirefoxDriver()
  sys addShutdownHook {
    driver.close()
  }
}

class Chrome {
  //  val cfile: File=new File("C:\\Program Files (x86)\\Selenium\\chromedriver.exe")
  val cfile: File=new File("/Applications/chromedriver")
  System.setProperty("webdriver.chrome.driver", System.getProperty("webdriver.chrome.driver", cfile.getAbsolutePath))
  val options: ChromeOptions= new ChromeOptions()
  options.addArguments("--disable-extensions")
  val driver: WebDriver = new ChromeDriver(options)
  sys addShutdownHook {
    driver.close()
  }
}

class IE {
  val cfile: File=new File("C:\\Program Files (x86)\\Selenium\\IEDriverServer.exe")
  System.setProperty("webdriver.ie.driver", cfile.getAbsolutePath)
  val driver: WebDriver = new InternetExplorerDriver()
  sys addShutdownHook {
    driver.close()
  }
}