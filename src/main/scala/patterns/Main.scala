package patterns

case class Player(name: String, score: Int)

object Main extends App {

  def simplePatternMatching = {
    def message(player: Player) = player match {
      case Player(_, score) if score > 100000 => "Get a job, dude!"
      case Player(name, _) => s"Hey $name, nice to see you again!"
    }
    def printMessage(player: Player) = println(message(player))
  }

  def caseClassUnpacking = {
    // it is a good idea to make sure that your pattern always matches
    def currentPlayer(): Player = Player("Daniel", 3500)
    val Player(name, _) = currentPlayer()
    doSomethingWithTheName(name)
    def doSomethingWithTheName(name: String) = println(name)

    // rises MatchError because of wrong matching
    def scores: List[Int] = List()
    val best :: rest = scores
    println(s"The score of our champion is $best")

  }


  def tupleUnpacking = {
    def gameResult(): (String, Int) = ("Daniel", 3500)

    val result = gameResult()
    // accessing the fields of a tuple always feels very awkward
    println(s"${result._1}:${result._2}")
    val (name, score) = gameResult()
    println(s"$name:$score")
  }

  def forComprehensions = {
    def gameResults(): Seq[(String, Int)] =
      ("Daniel", 3500) :: ("Melissa", 13000) :: ("John", 7000) :: Nil

    def hallOfFame = for {
      (name, score) <- gameResults()
      if score > 5000
    } yield name
  }

  def filteringWithMatching = {
    val lists = List(1,2,3) :: List.empty :: List(5,3) :: Nil

    for {
      list @ head :: _ <- lists
    } yield list.size
  }

}



















