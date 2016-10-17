package Extractors

object Main extends App {
  val user: User = new FreeUser("Daniel", 3000, 0.8d)
  val result = user match {
    case FreeUser(name, _, p) =>
      if (p > 0.75) s"$name , what can we do for you today?"
      else s"Hello $name"
    case PremiumUser(name, _) => s"Welcome back, dear $name"
  }
  println(result)

  val anotherUser: User = Administrator("Victor", 10000)
  val anotherResult = anotherUser match {
    case Administrator(name, _) => s"Hi, $name"
    case Moderator(name, _) => s"Hey there, $name"
  }
  println(anotherResult)
}
