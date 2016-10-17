package Extractors

trait User {
  def name: String
}
class FreeUser(val name: String) extends User
class PremiumUser(val name: String) extends User

object FreeUser {
  def unapply(user: FreeUser): Option[String] = Some(user.name)
}
object PremiumUser {
  def unapply(user: PremiumUser): Option[String] = Some(user.name)
}

case class cFreeUser(name: String) extends User
case class cPremiumUser(name: String) extends User