package bdd.stepDefs

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith


@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/scala/bdd"),
  glue = Array("bdd/stepDefs"),
  plugin = Array("html:target/cucumber-html-report", "json:target/cucumber-json-report.json"),
  tags = Array("@all")
)
class RunCucumber {

}

