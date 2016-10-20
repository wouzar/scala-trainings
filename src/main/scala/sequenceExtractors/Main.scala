package sequenceExtractors

object Main extends App {

  def f1 = {
    val xs = 3 :: 6 :: 12 :: Nil
    xs match {
      case List(a, b) => a * b
      case List(a, b, c) => a + b + c
      case _ => 0
    }
  }

  def f2 = {
    val xs = 3 :: 6 :: 12 :: 24 :: Nil
    xs match {
      case List(a, b, _*) => a * b
      case _ => 0
    }
  }

  def greetWithFirstName(name: String) = name match {
    case GivenNames(firstName, _*) => s"Good morning, $firstName!"
    case _ => "Welcome! Please make sure to fill in your name!"
  }
}

object GivenNames {
  def unapplySeq(name: String): Option[Seq[String]] = {
    val names = name.trim.split(" ")
    if (names.forall(_.isEmpty)) None else Some(names)
  }
}


