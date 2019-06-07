# Cucumber-scala Test of Equal Experts Hotel Booking Test Site

## Driver Installation.

Prior to running the tests, make sure either chromedriver or firefox is installed locally.

You may need to change the pathway to chromedriver in 

`/Users/andrewcadman/Desktop/projects/equalExperts/src/test/scala/common/browsers/BrowserDrivers.scala`

Alternatively, you can start chromedriver via a terminal and leave it running.


## The Tests

The tests here are meant to show the style and general competence in written automated tests in scala and of course
are by no means exhaustive. Nor is the framework anywhere near complete.

The two cucumber features give various scenarios for incomplete booking, testing that records are
not saved in the eventuality of all required information being present.

A second feature gives a happy path scenario when a booking record is successful created and then deleted.

## Running the Tests

The cucumber tests can be run directly by running sbt in the root
directory of the project.

`sbt compile`

`sbt cucumber`

will run two features included.

The browser driver is currently set to chromedriver in the build.sbt file.
You can change this to firefox if required.

## Further Improvements

The features are of course a very small subset of those that could be written.

Further features could include:

1. Making sure it was impossible to submit a booking when either the arrival or departure date was in the past.
2. Making sure it was impossible to submit a booking when the departure date was before the arrival date.
3. Making sure it that erroneous data types (for instance letters in the deposit field) could not be used.
4. Use of an 'After hook' to make sure any records submitted are deleted at the end of the test run.

