package common.pages

trait PageInfo extends MyPage {
  def info(pageType: AnyRef): (String,String) = {
    pageType match {
      case _ => ("", "Landing Page")
    }
  }
}
