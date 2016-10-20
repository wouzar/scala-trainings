package Extractors

object Main extends App {

  def multipleFieldsExtractorSample = {
    val user: User = new FreeUser("Daniel", 3000, 0.8d)
    user match {
      case FreeUser(name, _, p) =>
        if (p > 0.75) s"$name , what can we do for you today?"
        else s"Hello $name"
      case PremiumUser(name, _) => s"Welcome back, dear $name"
    }
  }

  def caseClassesExtractorSample = {
    val user: User = Administrator("Victor", 10000)
    user match {
      case Administrator(name, _) => s"Hi, $name"
      case Moderator(name, _) => s"Hey there, $name"
    }
  }

  def booleanExtractorSample = {
    val user: User = new FreeUser("Marshal", 2500, 0.9d)
    user match {
      case freeUser@premiumCandidate() => initiateSpamProgram(freeUser)
      case _ => sendRegularNewsletter(user)
    }

    def initiateSpamProgram(freeUser: FreeUser) = "initiate"
    def sendRegularNewsletter(user: User) = "send"
  }

  def infixOperatorExample = {
    val xs = 58 #:: 43 #:: 93 #:: Stream.empty
    xs match {
      case #::(first, #::(second, _)) => first - second
      case _ => -1
    }
  }

}