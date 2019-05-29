package common.pages

object LandingPage extends PageInfo {

  val pi = info(this)
  val url = baseUrl + pi._1
  val title = pi._2

}
