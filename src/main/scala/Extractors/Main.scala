package Extractors

object Main extends App {
  val user: User = new PremiumUser("Daniel")
  val result = user match {
    case FreeUser(name) => s"Welcome back, dear $name"
    case PremiumUser(name) => s"Hello $name"
  }
  println(result)

  val cUser: User = cPremiumUser("Victor")
  val anotherResult = cUser match {
    case cPremiumUser(name) => s"Hi, $name"
    case cFreeUser(name) => s"Hey there, $name"
  }
  println(anotherResult)
}
