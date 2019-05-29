import sbt.Keys._

lazy val root = (project in file("."))
  .settings(
      name := "equalExperts",
        scalaVersion := "2.12.8",
        version      := "0.1.0-SNAPSHOT"
  )


resolvers += "Spring Plugins" at "http://repo.spring.io/plugins-release/"

libraryDependencies += "org.scala-lang" % "scala-library" % scalaVersion.value
libraryDependencies += "io.cucumber" %% "cucumber-scala" % "4.3.1"
libraryDependencies += "io.cucumber" % "cucumber-junit" % "4.3.1"
libraryDependencies += "org.seleniumhq.selenium" % "selenium-java" % "3.141.59"
libraryDependencies += "org.openqa.selenium.webdriver" % "webdriver-common" % "0.6.1039"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0-SNAP10" % Test
libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.8"