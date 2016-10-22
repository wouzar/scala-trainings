package sequenceExtractors

object Main extends App {

  def fixedElementsMatching = {
    val xs = 3 :: 6 :: 12 :: Nil
    xs match {
      case List(a, b) => a * b
      case List(a, b, c) => a + b + c
      case _ => 0
    }
  }

  def variableElementsMatching = {
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

  def greet(fullName: String) = fullName match {
    case Names(lastName, firstName, _*) => s"Good morning, $firstName $lastName!"
    case _ => "Welcome! Please make sure to fill in your name!"
  }

}

object GivenNames {
  def unapplySeq(name: String): Option[Seq[String]] = {
    val names = name.trim.split(" ")
    if (names.forall(_.isEmpty)) None else Some(names)
  }
}

object Names {
  def unapplySeq(name: String): Option[(String, String, Array[String])] = {
    val names = name.trim.split(" ")
    if (names.size < 2) None
    else Some((names.last, names.head, names.drop(1).dropRight(1)))
  }
}

