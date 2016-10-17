package Extractors

trait User {
  def name: String // Why def?
  def score: Int
}
class FreeUser(val name: String, val score: Int, val upgradeProbability: Double) extends User
class PremiumUser(val name: String, val score: Int) extends User

object FreeUser {
  def unapply(user: FreeUser): Option[(String, Int, Double)] =
    Some(user.name, user.score, user.upgradeProbability)
}
object PremiumUser {
  def unapply(user: PremiumUser): Option[(String, Int)] =
    Some(user.name, user.score)
}

// no need to implement unapply method for case classes
case class Administrator(name: String, score: Int) extends User
case class Moderator(name: String, score: Int) extends User