import Extractors._

// single field in Extractor
val user1: User = new FreeUser("Daniel", 3000, 0.8d)
user1 match {
  case FreeUser(name, _, p) =>
    if (p > 0.75) s"$name , what can we do for you today?"
    else s"Hello $name"
  case PremiumUser(name, _) => s"Welcome back, dear $name"
}

// Multiple fields in extractor
val user2: User = Administrator("Victor", 10000)
val anotherResult = user2 match {
  case Administrator(name, _) => s"Hi, $name"
  case Moderator(name, _) => s"Hey there, $name"
}

// Boolean extractor
val user3: User = new FreeUser("Marshal", 2500, 0.9d)
user3 match {
  case freeUser @ premiumCandidate() => initiateSpamProgram(freeUser)
  case _ => sendRegularNewsletter(user3)
}

def initiateSpamProgram(freeUser: FreeUser) = "initiate"
def sendRegularNewsletter(user: User) = "send"