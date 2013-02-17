package test
import scala.actors.Actor

class HiActor extends Actor {
  
  def act() {
    while(true) {
      receive {
        case "Hi" => println("Hi, guy!")
        case _ => println("Fuck you!")
      }
    }
  }
  
}

object Actors extends App {
  val actor01 = new HiActor
  actor01.start()
  
  actor01 ! "Hi"
  actor01 ! "Salut"
}